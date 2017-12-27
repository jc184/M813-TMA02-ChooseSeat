/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author james
 */
public class tests {

    //static SeatManager seatManager = new SeatManager();
    private static int seatNumber;
    private static boolean[] seats = new boolean[24];
    public static void main(String[] args) {
        for (boolean seat : seats) {
            do {    
            Random random = new Random();
            int economySeat = random.nextInt(23 - 12 + 1) + 12;
            seatNumber = economySeat;
            } while (Arrays.asList(seats).contains(false));
        }
        System.out.println(seatNumber);
    }
}
