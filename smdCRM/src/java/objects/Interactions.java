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

public class Interactions implements Serializable {
    
    private int interactionid;
    private String typeofinteraction;
    private int clientid;
    private String clientname;
    private String clientuser;
    private Date interactiontime;

    public int getInteractionid() {
        return interactionid;
    }

    public String getTypeofinteraction() {
        return typeofinteraction;
    }

    public int getClientid() {
        return clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public String getClientuser() {
        return clientuser;
    }

    public Date getInteractiontime() {
        return interactiontime;
    }

    public void setInteractionid(int interactionid) {
        this.interactionid = interactionid;
    }

    public void setTypeofinteraction(String typeofinteraction) {
        this.typeofinteraction = typeofinteraction;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public void setClientuser(String clientuser) {
        this.clientuser = clientuser;
    }

    public void setInteractiontime(Date interactiontime) {
        this.interactiontime = interactiontime;
    }
    
    
    
    
    
}
