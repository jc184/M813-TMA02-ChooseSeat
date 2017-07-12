/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Alba Airways application M813-TMA02-ChooseSeat
 * @author james chalmers Open University F6418079
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "Booking.findByNoOfAdults", query = "SELECT b FROM Booking b WHERE b.noOfAdults = :noOfAdults")
    , @NamedQuery(name = "Booking.findByNoOfChildren", query = "SELECT b FROM Booking b WHERE b.noOfChildren = :noOfChildren")
    , @NamedQuery(name = "Booking.findByNoOfInfants", query = "SELECT b FROM Booking b WHERE b.noOfInfants = :noOfInfants")
    , @NamedQuery(name = "Booking.findByTicketType", query = "SELECT b FROM Booking b WHERE b.ticketType = :ticketType")
    , @NamedQuery(name = "Booking.findByTotalCost", query = "SELECT b FROM Booking b WHERE b.totalCost = :totalCost")
    , @NamedQuery(name = "Booking.findBySeatType", query = "SELECT b FROM Booking b WHERE b.seatType = :seatType")
    , @NamedQuery(name = "Booking.findByOutboundRouteID", query = "SELECT b FROM Booking b WHERE b.outboundRouteID = :outboundRouteID")
    , @NamedQuery(name = "Booking.findByOutboundDate", query = "SELECT b FROM Booking b WHERE b.outboundDate = :outboundDate")
    , @NamedQuery(name = "Booking.findByReturnRouteID", query = "SELECT b FROM Booking b WHERE b.returnRouteID = :returnRouteID")
    , @NamedQuery(name = "Booking.findByReturnDate", query = "SELECT b FROM Booking b WHERE b.returnDate = :returnDate")})
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "TicketType")
    private String ticketType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalCost")
    private BigDecimal totalCost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "SeatType")
    private String seatType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OutboundRouteID")
    private int outboundRouteID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OutboundDate")
    @Temporal(TemporalType.DATE)
    private Date outboundDate;
    @Column(name = "ReturnRouteID")
    private Integer returnRouteID;
    @Column(name = "ReturnDate")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    @OneToMany(mappedBy = "bookingBookingId")
    private Collection<Seat> seatCollection;
    @JoinColumn(name = "Customer_CustomerId", referencedColumnName = "CustomerId")
    @ManyToOne(optional = false)
    private Customer customerCustomerId;

    public Booking() {
    }

    public Booking(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(Integer bookingId, int noOfAdults, int noOfChildren, int noOfInfants, String ticketType, String seatType, int outboundRouteID, Date outboundDate) {
        this.bookingId = bookingId;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.noOfInfants = noOfInfants;
        this.ticketType = ticketType;
        this.seatType = seatType;
        this.outboundRouteID = outboundRouteID;
        this.outboundDate = outboundDate;
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

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getOutboundRouteID() {
        return outboundRouteID;
    }

    public void setOutboundRouteID(int outboundRouteID) {
        this.outboundRouteID = outboundRouteID;
    }

    public Date getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(Date outboundDate) {
        this.outboundDate = outboundDate;
    }

    public Integer getReturnRouteID() {
        return returnRouteID;
    }

    public void setReturnRouteID(Integer returnRouteID) {
        this.returnRouteID = returnRouteID;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @XmlTransient
    public Collection<Seat> getSeatCollection() {
        return seatCollection;
    }

    public void setSeatCollection(Collection<Seat> seatCollection) {
        this.seatCollection = seatCollection;
    }

    public Customer getCustomerCustomerId() {
        return customerCustomerId;
    }

    public void setCustomerCustomerId(Customer customerCustomerId) {
        this.customerCustomerId = customerCustomerId;
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
