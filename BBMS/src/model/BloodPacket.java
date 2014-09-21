/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Date;

/**
 *
 * @author Anuradha
 */
public class BloodPacket {

    private String packetID;
    private String nic;
    private String bloodGroup;
    private String bloodType; //FreshBlood, FFP, CRYO, Plasma, Platelets
    
    private Date dateOfDonation;
    private Date dateOfExpiry;

    private String packetFrom;
    private String bloodBank;
    private String campID;

    private int isCrossmatched;
    private int isSpecialReservation;
    private int isUnderObservation;
    private int isDiscarded;
    private int isIssued;
    private Date issuedDate;

    public BloodPacket(String packetID, String nic, String bloodGroup, String bloodType, Date dateOfDonation, Date dateOfExpiry, String packetFrom, String bloodBank, String campID) {
        this.packetID = packetID;
        this.nic = nic;
        this.bloodGroup = bloodGroup;
        this.bloodType = bloodType;
        this.dateOfDonation = dateOfDonation;
        this.dateOfExpiry = dateOfExpiry;
        this.packetFrom = packetFrom;
        this.bloodBank = bloodBank;
        this.campID = campID;
    }

    /**
     * @return the packetID
     */
    public String getPacketID() {
        return packetID;
    }

    /**
     * @param packetID the packetID to set
     */
    public void setPacketID(String packetID) {
        this.packetID = packetID;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the bloodGroup
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * @param bloodGroup the bloodGroup to set
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     * @return the bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType the bloodType to set
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * @return the dateOfDonation
     */
    public Date getDateOfDonation() {
        return dateOfDonation;
    }

    /**
     * @param dateOfDonation the dateOfDonation to set
     */
    public void setDateOfDonation(Date dateOfDonation) {
        this.dateOfDonation = dateOfDonation;
    }

    /**
     * @return the dateOfExpiry
     */
    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    /**
     * @param dateOfExpiry the dateOfExpiry to set
     */
    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    /**
     * @return the packetFrom
     */
    public String getPacketFrom() {
        return packetFrom;
    }

    /**
     * @param packetFrom the packetFrom to set
     */
    public void setPacketFrom(String packetFrom) {
        this.packetFrom = packetFrom;
    }

    /**
     * @return the bloodBank
     */
    public String getBloodBank() {
        return bloodBank;
    }

    /**
     * @param bloodBank the bloodBank to set
     */
    public void setBloodBank(String bloodBank) {
        this.bloodBank = bloodBank;
    }

    /**
     * @return the campID
     */
    public String getCampID() {
        return campID;
    }

    /**
     * @param campID the campID to set
     */
    public void setCampID(String campID) {
        this.campID = campID;
    }

    /**
     * @return the isCrossmatched
     */
    public int getIsCrossmatched() {
        return isCrossmatched;
    }

    /**
     * @param isCrossmatched the isCrossmatched to set
     */
    public void setIsCrossmatched(int isCrossmatched) {
        this.isCrossmatched = isCrossmatched;
    }

    /**
     * @return the isSpecialReservation
     */
    public int getIsSpecialReservation() {
        return isSpecialReservation;
    }

    /**
     * @param isSpecialReservation the isSpecialReservation to set
     */
    public void setIsSpecialReservation(int isSpecialReservation) {
        this.isSpecialReservation = isSpecialReservation;
    }

    /**
     * @return the isUnderObservation
     */
    public int getIsUnderObservation() {
        return isUnderObservation;
    }

    /**
     * @param isUnderObservation the isUnderObservation to set
     */
    public void setIsUnderObservation(int isUnderObservation) {
        this.isUnderObservation = isUnderObservation;
    }

    /**
     * @return the isDiscarded
     */
    public int getIsDiscarded() {
        return isDiscarded;
    }

    /**
     * @param isDiscarded the isDiscarded to set
     */
    public void setIsDiscarded(int isDiscarded) {
        this.isDiscarded = isDiscarded;
    }

    /**
     * @return the isIssued
     */
    public int getIsIssued() {
        return isIssued;
    }

    /**
     * @param isIssued the isIssued to set
     */
    public void setIsIssued(int isIssued) {
        this.isIssued = isIssued;
    }

    /**
     * @return the issuedDate
     */
    public Date getIssuedDate() {
        return issuedDate;
    }

    /**
     * @param issuedDate the issuedDate to set
     */
    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    

    

}
