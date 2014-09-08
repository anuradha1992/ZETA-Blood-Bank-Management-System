/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Anuradha
 */
public class Item {

    private String itemID;
    private String itemType;
    private String description;
    private double quantity;
    private String units;
    private int isReagent;

    public Item(String itemID, String itemType, String description, double quantity, String units, int isReagent) {
        this.itemID = itemID;
        this.itemType = itemType;
        this.description = description;
        this.quantity = quantity;
        this.units = units;
        this.isReagent = isReagent;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * @param itemType the itemType to set
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the units
     */
    public String getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     * @return the isReagent
     */
    public int getIsReagent() {
        return isReagent;
    }

    /**
     * @param isReagent the isReagent to set
     */
    public void setIsReagent(int isReagent) {
        this.isReagent = isReagent;
    }

}
