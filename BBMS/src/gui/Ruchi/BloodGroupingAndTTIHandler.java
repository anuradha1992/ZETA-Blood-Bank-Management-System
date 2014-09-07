/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Ruchi;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ruchiranga
 */
public class BloodGroupingAndTTIHandler {

    BloodGroupingAndTTIDA dataAccess;

    public BloodGroupingAndTTIHandler() {
        dataAccess = new BloodGroupingAndTTIDA();
    }

    public String[] getPacketIDList() throws ClassNotFoundException, SQLException {
        ResultSet result = dataAccess.getIDList();
        int rowcount = getRecordCount(result);
        String[] list = new String[rowcount];
        for (int  i = 0;  result.next();  i++) {
            list[i]=result.getString(1);
        }
        return list;
    }

    private int getRecordCount(ResultSet rst) throws SQLException {
        int count = 0;
        while (rst.next()) {
            count++;
        }
        rst.beforeFirst();
        return count;
    }

}
