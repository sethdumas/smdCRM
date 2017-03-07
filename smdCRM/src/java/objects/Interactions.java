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
import java.util.Map;

public class Interactions implements Serializable {
    
    private int interactionid;
    private int clientid;
    private String userid;
    private String firstname;
    private String lastname;
    private String typeofinteraction;
    private Date interactiontime;
    private Clients client;
    private Map<Integer, String> clients;
    private Map<String, String> user;

    public Clients getClient() {
        return client;
    }

    public Map<Integer, String> getClients() {
        return clients;
    }

    public Map<String, String> getUser() {
        return user;
    }

    
    
    public int getInteractionid() {
        return interactionid;
    }

    public int getClientid() {
        return clientid;
    }

    public String getUserid() {
        return userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTypeofinteraction() {
        return typeofinteraction;
    }

    public Date getInteractiontime() {
        return interactiontime;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public void setClients(Map<Integer, String> clients) {
        this.clients = clients;
    }

    public void setUser(Map<String, String> user) {
        this.user = user;
    }

    
    
    public void setInteractionid(int interactionid) {
        this.interactionid = interactionid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTypeofinteraction(String typeofinteraction) {
        this.typeofinteraction = typeofinteraction;
    }

    public void setInteractiontime(Date interactiontime) {
        this.interactiontime = interactiontime;
    }

}
