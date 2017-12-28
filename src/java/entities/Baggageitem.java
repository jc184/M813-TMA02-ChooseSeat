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

/**
 *
 * @author james
 */
@Entity
@Table(name = "baggageitem")
@NamedQueries({
    @NamedQuery(name = "Baggageitem.findAll", query = "SELECT b FROM Baggageitem b")})
public class Baggageitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BaggageItemId")
    private Integer baggageItemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BaggageItemWeightKg")
    private int baggageItemWeightKg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baggageItemBaggageItemId")
    private List<Passenger> passengerList;

    public Baggageitem() {
    }

    public Baggageitem(Integer baggageItemId) {
        this.baggageItemId = baggageItemId;
    }

    public Baggageitem(Integer baggageItemId, int baggageItemWeightKg) {
        this.baggageItemId = baggageItemId;
        this.baggageItemWeightKg = baggageItemWeightKg;
    }

    public Integer getBaggageItemId() {
        return baggageItemId;
    }

    public void setBaggageItemId(Integer baggageItemId) {
        this.baggageItemId = baggageItemId;
    }

    public int getBaggageItemWeightKg() {
        return baggageItemWeightKg;
    }

    public void setBaggageItemWeightKg(int baggageItemWeightKg) {
        this.baggageItemWeightKg = baggageItemWeightKg;
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
        hash += (baggageItemId != null ? baggageItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baggageitem)) {
            return false;
        }
        Baggageitem other = (Baggageitem) object;
        if ((this.baggageItemId == null && other.baggageItemId != null) || (this.baggageItemId != null && !this.baggageItemId.equals(other.baggageItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Baggageitem[ baggageItemId=" + baggageItemId + " ]";
    }
    
}
