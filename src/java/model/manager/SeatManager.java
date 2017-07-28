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
import javax.persistence.metamodel.SingularAttribute;
import model.entities.Seat;
import model.enums.SeatEnum;
import model.enums.SeatTypeEnum;
import model.DAO.SeatDataStore;
import model.entities.Booking;
import model.entities.SeatPK;
//import static model.entities.Seat_.bookingId;

/**
 *
 * @author james
 */
public class SeatManager implements Serializable {

    private static final long serialVersionUID = 1L;
    private static SeatPK seatPK;

    SeatDataStore seatStore;

    private final int NUMBER_OF_SEATS = 24;
    private boolean[] seats;
    private int firstClassCounter;//counter for first class
    private int economyCounter;//counter for economy class
    private boolean isSeatBooked;
    Random randomNumber = new Random();

    public SeatManager() {

        this.seats = new boolean[NUMBER_OF_SEATS];//RESETS Seats TO FALSES
        this.seats = initSeats();
        seatStore = new SeatDataStore();
    }

    private boolean[] initSeats() {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\user\\Documents\\seats.ser");
                ObjectInputStream in = new ObjectInputStream(fis)) {
            in.readObject();
            seats = (boolean[]) in.readObject();
            in.close();
        } catch (ClassNotFoundException | IOException e) {
            e.getMessage();
        }
        return seats;
    }

    /**
     *
     * @param seatPK the value of seatPK
     * @param seatType the value of seatType
     * @param bookingId the value of bookingId
     * @param booked the value of booked
     * @throws ClassNotFoundException
     */
//    public void addSeatBooking(SeatPK seatPK, SeatTypeEnum seatType, Booking bookingId, boolean booked) throws ClassNotFoundException {
//        for (SeatEnum seatEnum : SeatEnum.values()) {
//            if (seatStore.getRecord(seatEnum.ordinal()) == null) {
//                Seat seat = new Seat(seatPK, seatType, bookingId, booked);
//                seatPK = SeatManager.seatPK;
//                seatStore.createRecord(seat);
//            }
//        }
//    }

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

    public boolean checkNotFullyBooked() {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] = true) {
                return true;
            }
        }
        return false;
    }

    public static boolean areAllSeatsBooked(boolean[] seats) {
        for (boolean b : seats) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public boolean[] assignSeat(int seatNumber, SeatTypeEnum seatType) throws ClassNotFoundException {
        if (seatType == SeatTypeEnum.ECONOMY) {
            economyCounter++;
            if (economyCounter > 12) {
                System.out.println("All the Economy seats have been used up.");
            } 
        } else if (seatType == SeatTypeEnum.FIRSTCLASS) {
            firstClassCounter++;
            if (firstClassCounter > 12) {
                System.out.println("All the First Class seats have been used up.");
            } else {
                SingularAttribute<Seat, Booking> bookingId = null;
                addSeatBooking((SingularAttribute<Seat, SeatPK>) seatPK, seatType, bookingId, isSeatBooked);
                
            }
        }
        //seats[seatNumber] = true;
        this.getSeats()[seatNumber] = true;//STILL WRONG!
        //this.setSeats(seats);//STILL WRONG!

        return seats;
    }

    public void saveSeatingLayout(boolean[] seats) {
        int seatNumber = 0;
        for (SeatEnum seatEnum : SeatEnum.values()) {
            if (seatNumber == seatEnum.ordinal()) {
                setSeats(seats);
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

    private void addSeatBooking(SingularAttribute<Seat, SeatPK> seatPK, SeatTypeEnum seatType, SingularAttribute<Seat, Booking> bookingId, boolean seatBooked) throws ClassNotFoundException {
        try {
            for (SeatEnum seatEnum : SeatEnum.values()) {
                if (seatStore.getRecord(seatEnum.ordinal()) == null) {
                    Seat seat = new Seat(seatPK, seatType, bookingId, seatBooked);
                    seatPK = (SingularAttribute<Seat, SeatPK>) new SeatPK();
                    seatStore.createRecord(seat);
                }
            }
        } catch (ClassCastException cce) {
            cce.getMessage();
        }

    }
}
