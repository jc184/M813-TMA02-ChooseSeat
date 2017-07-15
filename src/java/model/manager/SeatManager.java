/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import model.enums.SeatTypeEnum;

/**
 *
 * @author james
 */
public class SeatManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int NUMBER_OF_SEATS = 24;
    private boolean[] seats = initSeats();
    private int firstClassCounter;//counter for first class
    private int economyCounter;//counter for economy class
    private boolean isSeatBooked;
    Random randomNumber = new Random();

    public SeatManager() {
        
        this.seats = new boolean[NUMBER_OF_SEATS];//RESETS Seats TO FALSES
        this.seats = initSeats();

    }

//    private void initSeats() {
//        for (int i = 0; i < seats.length; i++) {
//            seats[i] = false;
//        }
//    }
    public boolean[] initSeats() {

        try (FileInputStream fis = new FileInputStream("C:\\Users\\user\\Documents\\seats.ser");
                ObjectInputStream in = new ObjectInputStream(fis)) {
            in.readObject();
            String seatsString = (String) in.readObject();

            seats = (boolean[]) in.readObject();
            in.close();
            System.out.println(Arrays.toString(seats));
        } catch (ClassNotFoundException | IOException e) {
            e.getMessage();
        }
        return seats;
    }
    


    public int getNUMBER_OF_SEATS() {
        return NUMBER_OF_SEATS;
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

    public void writeSeats(ObjectOutputStream oos) {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Documents\\seats.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(seats);
            oos.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void retrieveSeats(ObjectInputStream ois) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\user\\Documents\\seats.ser");
            ois = new ObjectInputStream(fis);
            ois.readObject();

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
    }
}
