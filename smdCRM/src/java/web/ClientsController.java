/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

/**
 *
 * @author sethd
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import repository.ClientsDAO;
import repository.InteractionsDAO;
import repository.ItemsDAO;
import repository.SalesDAO;

@Controller
public class ClientsController{
    @Autowired
    ClientsDAO dao;
    
    @Autowired
    InteractionsDAO intdao = new InteractionsDAO();
    
    @Autowired
    ItemsDAO itdao = new ItemsDAO();
    
    @Autowired
    SalesDAO sdao = new SalesDAO();
    
       
    private static final Logger logger = Logger.getLogger(ClientsController.class.getName());
    
    @RequestMapping("/clients/clientsform")
   public ModelAndView showform(){
        return new ModelAndView("clientsform","name",new Client());
    }

}
    



    

