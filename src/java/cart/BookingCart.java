/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entities.Booking;
import entities.Seat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class BookingCart {

    List<BookingCartItem> persons;
    private double total;
    private double adultDiscount;
    private double childDiscount;
    private double infantDiscount;

    public BookingCart() {
        persons = new ArrayList<>();
        total = 0.0;
        adultDiscount = 1.0;
        childDiscount = 0.5;
        infantDiscount = 0.25;
    }

    public List<BookingCartItem> getPersons() {
        return persons;
    }

    public double getAdultDiscount() {
        return adultDiscount;
    }

    public void setAdultDiscount(double adultDiscount) {
        this.adultDiscount = adultDiscount;
    }

    public double getChildDiscount() {
        return childDiscount;
    }

    public void setChildDiscount(double childDiscount) {
        this.childDiscount = childDiscount;
    }

    public double getInfantDiscount() {
        return infantDiscount;
    }

    public void setInfantDiscount(double infantDiscount) {
        this.infantDiscount = infantDiscount;
    }

    public double getTotal() {
        return total;
    }

    public double getSubtotal() {
        double amount = 0;
        Booking booking = new Booking();
        Seat seat = new Seat();
        amount = (booking.getNoOfAdults() * seat.getSeatPrice() * adultDiscount) + (booking.getNoOfChildren() * seat.getSeatPrice() * childDiscount) + (booking.getNoOfInfants() * seat.getSeatPrice() * infantDiscount);
        return amount;
    }

    public void clear() {
        persons.clear();
        total = 0;
    }

//    public double calculateOverallTotal(BookingCart bookingCart) {
//        double overallTotal = 0;
//        for (BookingCartItem bookingCartItem : persons) {
//            double itemTotal = bookingCartItem.getTotal();
//            overallTotal += itemTotal;
//        }
//        return (overallTotal);
//    }

    public String getOverallTotalCurrencyFormat(double total) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(getSubtotal());
    }
}
