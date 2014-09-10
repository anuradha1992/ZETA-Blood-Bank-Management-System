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
public class ReagentRequest {

    private String requestID;
    private String itemID;
    private Date date;
    private double qty;
    private String reason;
    private String officerID;

    public ReagentRequest(String requestID, String itemID, Date date, double qty, String reason, String officerID) {
        this.requestID = requestID;
        this.itemID = itemID;
        this.date = date;
        this.qty = qty;
        this.reason = reason;
        this.officerID = officerID;
    }

    /**
     * @return the requestID
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * @param requestID the requestID to set
     */
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty = qty;
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

    /**
     * @return the officerID
     */
    public String getOfficerID() {
        return officerID;
    }

    /**
     * @param officerID the officerID to set
     */
    public void setOfficerID(String officerID) {
        this.officerID = officerID;
    }

    

}
