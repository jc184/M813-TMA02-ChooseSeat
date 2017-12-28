/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "route")
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RouteId")
    private Integer routeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "RouteName")
    private String routeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "AirportFrom")
    private String airportFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "AirportTo")
    private String airportTo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeRouteId")
    private List<Flight> flightList;

    public Route() {
    }

    public Route(Integer routeId) {
        this.routeId = routeId;
    }

    public Route(Integer routeId, String routeName, String airportFrom, String airportTo) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Route[ routeId=" + routeId + " ]";
    }
    
}
