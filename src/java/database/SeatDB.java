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
import entities.Flight;
import entities.Seat;
import entities.SeatPK;
import java.util.Arrays;
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

    public static Seat selectSeat(SeatPK seatPK) {
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

    public static Seat selectSeatById(SeatPK seatPK) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        return em.find(Seat.class, seatPK);
    }

    public static List<Seat> selectSeats() {
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

    public static Seat addSeat(int seatNo, Double seatPrice, Booking bookingId, Flight flightId) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        Seat seat = new Seat();
        SeatPK seatPK = new SeatPK();

        seat.setSeatPK(seatPK);
        seat.setSeatPrice(seatPrice);
        seat.setBooking(bookingId);

        em.persist(seat);
        return seat;
    }

}
