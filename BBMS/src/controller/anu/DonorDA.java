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
 * @author Upekka
 */
public class DonorDA {
    
    public static ResultSet getAllGroups() throws ClassNotFoundException, SQLException {
        String query = "Select * From Donor";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }
    
    public static String getDonorName(String nic) throws ClassNotFoundException, SQLException {
        String query = "Select * From Donor where nic='"+nic+"'";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);
        if(rst.next()){
            return rst.getString("name");
        }else{
            return null;
        }
    }
        
}
