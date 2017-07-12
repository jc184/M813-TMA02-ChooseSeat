/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.enums;

/**
 * Alba Airways application M813-TMA02-ChooseSeat
 * @author james chalmers Open University F6418079
 */
public enum SeatEnum {
    
    SEAT01("FirstClass", 75.0, 38.0, 19.0),
    SEAT02("FirstClass", 75.0, 38.0, 19.0),
    SEAT03("FirstClass", 75.0, 38.0, 19.0),
    SEAT04("FirstClass", 75.0, 38.0, 19.0),
    SEAT05("FirstClass", 75.0, 38.0, 19.0),
    SEAT06("FirstClass", 75.0, 38.0, 19.0),
    SEAT07("FirstClass", 75.0, 38.0, 19.0),
    SEAT08("FirstClass", 75.0, 38.0, 19.0),
    SEAT09("FirstClass", 75.0, 38.0, 19.0),
    SEAT10("FirstClass", 75.0, 38.0, 19.0),
    SEAT11("FirstClass", 75.0, 38.0, 19.0),
    SEAT12("FirstClass", 75.0, 38.0, 19.0),
    SEAT13("EconomyClass", 50.0, 25.0, 12.0),
    SEAT14("EconomyClass", 50.0, 25.0, 12.0),
    SEAT15("EconomyClass", 50.0, 25.0, 12.0),
    SEAT16("EconomyClass", 50.0, 25.0, 12.0),
    SEAT17("EconomyClass", 50.0, 25.0, 12.0),
    SEAT18("EconomyClass", 50.0, 25.0, 12.0),
    SEAT19("EconomyClass", 50.0, 25.0, 12.0),
    SEAT20("EconomyClass", 50.0, 25.0, 12.0),
    SEAT21("EconomyClass", 50.0, 25.0, 12.0),
    SEAT22("EconomyClass", 50.0, 25.0, 12.0),
    SEAT23("EconomyClass", 50.0, 25.0, 12.0),
    SEAT24("EconomyClass", 50.0, 25.0, 12.0);

    
    String SeatDesignation;
    double adultFare;
    double childFare;
    double infantFare;

    private SeatEnum(String SeatDesignation, double adultFare, double childFare, double infantFare) {
        this.SeatDesignation = SeatDesignation;
        this.adultFare = adultFare;
        this.childFare = childFare;
        this.infantFare = infantFare;
    }

    public String getSeatDesignation() {
        return SeatDesignation;
    }

    public double getAdultFare() {
        return adultFare;
    }

    public double getChildFare() {
        return childFare;
    }

    public double getInfantFare() {
        return infantFare;
    }
      
}
