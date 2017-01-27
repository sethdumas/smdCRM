/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author sethd
 */

import java.io.Serializable;

public class Items implements Serializable {
    
    private int itemcode;
    private String description;
    private int cost;

    public int getItemcode() {
        return itemcode;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public void setItemcode(int itemcode) {
        this.itemcode = itemcode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
        
}
