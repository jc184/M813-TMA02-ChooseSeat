/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author james
 */
@Entity
@Table(name = "passenger")
@NamedQueries({
    @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p")
    , @NamedQuery(name = "Passenger.findByPassengerId", query = "SELECT p FROM Passenger p WHERE p.passengerId = :passengerId")
    , @NamedQuery(name = "Passenger.findByPassengerName", query = "SELECT p FROM Passenger p WHERE p.passengerName = :passengerName")
    , @NamedQuery(name = "Passenger.findByBaggageItemId", query = "SELECT p FROM Passenger p WHERE p.baggageItemId = :baggageItemId")
    , @NamedQuery(name = "Passenger.findByBaggageItemWeightKg", query = "SELECT p FROM Passenger p WHERE p.baggageItemWeightKg = :baggageItemWeightKg")})
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PassengerId")
    private Integer passengerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PassengerName")
    private String passengerName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BaggageItemId")
    private int baggageItemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BaggageItemWeightKg")
    private int baggageItemWeightKg;
    @JoinColumn(name = "Booking_BookingId", referencedColumnName = "BookingId")
    @ManyToOne(optional = false)
    private Booking bookingBookingId;
    @JoinColumns({
        @JoinColumn(name = "Seat_SeatNo", referencedColumnName = "SeatNo")
        , @JoinColumn(name = "Seat_Flight_FlightId", referencedColumnName = "Flight_FlightId")})
    @ManyToOne(optional = false)
    private Seat seat;

    public Passenger() {
    }

    public Passenger(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Passenger(Integer passengerId, String passengerName, int baggageItemId, int baggageItemWeightKg) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.baggageItemId = baggageItemId;
        this.baggageItemWeightKg = baggageItemWeightKg;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getBaggageItemId() {
        return baggageItemId;
    }

    public void setBaggageItemId(int baggageItemId) {
        this.baggageItemId = baggageItemId;
    }

    public int getBaggageItemWeightKg() {
        return baggageItemWeightKg;
    }

    public void setBaggageItemWeightKg(int baggageItemWeightKg) {
        this.baggageItemWeightKg = baggageItemWeightKg;
    }

    public Booking getBookingBookingId() {
        return bookingBookingId;
    }

    public void setBookingBookingId(Booking bookingBookingId) {
        this.bookingBookingId = bookingBookingId;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passengerId != null ? passengerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) object;
        if ((this.passengerId == null && other.passengerId != null) || (this.passengerId != null && !this.passengerId.equals(other.passengerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Passenger[ passengerId=" + passengerId + " ]";
    }
    
}
