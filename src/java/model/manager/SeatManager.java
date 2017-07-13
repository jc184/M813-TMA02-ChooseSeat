/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.util.Random;
import model.enums.SeatTypeEnum;

/**
 *
 * @author james
 */
public class SeatManager {

    private final int NUMBER_OF_SEATS = 24;
    private boolean[] seats;
    private int firstClassCounter;//counter for first class
    private int economyCounter;//counter for economy class
    private boolean isSeatBooked;
    Random randomNumber = new Random();

    public SeatManager() {
        this.seats = new boolean[NUMBER_OF_SEATS];
        this.isSeatBooked = true;
        //initSeats();
    }

    private void initSeats() {
        for (int i = 0; i < seats.length; i++) {
            seats[i] = false;
        }
    }

    public boolean[] initSeats(int seatNumber, SeatTypeEnum seatType) {
        for (int i = 0; i < seats.length; i++) {
            seats[i] = false;
        }
        return seats;
    }

    public void fullyBooked() {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] = true) {
                System.out.println("The Flight is fully booked. Please choose another Flight.");
            }
        }
    }

    public static boolean areAllSeatsBooked(boolean[] seats) {
        for (boolean b : seats) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public boolean[] assignSeat(int seatNumber, SeatTypeEnum seatType) {
        if (seatType == SeatTypeEnum.ECONOMY) {
            economyCounter++;
            if (economyCounter > 12) {
                System.out.println("All the Economy seats have been used up.");
            }

        } else if (seatType == SeatTypeEnum.FIRSTCLASS) {
            firstClassCounter++;
            if (firstClassCounter > 12) {
                System.out.println("All the First Class seats have been used up.");
            }

        }

        seats[seatNumber] = true;

        return seats;
    }

}
