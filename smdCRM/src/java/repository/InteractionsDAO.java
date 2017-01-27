/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import objects.Interactions;
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
    
    public int save(Interactions interactionid){
        String sql = "INSERT INTO Interactions (interactionid) values(?)";

        Object[] values = {interactionid.getInteractionid()};

        return template.update(sql,values);
    }
    
     public int update(Interactions interactionid){
        String sql = "UPDATE interactionid SET =? WHERE interactionid = ?";

        Object[] values = {interactionid.getInteractionid(),interactionid.getInteractionid()};

        return template.update(sql,values);
    }
     
     public int delete(int interactionid){
        String sql = "DELETE FROM interactions WHERE interactionid = ?";

        Object[] values = {interactionid};

        return template.update(sql,values);
    }
     
    
     
     
}
