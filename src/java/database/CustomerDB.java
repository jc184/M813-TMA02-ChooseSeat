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
import entities.Customer;

/**
 *
 * @author james
 */
public class CustomerDB {
    
    public static Customer selectCustomer(String emailAddress) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String qString = "SELECT c FROM Customer c WHERE c.emailAddress = :emailAddress";
        TypedQuery<Customer> tq = em.createQuery(qString, Customer.class);
        tq.setParameter("emailAddress", emailAddress);
        Customer result = null;
        try {
            result = tq.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } finally {
            em.close();
        }
        return result;
    }

    public static Customer selectCustomer(String loginName, String loginPassword) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String qString = "SELECT c FROM Customer c WHERE (c.loginName = :loginName) AND (c.loginPassword = :loginPassword)";
        TypedQuery<Customer> tq = em.createQuery(qString, Customer.class);
        tq.setParameter("loginName", loginName);
        tq.setParameter("loginPassword", loginPassword);
        Customer result = null;
        try {
            result = tq.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } finally {
            em.close();
        }
        return result;
    }

    public static List<Customer> selectCustomers() {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String qString = "SELECT c from Customer c";
        TypedQuery<Customer> q = em.createQuery(qString, Customer.class);
        List<Customer> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return results;
    }
}
