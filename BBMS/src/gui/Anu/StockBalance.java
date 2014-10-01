/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StockBalance.java
 *
 * Created on Jul 28, 2014, 6:21:45 PM
 */
package gui.Anu;

import controller.anu.BloodStockController;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anuradha
 */
public class StockBalance extends javax.swing.JInternalFrame {

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    String[] bloodStockTitle = {"Blood Group", "Un X matched", "X matched", "Special Reservations", "Under Observation", "Total"};
    DefaultTableModel dailyBloodStockDtm = new DefaultTableModel(bloodStockTitle, 0);

    String[] componentStockTitle = {"Component", "A +ve", "A neg", "B +ve", "B neg", "AB +ve", "AB neg", "O +ve", "O neg", "UG", "Total"};
    DefaultTableModel dailyComponentStockDtm = new DefaultTableModel(componentStockTitle, 0);

    String[] bloodTitle = {"", "Fresh blood","CRYO","FFP"};
    Object[][] bloodData = {{"Balance", null,null,null},
    {"Inhouse", null,null,null},
    {"Mobile", null,null,null},
    {"", null,null,null},
    {"Return", null,null,null},
    {"Recieve", null,null,null},
    {"", null,null,null},
    {"Issue", null,null,null},
    {"", null,null,null},
    {"Discard", null,null,null},
    {"Total", null,null,null}};
    DefaultTableModel bloodDtm = new DefaultTableModel(bloodData, bloodTitle);

    /**
     * Creates new form StockBalance
     */
    public StockBalance() {
        try {
            initComponents();
            File imgfile = new File("..\\BBMS\\src\\images\\drop.png");
            FileInputStream imgStream = new FileInputStream(imgfile);
            BufferedImage bi = ImageIO.read(imgStream);
            ImageIcon myImg = new ImageIcon(bi);
            this.setFrameIcon(myImg);

            Calendar currenttime = Calendar.getInstance();
            java.util.Date today = new java.util.Date((currenttime.getTime()).getTime());
            DailyBloodStockDate.setDate(today);

            //setDailyBloodStock();

        } catch (IOException ex) {
            Logger.getLogger(StockBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setDailyBloodStock() {

        dailyBloodStockDtm = new DefaultTableModel(bloodStockTitle, 0);
        DailyBloodStockTable.setModel(dailyBloodStockDtm);

        try {

            /*Date*/
            java.util.Date dateC = DailyBloodStockDate.getDate();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dateCollection = df.format(dateC);
            java.sql.Date sqlDateC = new java.sql.Date(dateC.getTime());

            System.out.println("" + sqlDateC);

            ResultSet bloodStockRst = BloodStockController.getBloodStockHistory(sqlDateC);

            String[] ungrouped = new String[6];

            int isThere = 0;

            while (bloodStockRst.next()) {
                isThere = 1;
                String bloodGroup = bloodStockRst.getString("BloodGroup");

                if (!bloodGroup.equalsIgnoreCase("UG")) {
                    String[] row = new String[6];
                    row[0] = bloodGroup;
                    row[1] = bloodStockRst.getString("Unx");
                    row[2] = bloodStockRst.getString("x");
                    row[3] = bloodStockRst.getString("Spec_res");
                    row[4] = bloodStockRst.getString("Underobs");
                    row[5] = bloodStockRst.getString("Total");

                    dailyBloodStockDtm.addRow(row);
                } else {
                    ungrouped[0] = bloodGroup;
                    ungrouped[1] = bloodStockRst.getString("Unx");
                    ungrouped[2] = bloodStockRst.getString("x");
                    ungrouped[3] = bloodStockRst.getString("Spec_res");
                    ungrouped[4] = bloodStockRst.getString("Underobs");
                    ungrouped[5] = bloodStockRst.getString("Total");
                }

            }

            if (isThere == 1) {
                int bloodTotal = 0;
                for (int i = 0; i < dailyBloodStockDtm.getRowCount(); i++) {
                    bloodTotal += Integer.parseInt("" + dailyBloodStockDtm.getValueAt(i, 5));
                }

                String[] total = {"Total", "", "", "", "", "" + bloodTotal};
                dailyBloodStockDtm.addRow(total);

                dailyBloodStockDtm.addRow(ungrouped);

                int ungroupedTotal = Integer.parseInt(ungrouped[5]);
                String[] grandTotal = {"", "", "", "", "Grand Total", "" + (bloodTotal + ungroupedTotal)};
                dailyBloodStockDtm.addRow(grandTotal);
            }

            setDailyBloodStockDetails(sqlDateC);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockBalance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StockBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setDailyBloodStockDetails(java.sql.Date sqlDateC) {

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            String yesterday = dateFormat.format(cal.getTime());
            java.util.Date utilYesterday = cal.getTime();
            dateFormat.format(utilYesterday);
            java.sql.Date sqlYesterday = new java.sql.Date(utilYesterday.getTime());

            System.out.println("Yesterday = " + yesterday);
            int balance = BloodStockController.getBalanceStockHistoryByType(sqlYesterday, "Fresh blood");
            
            if(balance >= 0){
                bloodDtm.setValueAt(""+balance, 0, 1);
                
                int inhouse = BloodStockController.getInhouseBloodCount("Fresh blood", sqlDateC);
                bloodDtm.setValueAt(""+inhouse, 1, 1);
                
                int mobile = BloodStockController.getMobileBloodCount("Fresh blood", sqlDateC);
                bloodDtm.setValueAt(""+mobile, 2, 1);
                
                bloodDtm.setValueAt(""+(balance+inhouse+mobile), 3, 1);
                
                int returned = BloodStockController.getReturnBloodCount("Fresh blood", sqlDateC);
                bloodDtm.setValueAt(""+returned, 4, 1);
                
                int recieved = BloodStockController.getRecievedBloodCount("Fresh blood", sqlDateC);
                bloodDtm.setValueAt(""+recieved, 5, 1);
                
                bloodDtm.setValueAt(""+(balance+inhouse+mobile+returned+recieved), 6, 1);
                
                int patientIssued = BloodStockController.getPatientIssuedBloodCount("Fresh blood", sqlDateC);
                int bulkIssued = BloodStockController.getBulkIssuedBloodCount("Fresh blood", sqlDateC);
                
                int issued = 0;
                if(patientIssued >=0 && bulkIssued >= 0){
                    issued = patientIssued+bulkIssued;
                }
                
                bloodDtm.setValueAt(""+issued, 7, 1);
                
                bloodDtm.setValueAt(""+(balance+inhouse+mobile+returned+recieved-issued), 8, 1);
                
                int discarded = BloodStockController.getDiscardedBloodCount("Fresh blood", sqlDateC);
                bloodDtm.setValueAt(""+discarded, 9, 1);
                
                bloodDtm.setValueAt(""+(balance+inhouse+mobile+returned+recieved-issued-discarded), 10, 1);
                
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockBalance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StockBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        DailyBloodStockDate = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        DailyBloodStockTable = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        DailyBloodDetailTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        DailyBloodDetailTable2 = new javax.swing.JTable();

        setTitle("Stock Balance");

        jLabel53.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel53.setText("Daily Blood Stock Balance");

        jLabel1.setText("Date");

        DailyBloodStockDate.setForeground(new java.awt.Color(255, 255, 255));
        DailyBloodStockDate.setDateFormatString("yyyy-MM-dd");
        DailyBloodStockDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DailyBloodStockDateMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DailyBloodStockDateMousePressed(evt);
            }
        });
        DailyBloodStockDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DailyBloodStockDatePropertyChange(evt);
            }
        });

        DailyBloodStockTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(153, 255, 255), new java.awt.Color(0, 51, 255)));
        DailyBloodStockTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DailyBloodStockTable.setModel(dailyBloodStockDtm);
        DailyBloodStockTable.setEnabled(false);
        jScrollPane4.setViewportView(DailyBloodStockTable);

        jTable9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable9.setModel(dailyComponentStockDtm);
        jTable9.setEnabled(false);
        jScrollPane9.setViewportView(jTable9);

        DailyBloodDetailTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(153, 255, 255), new java.awt.Color(0, 51, 255)));
        DailyBloodDetailTable1.setModel(bloodDtm);
        jScrollPane2.setViewportView(DailyBloodDetailTable1);

        DailyBloodDetailTable2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(153, 255, 255), new java.awt.Color(0, 51, 255)));
        DailyBloodDetailTable2.setModel(bloodDtm);
        jScrollPane3.setViewportView(DailyBloodDetailTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(DailyBloodStockDate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DailyBloodStockDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Daily Blood and Component Stock Balance", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DailyBloodStockDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DailyBloodStockDateMouseClicked

    }//GEN-LAST:event_DailyBloodStockDateMouseClicked

    private void DailyBloodStockDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DailyBloodStockDateMousePressed

    }//GEN-LAST:event_DailyBloodStockDateMousePressed

    private void DailyBloodStockDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DailyBloodStockDatePropertyChange
        setDailyBloodStock();
    }//GEN-LAST:event_DailyBloodStockDatePropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DailyBloodDetailTable1;
    private javax.swing.JTable DailyBloodDetailTable2;
    private com.toedter.calendar.JDateChooser DailyBloodStockDate;
    private javax.swing.JTable DailyBloodStockTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable9;
    // End of variables declaration//GEN-END:variables
}
