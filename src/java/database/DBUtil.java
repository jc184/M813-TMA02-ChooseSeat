/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author james
 */
public class DBUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("M813-TMA02-ChooseSeatPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}
