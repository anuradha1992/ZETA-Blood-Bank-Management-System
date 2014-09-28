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
import model.BloodReceivedLog;

/**
 *
 * @author Anuradha
 */
public class BloodRecievedLogController {
    
    public static ResultSet getResultIDs() throws ClassNotFoundException, SQLException {
        String query = "Select * From BloodRecievedLog order by RecievedID";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }
    
    public static int addLog(BloodReceivedLog log) throws ClassNotFoundException, SQLException {
        String query = "Insert into BloodRecievedLog(RecievedID,Requestee,RecievedDate,RecievedTime,SendingOfficer,RecievingOfficerID,Tempereture,IcePacketCobdition) values ('" + log.getReceivedID() + "','" + log.getRequestee() + "','" + log.getReceivedDate() + "','" + log.getReceivedTime() +"','" + log.getSendignOfficer()+ "','"+ log.getReceivingOfficer()+ "'," + log.getTemperature()+ ",'"+log.getIcePaceketCondition()+ "')";
        Connection connection = DBConnection.getConnectionToDB();
        int res = DBHandler.setData(connection, query);
        return res;
    }
    
}
