/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Ruchi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BloodPacket;
import model.Test;

/**
 *
 * @author ruchiranga
 */
public class AvailabilityHandler {

    AvailabilityDA dataAccess;
    ArrayList<BloodPacket> packets;

    public AvailabilityHandler() {
        dataAccess = new AvailabilityDA();
        packets = new ArrayList<BloodPacket>();

        ResultSet rst;
        try {
            rst = dataAccess.getAvailablePackets();
            int count = getRecordCount(rst);
            for (int i = 0; rst.next(); i++) {
                packets.add(new BloodPacket(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(5), rst.getDate(6), rst.getInt(7), rst.getInt(8)));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AvailabilityHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AvailabilityHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    String[] getGroupList() throws SQLException, ClassNotFoundException {
        ResultSet rst;
        rst = dataAccess.getBloodGroups();
        int count = getRecordCount(rst);
        String[] groups = new String[count];
        for (int i = 0; rst.next(); i++) {
            groups[i] = rst.getString(1);
        }
        return groups;

    }

    private int getRecordCount(ResultSet rst) throws SQLException {
        int count = 0;
        while (rst.next()) {
            count++;
        }
        rst.beforeFirst();
        return count;
    }

    String[] getComponentList() throws SQLException, ClassNotFoundException {
        ResultSet rst;
        rst = dataAccess.getComponents();
        int count = getRecordCount(rst);
        String[] comps = new String[count];
        for (int i = 0; rst.next(); i++) {
            comps[i] = rst.getString(1);
        }
        return comps;
    }

    String[] getDonorList() throws ClassNotFoundException, SQLException {
        ResultSet rst;
        rst = dataAccess.getDonors();
        int count = getRecordCount(rst);
        String[] donors = new String[count];
        for (int i = 0; rst.next(); i++) {
            donors[i] = rst.getString(1);
        }
        return donors;
    }
    
    BloodPacket[] searchByGroup(String group){
        ArrayList<BloodPacket> results = new ArrayList<BloodPacket>();
        for(BloodPacket packet:packets){
            if(packet.getBloodGroup().equals(group)){
                results.add(packet);
            }
        }
        return (BloodPacket[]) results.toArray();
    }
}
