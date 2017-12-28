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
@Table(name = "aircraft")
@NamedQueries({
    @NamedQuery(name = "Aircraft.findAll", query = "SELECT a FROM Aircraft a")
    , @NamedQuery(name = "Aircraft.findByAircraftId", query = "SELECT a FROM Aircraft a WHERE a.aircraftId = :aircraftId")
    , @NamedQuery(name = "Aircraft.findByAircraftModel", query = "SELECT a FROM Aircraft a WHERE a.aircraftModel = :aircraftModel")
    , @NamedQuery(name = "Aircraft.findBySeatingCapacity", query = "SELECT a FROM Aircraft a WHERE a.seatingCapacity = :seatingCapacity")
    , @NamedQuery(name = "Aircraft.findByLuggageCapacity", query = "SELECT a FROM Aircraft a WHERE a.luggageCapacity = :luggageCapacity")})
public class Aircraft implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AircraftId")
    private Integer aircraftId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "AircraftModel")
    private String aircraftModel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SeatingCapacity")
    private int seatingCapacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LuggageCapacity")
    private int luggageCapacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aircraftAircraftId")
    private Collection<Flight> flightCollection;

    public Aircraft() {
    }

    public Aircraft(Integer aircraftId) {
        this.aircraftId = aircraftId;
    }

    public Aircraft(Integer aircraftId, String aircraftModel, int seatingCapacity, int luggageCapacity) {
        this.aircraftId = aircraftId;
        this.aircraftModel = aircraftModel;
        this.seatingCapacity = seatingCapacity;
        this.luggageCapacity = luggageCapacity;
    }

    public Integer getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Integer aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(int luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flightCollection) {
        this.flightCollection = flightCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aircraftId != null ? aircraftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aircraft)) {
            return false;
        }
        Aircraft other = (Aircraft) object;
        if ((this.aircraftId == null && other.aircraftId != null) || (this.aircraftId != null && !this.aircraftId.equals(other.aircraftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Aircraft[ aircraftId=" + aircraftId + " ]";
    }
    
}
