/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author james
 */
@Entity
@Table(name = "flight")
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FlightId")
    private Integer flightId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LeaveDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date leaveDateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ArrivalDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDateTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FlightStatus")
    private String flightStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GateNumber")
    private int gateNumber;
    @JoinColumn(name = "Route_RouteId", referencedColumnName = "RouteId")
    @ManyToOne(optional = false)
    private Route routeRouteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flightFlightId")
    private List<Passenger> passengerList;

    public Flight() {
    }

    public Flight(Integer flightId) {
        this.flightId = flightId;
    }

    public Flight(Integer flightId, Date leaveDateTime, Date arrivalDateTime, String flightStatus, int gateNumber) {
        this.flightId = flightId;
        this.leaveDateTime = leaveDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.flightStatus = flightStatus;
        this.gateNumber = gateNumber;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Date getLeaveDateTime() {
        return leaveDateTime;
    }

    public void setLeaveDateTime(Date leaveDateTime) {
        this.leaveDateTime = leaveDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Route getRouteRouteId() {
        return routeRouteId;
    }

    public void setRouteRouteId(Route routeRouteId) {
        this.routeRouteId = routeRouteId;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightId != null ? flightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.flightId == null && other.flightId != null) || (this.flightId != null && !this.flightId.equals(other.flightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Flight[ flightId=" + flightId + " ]";
    }
    
}
