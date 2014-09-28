/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.anu;

import connection.DBConnection;
import connection.DBHandler;
import java.sql.Connection;
import java.sql.SQLException;
import model.BloodrecievedDetail;

/**
 *
 * @author Anuradha
 */
public class BloodRecievedDetailController {
    
    public static int addDetail(BloodrecievedDetail detail) throws ClassNotFoundException, SQLException {
        String query = "Insert into BloodRecievedDetail(recievedID,packetID) values ('" + detail.getReceivedID() + "','" + detail.getPacketID() + "')";
        Connection connection = DBConnection.getConnectionToDB();
        int res = DBHandler.setData(connection, query);
        return res;
    }
    
}
