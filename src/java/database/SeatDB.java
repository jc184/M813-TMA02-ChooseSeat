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
import model.entities.Booking;
import model.entities.Seat;
import model.entities.SeatPK;

/**
 *
 * @author james
 */
public class SeatDB {

    public static Seat selectSeat(SeatPK seatPK) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String qString = "SELECT s FROM seat s WHERE (s.seatNumber = :seatNumber) AND (s.aircraftId = :aircraftId)";
        TypedQuery<Seat> tq = em.createQuery(qString, Seat.class);
        tq.setParameter("seatPK", seatPK);
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
        String qString = "SELECT op from ordered_product op";
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

    public static Seat addSeat(SeatPK seatPK, String seatType, Booking bookingId, boolean booked) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        Seat seat = new Seat();
        int seatNumber = 0;
        int aircraftId = 0;
        
        seatPK.setSeatNumber(seatNumber);
        seatPK.setAircraftId(aircraftId);

        seat.setSeatType(seatType);
        seat.setBookingId(bookingId);
        seat.setBooked(booked);

        em.persist(seat);
        return seat;
    }
}
