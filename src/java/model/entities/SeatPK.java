/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.metamodel.SingularAttribute;
import javax.validation.constraints.NotNull;

/**
 * Alba Airways application M813-TMA02-ChooseSeat
 * @author james chalmers Open University F6418079
 */
@Embeddable
public class SeatPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "SeatNo")
    private int seatNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AircraftId")
    private int aircraftId;

    public SeatPK() {
    }

    public SeatPK(int seatNumber, int aircraftId) {
        this.seatNumber = seatNumber;
        this.aircraftId = aircraftId;
    }

    public SeatPK(SingularAttribute<Seat, SeatPK> seatPK) {
        this.getSeatNumber();
        this.getAircraftId();

    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) seatNumber;
        hash += (int) aircraftId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeatPK)) {
            return false;
        }
        SeatPK other = (SeatPK) object;
        if (this.seatNumber != other.seatNumber) {
            return false;
        }
        if (this.aircraftId != other.aircraftId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SeatPK[ seatNo=" + seatNumber + ", aircraftAircraftId=" + aircraftId + " ]";
    }
    
}
