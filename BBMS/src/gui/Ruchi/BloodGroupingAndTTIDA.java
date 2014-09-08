/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.Ruchi;

import connection.DBConnection;
import connection.DBHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ruchiranga
 */
public class BloodGroupingAndTTIDA {

    ResultSet getAllUntestedPackets() throws ClassNotFoundException, SQLException {
        String query = "Select packetID, nic, bloodGroup, bloodType,  dateOfDonation, dateOfExpiry, packetFrom, bloodBank,campID From BloodPacket where bloodGroup is NULL AND isDiscarded = 0";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }

    ResultSet getDonorName(String donorID) throws ClassNotFoundException, SQLException {
        String query = "Select name From donor where nic = '"+donorID+"'";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }

    int blackListDonor(String name) throws SQLException, ClassNotFoundException {
        
        String query = "UPDATE donor SET blacklisted=1 where name = '"+name+"'";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.setData(connection, query);
    }
    
}
