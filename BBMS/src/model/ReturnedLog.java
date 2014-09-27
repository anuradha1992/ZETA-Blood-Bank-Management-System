/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Date;

/**
 *
 * @author Anuradha
 */
public class ReturnedLog {
    
    private String returnID;
    private Date returnedDate;
    private String packetID;
    private String reason;

    public ReturnedLog(String returnID, Date returnedDate, String packetID, String reason) {
        this.returnID = returnID;
        this.returnedDate = returnedDate;
        this.packetID = packetID;
        this.reason = reason;
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
     * @return the returnedDate
     */
    public Date getReturnedDate() {
        return returnedDate;
    }

    /**
     * @param returnedDate the returnedDate to set
     */
    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
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
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
    
}
