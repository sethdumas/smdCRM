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
    
    private String username;
    private String password;
    //private Boolean enabled;
    private List<String> role;     
    private Map<String, String> rolemap;
    //private Map<String, String> enablemap;

    /**
     *
     */
    public Users(){
        this.rolemap = new LinkedHashMap<String,String>();
        this.rolemap.put("ROLE_USER",  "User");
        this.rolemap.put("ROLE_ADMIN", "Administrator");
    }
    
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRole() {
        return role;
    }

//    public Boolean getEnabled() {
//        if(enabled == null){
//            return false;
//        }
//        return enabled;
//    }

   
   
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param role
     */
    public void setRole(List<String> role) {
        this.role = role;
    }

//    public void setEnabled(boolean enabled) {
//        
//        this.enabled = enabled;
//    }
    
//    public Map<String, String> getEnableMap() {
//        enablemap = new LinkedHashMap<>();
//        enablemap.put("0", "not enabled");
//        enablemap.put("1", "enabled");

//        return enablemap;
//    }
    
    public Map<String, String> getRolemap() {

        rolemap = new LinkedHashMap<String, String>();
        rolemap.put("ROLE_ADMIN", "Admin");
        rolemap.put("ROLE_USER", "User");

        return rolemap;
    }


    
    
    public String toString() { StringBuffer buffer = new StringBuffer();
     
        buffer.append("Username: " + username);
        buffer.append("User Role:" + role);
//        buffer.append("User Status: " + enabled);
        return buffer.toString();}
    
    

   
}
