/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author james
 */
@Entity
@Table(name = "seat")
@NamedQueries({
    @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s")
    , @NamedQuery(name = "Seat.findBySeatNo", query = "SELECT s FROM Seat s WHERE s.seatPK.seatNo = :seatNo")
    , @NamedQuery(name = "Seat.findByFlightFlightId", query = "SELECT s FROM Seat s WHERE s.seatPK.flightFlightId = :flightFlightId")
    , @NamedQuery(name = "Seat.findBySeatPrice", query = "SELECT s FROM Seat s WHERE s.seatPrice = :seatPrice")})
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeatPK seatPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SeatPrice")
    private Double seatPrice;
    @JoinColumn(name = "Booking_BookingId", referencedColumnName = "BookingId")
    @ManyToOne(optional = false)
    private Booking booking;
    @JoinColumn(name = "Flight_FlightId", referencedColumnName = "FlightId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Flight flight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seat")
    private Collection<Passenger> passengerCollection;

    public Seat() {
    }

    public Seat(entities.SeatPK seatPK) {
        this.seatPK = seatPK;
    }

    public Seat(SeatPK seatPK, double seatPrice) {
        this.seatPK = seatPK;
        this.seatPrice = seatPrice;
    }

    public Seat(int seatNo, int flightId) {
        this.seatPK = new SeatPK(seatNo, flightId);
    }

    public SeatPK getSeatPK() {
        return seatPK;
    }

    public void setSeatPK(SeatPK seatPK) {
        this.seatPK = seatPK;
    }

    public Double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(Double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Collection<Passenger> getPassengerCollection() {
        return passengerCollection;
    }

    public void setPassengerCollection(Collection<Passenger> passengerCollection) {
        this.passengerCollection = passengerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seatPK != null ? seatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) object;
        if ((this.seatPK == null && other.seatPK != null) || (this.seatPK != null && !this.seatPK.equals(other.seatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Seat[ seatPK=" + seatPK + " ]";
    }
    
}
