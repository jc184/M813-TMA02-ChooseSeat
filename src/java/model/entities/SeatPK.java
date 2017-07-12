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
import javax.validation.constraints.NotNull;

/**
 * Alba Airways application M813-TMA02-ChooseSeat
 * @author james chalmers Open University F6418079
 */
@Embeddable
public class SeatPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SeatNo")
    private int seatNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Aircraft_AircraftId")
    private int aircraftAircraftId;

    public SeatPK() {
    }

    public SeatPK(int seatNo, int aircraftAircraftId) {
        this.seatNo = seatNo;
        this.aircraftAircraftId = aircraftAircraftId;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getAircraftAircraftId() {
        return aircraftAircraftId;
    }

    public void setAircraftAircraftId(int aircraftAircraftId) {
        this.aircraftAircraftId = aircraftAircraftId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) seatNo;
        hash += (int) aircraftAircraftId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeatPK)) {
            return false;
        }
        SeatPK other = (SeatPK) object;
        if (this.seatNo != other.seatNo) {
            return false;
        }
        if (this.aircraftAircraftId != other.aircraftAircraftId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SeatPK[ seatNo=" + seatNo + ", aircraftAircraftId=" + aircraftAircraftId + " ]";
    }
    
}
