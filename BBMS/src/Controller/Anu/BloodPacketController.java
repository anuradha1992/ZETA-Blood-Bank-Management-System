/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Anu;

import connection.DBConnection;
import connection.DBHandler;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.BloodPacket;

/**
 *
 * @author Anuradha
 */
public class BloodPacketController {

    public static int addPacket(BloodPacket packet) throws ClassNotFoundException, SQLException {
        String query = "Insert into BloodPacket(packetID,nic,bloodGroup,bloodType,dateOfDonation,dateOfExpiry,packetFrom,bloodBank,campID) values ('" + packet.getPacketID() + "','" + packet.getNic() + "','" + packet.getBloodGroup() + "','" + packet.getBloodType() +"','" + packet.getDateOfDonation() + "','" + packet.getDateOfExpiry() + "','" + packet.getPacketFrom() + "','" + packet.getBloodBank() + "','"+ packet.getCampID()+ "')";
        Connection connection = DBConnection.getConnectionToDB();
        int res = DBHandler.setData(connection, query);
        return res;
    }

    public static ResultSet getExpiredBloodPackets(Date today) throws ClassNotFoundException, SQLException {
        String query = "Select * From BloodPacket where dateOfExpiry = '"+today+"' AND isDiscarded = "+0+"";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }

    public static int discardPacket(String packetID, Date discardedDate) throws ClassNotFoundException, SQLException {
        String query = "Update BloodPacket set isDiscarded=" + 1 + ", discardedDate='" +discardedDate + "' where packetID='" + packetID + "'";
        Connection connection = DBConnection.getConnectionToDB();
        int res = DBHandler.setData(connection, query);
        return res;
    }

    public static ResultSet getDiscardedBloodPacketsByDuration(Date startDate, Date endDate) throws ClassNotFoundException, SQLException {
        String query = "Select * From BloodPacket where discardedDate BETWEEN '"+startDate+"' AND '"+endDate+"'";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }

    public static ResultSet getDiscardedBloodPacketsByMonth(int month) throws ClassNotFoundException, SQLException {
        String query = "Select * From BloodPacket where month(discardedDate)='"+month+"'";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }

    public static ResultSet getDiscardedBloodPacketsByYear(int year) throws ClassNotFoundException, SQLException {
        String query = "Select * From BloodPacket where year(discardedDate)='"+year+"'";
        Connection connection = DBConnection.getConnectionToDB();
        return DBHandler.getData(connection, query);
    }

}
