/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import entities.Booking;
import entities.Seat;
import entities.SeatPK;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import model.enums.SeatEnum;

/**
 *
 * @author james
 */
public class SeatDB {

    private final int NUMBER_OF_SEATS = 24;
    private boolean[] seats = new boolean[NUMBER_OF_SEATS];
    private int firstClassCounter;//counter for first class
    private int economyCounter;//counter for economy class
    private boolean isSeatBooked;

    public SeatDB() {

    }

    public int getNUMBER_OF_SEATS() {
        return NUMBER_OF_SEATS;
    }

    public void setSeats(boolean[] seats) {
        this.seats = seats;
    }

    public boolean[] getSeats() {
        return seats;
    }

    public int getFirstClassCounter() {
        return firstClassCounter;
    }

    public int getEconomyCounter() {
        return economyCounter;
    }

    public boolean isIsSeatBooked() {
        return isSeatBooked;
    }

    public void saveSeatingLayout(boolean[] seats) {
        int seatNumber = 0;
        for (SeatEnum seatEnum : SeatEnum.values()) {
            if (seatNumber == seatEnum.ordinal()) {
                this.setSeats(seats);
                Arrays.toString(seats);
            }
        }
    }

    public boolean isSeatBooked(int seatNumber) {
        for (SeatEnum seatEnum : SeatEnum.values()) {
            if (seatNumber == seatEnum.ordinal()) {
                return seats[seatNumber];//WRONG. ALWAYS RETURNS FALSE
            }
        }
        return false;
    }

    public boolean seatsContainsTrue() {
        for (boolean seat : seats) {
            if (seat) {
                return true;
            }
        }
        return false;
    }

    public Seat selectSeat(SeatPK seatPK) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String qString = "SELECT s FROM seat s WHERE (s.seatNumber = :seatNumber) AND (s.flightId = :flightId)";
        TypedQuery<Seat> tq = em.createQuery(qString, Seat.class);
        tq.setParameter("SeatPK", seatPK);
        Seat result = null;
        try {
            result = tq.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } finally {
            em.close();
        }
        return (Seat) result;
    }

    public Seat selectSeatById(SeatPK seatPK) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        return em.find(Seat.class, seatPK);
    }

    public List<Seat> selectSeats() {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String qString = "SELECT s from Seat s";
        TypedQuery<Seat> tq = em.createQuery(qString, Seat.class);
        List<Seat> results = null;
        try {
            results = tq.getResultList();
        } catch (NoResultException nre) {
            return null;
        } finally {
            em.close();
        }
        return results;
    }

    @SuppressWarnings("empty-statement")
    public static Seat addSeat(SeatPK seatPK, Double seatPrice, Booking bookingId) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        try {
            Seat seat = new Seat(seatPK.getSeatNo(), seatPK.getFlightId());

            seat.setSeatPK(seatPK);
            seat.setSeatPrice(75.0);
            seat.setBookingId(bookingId);
            em.persist(seat);
            etx.commit();
            return seat;
        } catch (PersistenceException pe) {

            Throwable t = null;
            for (t = pe.getCause(); t.getCause() != null; t = t.getCause());

            Logger.getLogger(t.getClass().getName()).log(Level.SEVERE, "Exception:{0}", t.getClass());
            System.out.println(pe);
            etx.rollback();
            return null;
        } catch (Exception e) {
            System.out.println(e);
            etx.rollback();
            return null;
        } finally {
            em.close();

        }
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException cnfe) {
            System.err.println("Database driver not found: " + cnfe.getMessage());
        }

        String dbUrl = "jdbc:mysql://localhost:3306/flightbookingsystemv2";
        String dbUser = "root";
        String dbPass = "stcallans";
        Connection connection = null;

        try {
            connection = (Connection) DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException sqle) {
            System.err.println("Unable to connect to Database: [" + sqle.getErrorCode() + "]" + sqle.getMessage());
        }
        return (connection);
    }

    public boolean[] getSeatingLayout(int flightId) throws SQLException {

        boolean[] seatingLayout = new boolean[NUMBER_OF_SEATS];
        Connection connection = getConnection();
        try (PreparedStatement get = (PreparedStatement) connection.prepareStatement(
                    "SELECT * FROM seat WHERE Flight_Id=?")) {
            get.setInt(1, flightId);
            ResultSet results = get.executeQuery();

            ArrayList<Integer> seatNumbers = new ArrayList<>();

            while (results.next()) {
                seatNumbers.add(results.getInt(1));
            }
            
            for (Integer seatNumber : seatNumbers) {
                seatingLayout[seatNumber] = true;
            }
            System.out.println(seatNumbers);
            System.out.println(Arrays.toString(seatingLayout));

            connection.close();
        } catch (SQLException sqle) {
            System.err.println("Unable to get records: [" + sqle.getErrorCode() + "] " + sqle.getMessage());
        }
        return seatingLayout;
    }

}
