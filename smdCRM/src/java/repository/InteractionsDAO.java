/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import objects.Interactions;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import objects.Clients;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.text.DateFormat;
import java.util.Date;
/**
 *
 * @author sethd
 */
public class InteractionsDAO {
    JdbcTemplate template;
    
    private static final Logger logger = Logger.getLogger(InteractionsDAO.class.getName());

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public int save(Interactions interactions){
        String sql = "INSERT INTO interactions (interactionid, clientid, username, typeofinteraction, interactiontime) values(?, ?, ?, ?, ?)";

        Object[] values = {interactions.getInteractionid(), interactions.getClientid(), interactions.getUsername(), interactions.getTypeofinteraction(), interactions.getInteractiontime()};

        logger.info("Interactions DAO save values: " + values);
        
        return template.update(sql,values);
    }
    
     public int update(Interactions interactions){
        String sql = "UPDATE interactions SET clientid = ?,username = ?, typeofinteraction = ?, interactiontime = ? WHERE interactionid = ?";

        Object[] values = {interactions.getClientid(),interactions.getUsername(), interactions.getTypeofinteraction(), interactions.getInteractiontime()};

        return template.update(sql,values);
    }
     
     public int delete(int interactionid){
        String sql = "DELETE FROM interactions WHERE interactionid =" + interactionid + "";

    //    Object[] values = {interactionid};

        return template.update(sql);
    }
     
     public List<Interactions> getInteractionsList(int clientid) {
        return template.query("SELECT * FROM interactions WHERE clientid = " + clientid, new RowMapper<Interactions>() {
            @Override
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractionid(rs.getInt(1));
                i.setClientid(rs.getInt(2));
                i.setUsername(rs.getString(3));
//                i.setFirstname(rs.getString("First Name"));
//                i.setLastname(rs.getString("Last Name"));
                i.setTypeofinteraction(rs.getString(4));
                i.setInteractiontime(rs.getString(5));
                
                return i;
            }
        });
    }
     
     public Interactions getInteractionsById(int interactionid) {
         
        String sql = "SELECT * FROM interactions WHERE interactionid = ?";
        return template.queryForObject(sql, new Object[]{interactionid}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }
    
    public List<Interactions> getInteractionsByPage(int start, int total) {
        String sql = "SELECT interactions.interactionid, interactions.clientid, interactions.username, interactions.typeofinteraction, interactions.interactiontime, clients.id "
                + "FROM interactions AS interactions "
                + "INNER JOIN Clients AS clients ON clients.id = interactions.clientid "
                + "ORDER BY clients.id, interactions.interactiontime "
                + "LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Interactions>() {
            @Override
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractionid(rs.getInt(1));
                i.setClientid(rs.getInt(2));
//                i.setFirstname(rs.getString(3));
//                i.setLastname(rs.getString(4));
                i.setTypeofinteraction(rs.getString(5));           
                i.setInteractiontime(rs.getString(6));


                Clients clients = new Clients();
                clients.setId(rs.getInt(1));
                clients.setFirstname(rs.getString(2));
                clients.setLastname(rs.getString(3));

                i.setClient(clients);
                
                return i;
            }
        });
    }
    public int getInteractionsCount() {
        String sql = "SELECT COUNT(interactionid) AS irow FROM interactions";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("irow");
        }

        return 1;
    }
    
    public Map<Integer, String> getClientInteractMap() {
        Map<Integer, String> Clients = new LinkedHashMap<Integer, String>();
        String sql = "SELECT id, firstname, lastname FROM clients ORDER BY firstname";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            Clients.put(rs.getInt(1), rs.getString(2) + " " + rs.getString(3));
        }

        return Clients;
    }

}
