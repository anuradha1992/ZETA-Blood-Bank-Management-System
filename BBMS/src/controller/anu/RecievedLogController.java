/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.anu;

import connection.DBConnection;
import connection.DBHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anuradha
 */
public class RecievedLogController {
    
    public static ResultSet getResultIDs() throws ClassNotFoundException, SQLException {
        String query = "Select * From BloodRecievedLog order by RecievedID";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }
    
}
