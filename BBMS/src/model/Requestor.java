/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Anuradha
 */
public class Requestor {

    private String hospital;

    public Requestor(String hospital) {
        this.hospital = hospital;
    }

    /**
     * @return the hospital
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * @param hospital the hospital to set
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    

}
