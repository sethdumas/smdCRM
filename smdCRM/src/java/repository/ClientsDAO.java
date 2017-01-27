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
import org.springframework.jdbc.core.JdbcTemplate;
import objects.Clients;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

        
/**
 *
 * @author sethd
 */
public class ClientsDAO {
    JdbcTemplate template;
    
        private static final Logger logger = Logger.getLogger(ClientsDAO.class.getName());
        
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public int save(Clients name){
        String sql = "INSERT INTO Clients (name) values(?)";

        Object[] values = {name.getName()};

        return template.update(sql,values);
    }
    
    public int update(Clients name){
        String sql = "UPDATE Clients SET name=? WHERE Id = ?";

        Object[] values = {name.getName(),name.getId()};

        return template.update(sql,values);
    }
    
    public int delete(int id){
        String sql = "DELETE FROM Clients WHERE Id = ?";

        Object[] values = {id};

        return template.update(sql,values);
    }
    
    public List<Clients> getClientList(){
        return template.query("SELECT * FROM name",new RowMapper<Clients>(){
            public Clients mapRow(ResultSet rs,int row) throws SQLException{
                Clients a = new Clients();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                return a;
            }
        });
    }
    
    public Clients getClientById(int id){
        logger.info("Get client by ID: " + id);
        String sql = "SELECT id AS id, name FROM Clients WHERE id = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Clients>(Clients.class));
    }
    
    public List<Clients> getClientsByPage(int start, int total){
        String sql = "SELECT * FROM Clients LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<Clients>(){
            public Clients mapRow(ResultSet rs,int row) throws SQLException{
                Clients a = new Clients();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                return a;
            }
        });
    }
    
    public int getClientsCount() {
        String sql = "SELECT COUNT(id) AS rowcount FROM Clients";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
    
}
