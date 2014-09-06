/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DiscardedBlood.java
 *
 * Created on Sep 4, 2014, 10:19:02 AM
 */
package gui.Anu;

import Controller.Anu.BloodPacketController;
import java.awt.Dimension;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anuradha
 */
public class DiscardedBlood extends javax.swing.JInternalFrame {

    String[] title = {"PacketID", "Blood Type", "Blood Group", "Discarded Date"};
    DefaultTableModel dtm = new DefaultTableModel(title, 0);

    /** Creates new form DiscardedBlood */
    public DiscardedBlood(Dimension d) {

        initComponents();
        setSize(d);
        
    }

    private void displayDiscardedBloodPacketsByDuration() {
        java.util.Date dateS = startDateCalendar.getDate();
        java.util.Date dateE = endDateCalendar.getDate();

        if (dateS != null && dateE != null) {
            try {
                dtm = new DefaultTableModel(title, 0);
                discardedBloodTable.setModel(dtm);
                /*Start date*/
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = df.format(dateS);
                java.sql.Date sqlDateS = new java.sql.Date(dateS.getTime());
                /*End date*/
                String endDate = df.format(dateE);
                java.sql.Date sqlDateE = new java.sql.Date(dateE.getTime());
                ResultSet rst = BloodPacketController.getDiscardedBloodPacketsByDuration(sqlDateS, sqlDateE);

                String packetID = null;
                String bloodType = null;
                String bloodGroup = null;
                Date discardedDate = null;
                int count = 0;
                while (rst.next()) {
                    packetID = rst.getString("packetID");
                    bloodType = rst.getString("bloodType");
                    bloodGroup = rst.getString("bloodGroup");
                    discardedDate = rst.getDate("discardedDate");
                    String[] ar = {packetID, bloodType, bloodGroup, "" + discardedDate};
                    dtm.addRow(ar);
                    count++;
                }
                totalTxt.setText("" + count);


            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DiscardedBlood.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DiscardedBlood.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void displayDiscardedBloodPacketsByMonth() {
        int month = monthCalendar.getMonth();

        if (month >= 0) {
            try {
                dtm = new DefaultTableModel(title, 0);
                discardedBloodTable.setModel(dtm);

                ResultSet rst = BloodPacketController.getDiscardedBloodPacketsByMonth(month + 1);

                String packetID = null;
                String bloodType = null;
                String bloodGroup = null;
                Date discardedDate = null;
                int count = 0;
                while (rst.next()) {
                    packetID = rst.getString("packetID");
                    bloodType = rst.getString("bloodType");
                    bloodGroup = rst.getString("bloodGroup");
                    discardedDate = rst.getDate("discardedDate");
                    String[] ar = {packetID, bloodType, bloodGroup, "" + discardedDate};
                    dtm.addRow(ar);
                    count++;
                }
                totalTxt.setText("" + count);


            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DiscardedBlood.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DiscardedBlood.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void displayDiscardedBloodPacketsByYear() {
        int year = yearCalendar.getYear();

        if (year >= 0) {
            try {
                dtm = new DefaultTableModel(title, 0);
                discardedBloodTable.setModel(dtm);
                
                ResultSet rst = BloodPacketController.getDiscardedBloodPacketsByYear(year);

                String packetID = null;
                String bloodType = null;
                String bloodGroup = null;
                Date discardedDate = null;
                int count = 0;
                while (rst.next()) {
                    packetID = rst.getString("packetID");
                    bloodType = rst.getString("bloodType");
                    bloodGroup = rst.getString("bloodGroup");
                    discardedDate = rst.getDate("discardedDate");
                    String[] ar = {packetID, bloodType, bloodGroup, "" + discardedDate};
                    dtm.addRow(ar);
                    count++;
                }
                totalTxt.setText("" + count);


            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DiscardedBlood.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DiscardedBlood.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel44 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        discardedBloodTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        startDateCalendar = new com.toedter.calendar.JDateChooser();
        endDateCalendar = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        yearCalendar = new com.toedter.calendar.JYearChooser();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        monthCalendar = new com.toedter.calendar.JMonthChooser();
        jPanel9 = new javax.swing.JPanel();
        durationRadioBtn = new javax.swing.JRadioButton();
        monthRadioBtn = new javax.swing.JRadioButton();
        yearRadioBtn = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/immunohaetomology.jpg"))); // NOI18N

        jTabbedPane3.setFont(new java.awt.Font("Times New Roman", 1, 14));

        discardedBloodTable.setModel(dtm);
        jScrollPane1.setViewportView(discardedBloodTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Time Duration"));
        jPanel1.setEnabled(false);

        jLabel1.setText("Start Date");

        jLabel3.setText("End Date");

        startDateCalendar.setDateFormatString("yyyy-MM-dd");
        startDateCalendar.setEnabled(false);
        startDateCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startDateCalendarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                startDateCalendarMousePressed(evt);
            }
        });
        startDateCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startDateCalendarPropertyChange(evt);
            }
        });

        endDateCalendar.setDateFormatString("yyyy-MM-dd");
        endDateCalendar.setEnabled(false);
        endDateCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endDateCalendarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                endDateCalendarMousePressed(evt);
            }
        });
        endDateCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                endDateCalendarPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startDateCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(endDateCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(262, 262, 262))
        );

        jButton4.setText("Generate Report");

        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Year"));

        jLabel4.setText("Year");

        yearCalendar.setEnabled(false);
        yearCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yearCalendarPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(yearCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(294, 294, 294))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Month"));

        jLabel5.setText("Month");

        monthCalendar.setEnabled(false);
        monthCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                monthCalendarPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(monthCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monthCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(294, 294, 294))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Way of Navigating"));

        buttonGroup1.add(durationRadioBtn);
        durationRadioBtn.setText("By Duration");
        durationRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationRadioBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(monthRadioBtn);
        monthRadioBtn.setText("By month");
        monthRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthRadioBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(yearRadioBtn);
        yearRadioBtn.setText("By Year");
        yearRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearRadioBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(durationRadioBtn)
                .addGap(18, 18, 18)
                .addComponent(monthRadioBtn)
                .addGap(18, 18, 18)
                .addComponent(yearRadioBtn)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationRadioBtn)
                    .addComponent(monthRadioBtn)
                    .addComponent(yearRadioBtn))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel6.setText("Total");

        totalTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        totalTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 29, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(RefreshBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RefreshBtn)
                    .addComponent(jButton4)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19))
        );

        jTabbedPane3.addTab("Discarded Blood Stock", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void durationRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationRadioBtnActionPerformed
        startDateCalendar.setEnabled(true);
        endDateCalendar.setEnabled(true);
        monthCalendar.setEnabled(false);
        yearCalendar.setEnabled(false);

        displayDiscardedBloodPacketsByDuration();

    }//GEN-LAST:event_durationRadioBtnActionPerformed

    private void monthRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthRadioBtnActionPerformed
        startDateCalendar.setEnabled(false);
        endDateCalendar.setEnabled(false);
        monthCalendar.setEnabled(true);
        yearCalendar.setEnabled(false);

        displayDiscardedBloodPacketsByMonth();

    }//GEN-LAST:event_monthRadioBtnActionPerformed

    private void yearRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearRadioBtnActionPerformed
        startDateCalendar.setEnabled(false);
        endDateCalendar.setEnabled(false);
        monthCalendar.setEnabled(false);
        yearCalendar.setEnabled(true);

        displayDiscardedBloodPacketsByYear();

    }//GEN-LAST:event_yearRadioBtnActionPerformed

    private void startDateCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startDateCalendarMouseClicked
        
    }//GEN-LAST:event_startDateCalendarMouseClicked

    private void endDateCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endDateCalendarMouseClicked
        
    }//GEN-LAST:event_endDateCalendarMouseClicked

    private void startDateCalendarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startDateCalendarMousePressed
        
    }//GEN-LAST:event_startDateCalendarMousePressed

    private void endDateCalendarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endDateCalendarMousePressed
        
    }//GEN-LAST:event_endDateCalendarMousePressed

    private void startDateCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startDateCalendarPropertyChange
        displayDiscardedBloodPacketsByDuration();
    }//GEN-LAST:event_startDateCalendarPropertyChange

    private void endDateCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_endDateCalendarPropertyChange
        displayDiscardedBloodPacketsByDuration();
    }//GEN-LAST:event_endDateCalendarPropertyChange

    private void yearCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yearCalendarPropertyChange
        displayDiscardedBloodPacketsByYear();
    }//GEN-LAST:event_yearCalendarPropertyChange

    private void monthCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_monthCalendarPropertyChange
        displayDiscardedBloodPacketsByMonth();
    }//GEN-LAST:event_monthCalendarPropertyChange

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        if(durationRadioBtn.isSelected()){
            displayDiscardedBloodPacketsByDuration();
        }else if(monthRadioBtn.isSelected()){
            displayDiscardedBloodPacketsByMonth();
        }else if(yearRadioBtn.isSelected()){
            displayDiscardedBloodPacketsByYear();
        }
    }//GEN-LAST:event_RefreshBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable discardedBloodTable;
    private javax.swing.JRadioButton durationRadioBtn;
    private com.toedter.calendar.JDateChooser endDateCalendar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private com.toedter.calendar.JMonthChooser monthCalendar;
    private javax.swing.JRadioButton monthRadioBtn;
    private com.toedter.calendar.JDateChooser startDateCalendar;
    private javax.swing.JTextField totalTxt;
    private com.toedter.calendar.JYearChooser yearCalendar;
    private javax.swing.JRadioButton yearRadioBtn;
    // End of variables declaration//GEN-END:variables
}
