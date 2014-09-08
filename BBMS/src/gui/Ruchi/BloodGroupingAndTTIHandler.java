/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Ruchi;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.BloodPacket;

/**
 *
 * @author ruchiranga
 */
public class BloodGroupingAndTTIHandler {

    BloodGroupingAndTTIDA dataAccess;
    ArrayList<BloodPacket> packets;

    public BloodGroupingAndTTIHandler() throws SQLException, ClassNotFoundException {
        packets = new ArrayList<BloodPacket>();
        dataAccess = new BloodGroupingAndTTIDA();
        
        ResultSet result = dataAccess.getAllUntestedPackets();
        int rowcount = getRecordCount(result);
        
        for (int  i = 0;  result.next();  i++) {
            packets.add(new BloodPacket(result.getString(1), result.getString(2), result.getString(3), result.getString(4),  result.getDate(5), result.getDate(6),  result.getString(7),  result.getString(8),  result.getString(9)));
        }
        
        System.out.println(packets.get(0).getDateOfDonation());
    }

    public String[] getPacketIDList() throws ClassNotFoundException, SQLException {
        
        String[] list = new String[packets.size()];
        for (int  i = 0;  i<packets.size();  i++) {
            list[i]=packets.get(i).getPacketID();
        }
        return list;
    }
    
    public String getDonorName(String packetID) throws SQLException, ClassNotFoundException{
        String donorID = null;
        for(BloodPacket pack:packets){
            if(pack.getPacketID().equals(packetID)){
                donorID = pack.getNic();
            }
        }
        
        ResultSet result = dataAccess.getDonorName(donorID);
        
        result.next();
        String name = result.getString(1);
        return name;
    }

    private int getRecordCount(ResultSet rst) throws SQLException {
        int count = 0;
        while (rst.next()) {
            count++;
        }
        rst.beforeFirst();
        return count;
    }

    int blacklistDonor(String name) throws SQLException, ClassNotFoundException {
        return dataAccess.blackListDonor(name);
    }

}
