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
import java.util.Date;

public class Sales implements Serializable {
    
    private int transactionid;
    private int clientid;
    private int itemcode;
    private int quantity;
    private int total;
    private String status;
    private Date orderdate;

    public int getTransactionid() {
        return transactionid;
    }

    public int getClientid() {
        return clientid;
    }

    public int getItemcode() {
        return itemcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public Date getOrderdate() {
        return orderdate;
    }
    
    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public void setItemcode(int itemcode) {
        this.itemcode = itemcode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
    
    
    
        
}
