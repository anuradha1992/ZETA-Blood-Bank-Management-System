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
public class BloodStockController {

    public static int getUnX(String bloodGroup, String bloodType) throws ClassNotFoundException, SQLException {
        String query = "Select count(*) From BloodPacket B NATURAL JOIN BloodGroup G where B.BloodGroup = '" + bloodGroup + "' AND B.BloodType = '"+bloodType+"' AND B.isSpecialReservation = 0 AND B.isUnderObservation = 0 AND B.IsCrossmatched = 0 AND B.isDiscarded = 0 AND B.PatientIssueID IS NULL AND B.BulkIssueID is NULL AND B.BloodGroup = G.GroupName";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);
        while (rst.next()) {
            return rst.getInt("count(*)");
        }
        return -1;

    }

    public static int getX(String bloodGroup, String bloodType) throws ClassNotFoundException, SQLException {
        String query = "Select count(*) From BloodPacket B NATURAL JOIN BloodGroup G where B.BloodGroup = '" + bloodGroup + "' AND B.BloodType = '"+bloodType+"' AND B.isSpecialReservation = 0 AND B.isUnderObservation = 0 AND B.IsCrossmatched = 1 AND B.isDiscarded = 0 AND B.PatientIssueID IS NULL AND B.BulkIssueID is NULL AND B.BloodGroup = G.GroupName";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);
        while (rst.next()) {
            return rst.getInt("count(*)");
        }
        return -1;
    }

    public static int getSpecialReservation(String bloodGroup, String bloodType) throws ClassNotFoundException, SQLException {
        String query = "Select count(*) From BloodPacket B NATURAL JOIN BloodGroup G where B.BloodGroup = '" + bloodGroup + "' AND B.BloodType = '"+bloodType+"' AND B.isSpecialReservation = 1 AND B.isDiscarded = 0 AND B.PatientIssueID IS NULL AND B.BulkIssueID is NULL AND B.BloodGroup = G.GroupName";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);
        while (rst.next()) {
            return rst.getInt("count(*)");
        }
        return -1;
    }

    public static int getUnderObservation(String bloodGroup, String bloodType) throws ClassNotFoundException, SQLException {
        String query = "Select count(*) From BloodPacket B NATURAL JOIN BloodGroup G where B.BloodGroup = '" + bloodGroup + "' AND B.BloodType = '"+bloodType+"' AND B.isUnderObservation = 1 AND B.isDiscarded = 0 AND B.PatientIssueID IS NULL AND B.BulkIssueID is NULL AND B.BloodGroup = G.GroupName";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);
        while (rst.next()) {
            return rst.getInt("count(*)");
        }
        return -1;
    }
    
    public static int getUntestedTotal(String bloodGroup, String bloodType) throws ClassNotFoundException, SQLException {
        String query = "Select count(*) From BloodPacket B NATURAL JOIN BloodGroup G where B.BloodGroup = '" + bloodGroup + "' AND B.BloodType = '"+bloodType+"' AND B.isDiscarded = 0 AND B.PatientIssueID IS NULL AND B.BulkIssueID is NULL AND B.BloodGroup = G.GroupName";
        Connection connection = DBConnection.getConnectionToDB();
        ResultSet rst = DBHandler.getData(connection, query);
        while (rst.next()) {
            return rst.getInt("count(*)");
        }
        return -1;
    }

}
