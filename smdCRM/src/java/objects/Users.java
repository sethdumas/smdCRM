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


public class Users implements Serializable {
    
    private String username;
    private String usertype;

    public String getUsername() {
        return username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    
    
    
}
