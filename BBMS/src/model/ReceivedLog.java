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
public class ReceivedLog {
    private String itemID;
    private Date recievedDate;
    private double qty;
    private String from;

    public ReceivedLog(String itemID, Date recievedDate, double qty, String from) {
        this.itemID = itemID;
        this.recievedDate = recievedDate;
        this.qty = qty;
        this.from = from;
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
     * @return the recievedDate
     */
    public Date getRecievedDate() {
        return recievedDate;
    }

    /**
     * @param recievedDate the recievedDate to set
     */
    public void setRecievedDate(Date recievedDate) {
        this.recievedDate = recievedDate;
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
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    
}
