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
import model.TestResult;

/**
 *
 * @author Anuradha
 */
public class TestResultController {
    
    public static ResultSet getAllTests() throws ClassNotFoundException, SQLException {
        String query = "Select * From TestResult order by ResultID";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }
    
    public static int addTestResultOfRecievedBloodPackets(TestResult result) throws ClassNotFoundException, SQLException {
        String query = "Insert into TestResult(ResultID,TestID,PacketID,Result) values ('" + result.getResultID() + "','" + result.getTestID() + "','" + result.getPacketID() + "','" + result.getResult()+ "')";
        Connection connection = DBConnection.getConnectionToDB();
        int res = DBHandler.setData(connection, query);
        return res;
    }
    
}
