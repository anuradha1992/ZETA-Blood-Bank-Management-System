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
    private String recievedID;
    private Date dateOfDonation;
    private Date dateOfExpiry;
    private String bloodType; //FreshBlood, FFP, CRYO, Plasma, Platelets
    private int isCrossmatched;
    private int isSpecialReservation;
    private int isUnderObservation;
    private String returnID;
    private int issueID;
    private String campID;
    private int isDiscarded;
    private String bloodGroup;
    private Date discardedDate;
    private String groupComment;

    public BloodPacket(String packetID, String nic, String recievedID, Date dateOfDonation, Date dateOfExpiry, String bloodType, int isCrossmatched, int isSpecialReservation, int isUnderObservation, String returnID, int issueID, String campID, int isDiscarded, String bloodGroup, Date discardedDate, String groupComment) {
        this.packetID = packetID;
        this.nic = nic;
        this.recievedID = recievedID;
        this.dateOfDonation = dateOfDonation;
        this.dateOfExpiry = dateOfExpiry;
        this.bloodType = bloodType;
        this.isCrossmatched = isCrossmatched;
        this.isSpecialReservation = isSpecialReservation;
        this.isUnderObservation = isUnderObservation;
        this.returnID = returnID;
        this.issueID = issueID;
        this.campID = campID;
        this.isDiscarded = isDiscarded;
        this.bloodGroup = bloodGroup;
        this.discardedDate = discardedDate;
        this.groupComment = groupComment;
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
     * @return the recievedID
     */
    public String getRecievedID() {
        return recievedID;
    }

    /**
     * @param recievedID the recievedID to set
     */
    public void setRecievedID(String recievedID) {
        this.recievedID = recievedID;
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
     * @return the returnID
     */
    public String getReturnID() {
        return returnID;
    }

    /**
     * @param returnID the returnID to set
     */
    public void setReturnID(String returnID) {
        this.returnID = returnID;
    }

    /**
     * @return the issueID
     */
    public int getIssueID() {
        return issueID;
    }

    /**
     * @param issueID the issueID to set
     */
    public void setIssueID(int issueID) {
        this.issueID = issueID;
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
     * @return the discardedDate
     */
    public Date getDiscardedDate() {
        return discardedDate;
    }

    /**
     * @param discardedDate the discardedDate to set
     */
    public void setDiscardedDate(Date discardedDate) {
        this.discardedDate = discardedDate;
    }

    /**
     * @return the groupComment
     */
    public String getGroupComment() {
        return groupComment;
    }

    /**
     * @param groupComment the groupComment to set
     */
    public void setGroupComment(String groupComment) {
        this.groupComment = groupComment;
    }

    

}
