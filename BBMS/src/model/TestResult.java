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
public class TestResult {
    
    private String resultID;
    private String testID;
    private String packetID;
    private String result;
    private String comment;
    private Date date;
    private String doneBy;
    private String checkedBy;
    private String labeledBy;

    public TestResult(String resultID, String testID, String packetID, String result, String comment, Date date, String doneBy, String checkedBy, String labeledBy) {
        this.resultID = resultID;
        this.testID = testID;
        this.packetID = packetID;
        this.result = result;
        this.comment = comment;
        this.date = date;
        this.doneBy = doneBy;
        this.checkedBy = checkedBy;
        this.labeledBy = labeledBy;
    }

    /**
     * @return the resultID
     */
    public String getResultID() {
        return resultID;
    }

    /**
     * @param resultID the resultID to set
     */
    public void setResultID(String resultID) {
        this.resultID = resultID;
    }

    /**
     * @return the testID
     */
    public String getTestID() {
        return testID;
    }

    /**
     * @param testID the testID to set
     */
    public void setTestID(String testID) {
        this.testID = testID;
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
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
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
     * @return the doneBy
     */
    public String getDoneBy() {
        return doneBy;
    }

    /**
     * @param doneBy the doneBy to set
     */
    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }

    /**
     * @return the checkedBy
     */
    public String getCheckedBy() {
        return checkedBy;
    }

    /**
     * @param checkedBy the checkedBy to set
     */
    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
    }

    /**
     * @return the labeledBy
     */
    public String getLabeledBy() {
        return labeledBy;
    }

    /**
     * @param labeledBy the labeledBy to set
     */
    public void setLabeledBy(String labeledBy) {
        this.labeledBy = labeledBy;
    }
    
    
    
}
