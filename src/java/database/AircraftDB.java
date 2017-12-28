/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entities.Aircraft;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author james
 */
public class AircraftDB {

    public static Aircraft selectAicraft(int aircraftId) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String qString = "SELECT a FROM Aircraft a WHERE a.aircraftId = :aircraftId";
        TypedQuery<Aircraft> tq = em.createQuery(qString, Aircraft.class);
        tq.setParameter("aircraftId", aircraftId);
        Aircraft result = null;
        try {
            result = tq.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } finally {
            em.close();
        }
        return (Aircraft) result;
    }

    public static Aircraft selectAircraftById(int aircraftId) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        return em.find(Aircraft.class, aircraftId);
    }

    public static List<Aircraft> selectAircrafts() {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String qString = "SELECT a from Aircraft a";
        TypedQuery<Aircraft> tq = em.createQuery(qString, Aircraft.class);
        List<Aircraft> results = null;
        try {
            results = tq.getResultList();
        } catch (NoResultException nre) {
            return null;
        } finally {
            em.close();
        }
        return results;
    }
}
