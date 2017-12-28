/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author james
 */
@Entity
@Table(name = "seat")
@NamedQueries({
    @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s")
    , @NamedQuery(name = "Seat.findBySeatNo", query = "SELECT s FROM Seat s WHERE s.seatNo = :seatNo")
    , @NamedQuery(name = "Seat.findBySeatType", query = "SELECT s FROM Seat s WHERE s.seatType = :seatType")})
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SeatNo")
    private Integer seatNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SeatType")
    private String seatType;
    @JoinColumn(name = "Booking_BookingId", referencedColumnName = "BookingId")
    @ManyToOne
    private Booking booking;
    @JoinColumn(name = "Flight_FlightId", referencedColumnName = "FlightId")
    @ManyToOne(optional = false)
    private Flight flight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seatSeatNo")
    private Collection<Passenger> passengerCollection;

    public Seat() {
    }

    public Seat(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public Seat(Integer seatNo, String seatType) {
        this.seatNo = seatNo;
        this.seatType = seatType;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
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
        hash += (seatNo != null ? seatNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) object;
        if ((this.seatNo == null && other.seatNo != null) || (this.seatNo != null && !this.seatNo.equals(other.seatNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Seat[ seatNo=" + seatNo + " ]";
    }
    
}
