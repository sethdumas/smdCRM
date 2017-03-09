/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import objects.Users;
import objects.Clients;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author sethd
 */
public class UsersDAO {
    JdbcTemplate template;

    private static final Logger logger = Logger.getLogger(UsersDAO.class.getName());

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public int save(Users users) {
        String sql = "INSERT INTO users (username, password, role) values (?, md5(?), ?)";

        Object[] values = {users.getUsername(), users.getPassword(), users.getRole()};

        logger.info("Users DAO save values: " + values);

        int r = template.update(sql, values);

        sql = "INSERT INTO user_roles (username, role) VALUES (?, ?)";

        for (String role : users.getRole()) {
            Object[] role_values = {users.getUsername(), role};

            logger.info("Users DAO add role: " + values);

            template.update(sql, role_values);
        }

        return r;
    }
    
     public int update(Users users) {
       
      String  sql = "DELETE From user_roles WHERE username = ?";
        Object[] delete = {users.getUsername()};
        template.update(sql, delete);
        
        sql = "INSERT INTO user_roles (username, role) VALUES (?, ?)";
        
        for (String role: users.getRole()) {
            Object[] role_values = {users.getUsername(), role};
            
           
            
            template.update(sql, role_values);
        
    }
        
        
        sql = "UPDATE users SET (username = ?, 'password' = md5(?), role = ?) WHERE Username = ?";
        Object[] values = {users.getUsername(), users.getPassword(), users.getRole()};
        int r = template.update(sql, values);
        
        
     return r;   
    }
    
//    public int update(Users users) {
//        String sql = "UPDATE users SET (username = ?, password = md5(?), role = ?) WHERE Username = ?";
//
//        Object[] values = {users.getUsername(), users.getPassword(), users.getRole()};
//
//        logger.info("Users DAO save values: " + values);
//
//        int r = template.update(sql, values);
//
//        sql = "UPDATE INTO user_roles (username, role) VALUES (?, ?)";
//
//        for (String role : users.getRole()) {
//            Object[] role_values = {users.getUsername(), role};
//
//            logger.info("Users DAO update role: " + values);
//
//            return template.update(sql, values);
//        }
//
//        return r;
//    }
//    
    public int delete(Users users) {
        String sql = "DELETE FROM users WHERE username = ?";
        Object[] values = {users.getUsername()};
        return template.update(sql, values);
    }
    
     public List<Users> getUsersList() {
        return template.query("SELECT * FROM users", new RowMapper<Users>() {
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users u = new Users();
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
//                u.setEnabled(rs.getBoolean("Enabled"));
                return u;
            }
        });
    }
    
     public Users getUsersByUsername(String username) {
        logger.info("Get Users by Name: " + username);
        String sql = "SELECT * FROM users WHERE username = ?";
        return template.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<Users>(Users.class));
    } 
    
     public List<Users> getUsersByPage(int start, int total) {
        String sql = "SELECT * FROM users LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Users>() {
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users u = new Users();
                u.setUsername(rs.getString(1));
//                u.setEnabled(rs.getBoolean(2));
                return u;
            }
        });
    }
     
     public int getUsersCount() {
        String sql = "SELECT COUNT(username) AS rowcount FROM users";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }

     
}