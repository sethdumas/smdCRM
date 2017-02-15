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
import objects.Clients;
import repository.ClientsDAO;
import validation.ClientsValidator;
import objects.Message;        
import java.util.HashMap;
import java.util.logging.Logger;
import repository.ClientsDAO;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
public class ClientsController{
    
     private static final Logger logger = Logger.getLogger(ClientsController.class.getName());
    
     @Autowired
    ClientsDAO dao;
    
    @Autowired
    private ClientsValidator clientsValidator;
    
    @RequestMapping("/clients/clientsform")
    public ModelAndView showform(){
        return new ModelAndView("clientsform","clients",new Clients());
    }
    
    @RequestMapping(value = "/clients/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("clients") @Valid Clients clients, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("clientform", "clients", clients);
        }
        int r = dao.save(clients);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New client creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/clients/viewclients");
    }
    
    @RequestMapping("/client/viewclients")
    public ModelAndView viewclients(HttpServletRequest request) {
        return this.viewclients(1, request);
    }
    
    @RequestMapping("/clients/viewclients/{pageid}")
    public ModelAndView viewclients(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;  
        }  
        
        List<Clients> list = dao.getClientsByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        
        int count = dao.getClientsCount();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
       
        return new ModelAndView("viewclients", context);
    }
    
    @RequestMapping(value = "/clients/editclients/{id}")
    public ModelAndView edit(@PathVariable int id){
        Clients clients = dao.getClientById(id);
        return new ModelAndView("clientseditform","clients",clients);
    }
    
    @RequestMapping(value = "/clients/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("clients") @Valid Clients clients, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return new ModelAndView("clientseditform", "clients", clients);
        }
        
        int r = dao.update(clients);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Edit client failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/clients/viewclients");
    }
    
    @RequestMapping(value = "/clients/deleteclient/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request){
        int r = dao.delete(id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Delete client failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/clients/viewclients");
    }
    
    @InitBinder("clients")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(clientsValidator);
    }
    
    public ClientsValidator getClientsValidator() {
        return clientsValidator;
    }
 
    public void setClientsValidator(ClientsValidator clientsValidator) {
        this.clientsValidator = clientsValidator;
    }  

}