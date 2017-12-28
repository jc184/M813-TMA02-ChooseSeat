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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "booking")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "Booking.findByNoOfAdults", query = "SELECT b FROM Booking b WHERE b.noOfAdults = :noOfAdults")
    , @NamedQuery(name = "Booking.findByNoOfChildren", query = "SELECT b FROM Booking b WHERE b.noOfChildren = :noOfChildren")
    , @NamedQuery(name = "Booking.findByNoOfInfants", query = "SELECT b FROM Booking b WHERE b.noOfInfants = :noOfInfants")
    , @NamedQuery(name = "Booking.findByAdultFare", query = "SELECT b FROM Booking b WHERE b.adultFare = :adultFare")
    , @NamedQuery(name = "Booking.findByChildFare", query = "SELECT b FROM Booking b WHERE b.childFare = :childFare")
    , @NamedQuery(name = "Booking.findByInfantFare", query = "SELECT b FROM Booking b WHERE b.infantFare = :infantFare")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookingId")
    private Integer bookingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoOfAdults")
    private int noOfAdults;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoOfChildren")
    private int noOfChildren;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoOfInfants")
    private int noOfInfants;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "AdultFare")
    private BigDecimal adultFare;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ChildFare")
    private BigDecimal childFare;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InfantFare")
    private BigDecimal infantFare;
    @JoinTable(name = "flightbooking", joinColumns = {
        @JoinColumn(name = "Booking_BookingId", referencedColumnName = "BookingId")}, inverseJoinColumns = {
        @JoinColumn(name = "Flight_FlightId", referencedColumnName = "FlightId")})
    @ManyToMany
    private Collection<Flight> flightCollection;
    @OneToMany(mappedBy = "bookingBookingId")
    private Collection<Seat> seatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingBookingId")
    private Collection<Baggageitem> baggageitemCollection;
    @JoinColumn(name = "Customer_CustomerId", referencedColumnName = "CustomerId")
    @ManyToOne(optional = false)
    private Customer customerCustomerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingBookingId")
    private Collection<Passenger> passengerCollection;

    public Booking() {
    }

    public Booking(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(Integer bookingId, int noOfAdults, int noOfChildren, int noOfInfants, BigDecimal adultFare, BigDecimal childFare, BigDecimal infantFare) {
        this.bookingId = bookingId;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.noOfInfants = noOfInfants;
        this.adultFare = adultFare;
        this.childFare = childFare;
        this.infantFare = infantFare;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public int getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(int noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public int getNoOfInfants() {
        return noOfInfants;
    }

    public void setNoOfInfants(int noOfInfants) {
        this.noOfInfants = noOfInfants;
    }

    public BigDecimal getAdultFare() {
        return adultFare;
    }

    public void setAdultFare(BigDecimal adultFare) {
        this.adultFare = adultFare;
    }

    public BigDecimal getChildFare() {
        return childFare;
    }

    public void setChildFare(BigDecimal childFare) {
        this.childFare = childFare;
    }

    public BigDecimal getInfantFare() {
        return infantFare;
    }

    public void setInfantFare(BigDecimal infantFare) {
        this.infantFare = infantFare;
    }

    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flightCollection) {
        this.flightCollection = flightCollection;
    }

    public Collection<Seat> getSeatCollection() {
        return seatCollection;
    }

    public void setSeatCollection(Collection<Seat> seatCollection) {
        this.seatCollection = seatCollection;
    }

    public Collection<Baggageitem> getBaggageitemCollection() {
        return baggageitemCollection;
    }

    public void setBaggageitemCollection(Collection<Baggageitem> baggageitemCollection) {
        this.baggageitemCollection = baggageitemCollection;
    }

    public Customer getCustomerCustomerId() {
        return customerCustomerId;
    }

    public void setCustomerCustomerId(Customer customerCustomerId) {
        this.customerCustomerId = customerCustomerId;
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
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Booking[ bookingId=" + bookingId + " ]";
    }
    
}
