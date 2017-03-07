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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Users implements Serializable {
    
    private int userid;
    private String username;
    private String password;
    private Boolean enabled;
    private List<String> userrole;     
    private Map<String, String> rolemap;
    private Map<String, String> enable;


    public int getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getUserrole() {
        return userrole;
    }

    public Boolean getEnabled() {
        if(enabled == null){
            return false;
        }
        return enabled;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
   
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param userrole
     */
    public void setUserrole(List<String> userrole) {
        this.userrole = userrole;
    }

    public void setEnabled(boolean enabled) {
        
        this.enabled = enabled;
    }
    
    public Map<String, String> getEnabledMap() {
        enable = new LinkedHashMap<>();
        enable.put("0", "not enabled");
        enable.put("1", "enabled");

        return enable;
    }
    
    public Map<String, String> getRolemap() {

        rolemap = new LinkedHashMap<String, String>();
        rolemap.put("ROLE_ADMIN", "Admin");
        rolemap.put("ROLE_USER", "User");

        return rolemap;
    }


    
    
    public String toString() { StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.userid + ";");
        buffer.append("Username: " + username);
        buffer.append("User Role:" + userrole);
        buffer.append("User Status: " + enabled);
        return buffer.toString();}
    
    

   
}
