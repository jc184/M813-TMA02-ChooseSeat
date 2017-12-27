/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.io.Serializable;
import java.util.Arrays;
import model.enums.SeatEnum;

/**
 *
 * @author james
 */
public class SeatManager implements Serializable {

    private static final long serialVersionUID = 1L;

//    SeatDataStore seatStore;

    private final int NUMBER_OF_SEATS = 24;
    private boolean[] seats = new boolean[NUMBER_OF_SEATS];
    private int firstClassCounter;//counter for first class
    private int economyCounter;//counter for economy class
    private boolean isSeatBooked;
    private String msg;
    private String url;

    public SeatManager() {
     
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

//    public void addSeatBooking(SeatPK seatPK, String seatType, Booking bookingId, boolean booked) throws ClassNotFoundException {
//        try {
//            for (SeatEnum seatEnum : SeatEnum.values()) {
//                if (seatStore.getRecord(seatEnum.ordinal()) == null) {
//                    Seat seat = new Seat(seatPK, seatType, bookingId, booked);
//                    seatStore.createRecord(seat);
//                }
//            }
//        } catch (ClassCastException cce) {
//            cce.getMessage();
//        }
//    }
//    public boolean[] assignSeat(int seatNumber, SeatTypeEnum seatType) throws ClassNotFoundException {
//
////        if (seatType == SeatTypeEnum.ECONOMY) {
////            economyCounter++;
////            if (economyCounter >= 12) {
////                msg = "All the Economy seats have been used up.";
////                url = "/booked.jsp";
////            }
////        } else if (seatType == SeatTypeEnum.FIRSTCLASS) {
////            firstClassCounter++;
////            if (firstClassCounter >= 12) {
////                msg = "All the First Class seats have been used up.";
////                url = "/chooseeconomy.jsp";
////            } else {
////
////           }
////        }
//        this.getSeats()[seatNumber] = true;
//        return seats;
//    }
//    public boolean[] allocateEconomySeat(SeatTypeEnum seatType) {
//
//        if (economyCounter < 12) {
//            Random random = new Random();
//            int economySeat = random.nextInt(23 - 12 + 1) + 12;
//            int seatNumber = economySeat;
//            if (this.getSeats()[seatNumber] == false) {
//                this.getSeats()[seatNumber] = true;
//                economyCounter++;
//                return seats;
//            } else {
//                msg = "This seat is already booked.";
//            }
//            isSeatBooked = true;
//        } else if (economyCounter >= 12) {
//            msg = "All the Economy seats have been used up.";
//            url = "/booked.jsp";
//        }
//        
//        return seats;
//    }

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

}
