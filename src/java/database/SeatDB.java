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

/**
 *
 * @author james
 */
public class SeatDB {

    public static Seat selectSeat(int SeatNo) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String qString = "SELECT s FROM seat s WHERE s.seatNumber = :seatNumber";
        TypedQuery<Seat> tq = em.createQuery(qString, Seat.class);
        tq.setParameter("SeatNo", SeatNo);
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

    public static Seat selectSeatById(int SeatNo) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        return em.find(Seat.class, SeatNo);
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

    public static Seat addSeat(int seatNo, String seatType, Booking bookingId, Flight flightId) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        Seat seat = new Seat();
        int seatNumber = 0;

        seat.setSeatNo(seatNo);
        seat.setSeatType(seatType);


        em.persist(seat);
        return seat;
    }
}
