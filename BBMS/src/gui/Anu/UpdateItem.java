/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.Anu;

import controller.anu.ItemDA;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Item;

/**
 *
 * @author Anuradha
 */
public class UpdateItem extends javax.swing.JInternalFrame {

    private Item item;
    private ItemManagement itemManagement;
    /**
     * Creates new form updateItem
     */
    public UpdateItem(Item item, ItemManagement itemManagement) {
        initComponents();
        this.item = item;
        this.itemManagement = itemManagement;
        setItemFields();
    }
    
    private void setItemFields(){
        itemIDLabel.setText(item.getItemID());
        itemTypeText.setText(item.getItemType());
        descriptionText.setText(item.getDescription());
        qtyText.setText(""+item.getQty());
        unitsText.setText(item.getUnits());
        if(item.getIsReagent() == 0){
            reagentCheckbox.setSelected(false);
        }else{
            reagentCheckbox.setSelected(true);
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

        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        itemTypeText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        descriptionText = new javax.swing.JTextField();
        addItemBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        qtyText = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        unitsText = new javax.swing.JTextField();
        reagentCheckbox = new javax.swing.JCheckBox();
        itemIDLabel = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(153, 255, 255), new java.awt.Color(0, 51, 255)), "Update Item"));

        jLabel6.setText("Item ID");

        jLabel7.setText("Item type");

        itemTypeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTypeTextActionPerformed(evt);
            }
        });

        jLabel8.setText("Description");

        descriptionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTextActionPerformed(evt);
            }
        });

        addItemBtn.setText("Update Item");
        addItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Quantity");

        qtyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyTextActionPerformed(evt);
            }
        });

        jLabel16.setText("Units");

        unitsText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitsTextActionPerformed(evt);
            }
        });

        reagentCheckbox.setText("Reagent");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reagentCheckbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(unitsText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(qtyText, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(descriptionText, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(itemTypeText, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(itemIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(20, 20, 20))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(itemIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qtyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(reagentCheckbox)
                .addGap(18, 18, 18)
                .addComponent(addItemBtn)
                .addContainerGap())
        );

        jLabel51.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel51.setText("Update Item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemTypeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTypeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemTypeTextActionPerformed

    private void descriptionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionTextActionPerformed

    private void addItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtnActionPerformed
        try {
            String itemID = itemIDLabel.getText();
            String itemType = itemTypeText.getText();
            String description = descriptionText.getText();
            float qty = Float.parseFloat(qtyText.getText());
            String units = unitsText.getText();
            byte isReagent = 0;

            if (reagentCheckbox.isSelected()) {
                isReagent = 1;
            }

            Item item = new Item(itemID, itemType, description, isReagent, units, qty);
            int added = ItemDA.updateItem(item);

            if (added == 1) {
                JOptionPane.showMessageDialog(null, "Updated Succesfully");
                itemManagement.setTableItems();
                itemManagement.setItemIdComboItems();
                itemManagement.setRequestItemIDComboItems();
                itemManagement.setItemIDLabel();
                itemManagement.clearItemAddFields();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error!");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addItemBtnActionPerformed

    private void qtyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyTextActionPerformed

    private void unitsTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitsTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitsTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemBtn;
    private javax.swing.JTextField descriptionText;
    private javax.swing.JLabel itemIDLabel;
    private javax.swing.JTextField itemTypeText;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField qtyText;
    private javax.swing.JCheckBox reagentCheckbox;
    private javax.swing.JTextField unitsText;
    // End of variables declaration//GEN-END:variables
}
