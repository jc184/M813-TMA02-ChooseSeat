/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entities.Seat;
import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 *
 * @author james
 */
public class BookingCartItem {

    Seat seat;

    public BookingCartItem(Seat seat) {
        this.seat = seat;
    }

    public BookingCartItem() {
    }

    public Seat getSeat() {
        return seat;
    }

    public double getTotal() {
        double amount = 0.0;
        amount = seat.getSeatPrice();
        return amount;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
