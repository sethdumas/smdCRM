/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import objects.Items;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author sethd
 */
public class ItemsDAO {
    JdbcTemplate template;
    
    private static final Logger logger = Logger.getLogger(InteractionsDAO.class.getName());

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public int save(Items itemcode){
        String sql = "INSERT INTO items (itemcode) values(?)";

        Object[] values = {itemcode.getItemcode()};

        return template.update(sql,values);
    }
    
     public int update(Items itemcode){
        String sql = "UPDATE itemcode SET =? WHERE itemcode = ?";

        Object[] values = {itemcode.getItemcode(),itemcode.getDescription(), itemcode.getCost()};

        return template.update(sql,values);
    }
     
     public int delete(int itemcode){
        String sql = "DELETE FROM items WHERE itemcode = ?";

        Object[] values = {itemcode};

        return template.update(sql,values);
    }
          
       public List<Items> getItemsList(){
        return template.query("SELECT * FROM items",new RowMapper<Items>(){
            public Items mapRow(ResultSet rs,int row) throws SQLException{
                Items a = new Items();
                a.setItemcode(rs.getInt("itemcode"));
                a.setDescription(rs.getString("description"));
                a.setCost(rs.getInt("cost"));
                return a;
            }
        });
    }
       

}
