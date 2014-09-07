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

    ResultSet getIDList() throws ClassNotFoundException, SQLException {
        String query = "Select packetID From BloodPacket where bloodGroup is NULL AND isDiscarded = 0";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }
    
}
