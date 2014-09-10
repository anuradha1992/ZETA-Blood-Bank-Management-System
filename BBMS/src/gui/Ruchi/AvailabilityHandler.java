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
public class AvailabilityHandler {
    
    AvailabilityDA dataAccess;

    public AvailabilityHandler() {
        dataAccess = new AvailabilityDA();
    }
    
    

    String[] getGroupList() throws SQLException, ClassNotFoundException {
        ResultSet rst;
        rst = dataAccess.getBloodGroups();
        int count = getRecordCount(rst);
        String[] groups = new String[count];
        for (int i = 0; rst.next(); i++) {
            groups[i] = rst.getString(1);
        }
        return groups;

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
