package web;

/**
 *
 * @author sethd
*/

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import objects.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ClientsDAO;
import repository.InteractionsDAO;
import repository.UsersDAO;
        
@Controller
public class HomeController {
      @Autowired
    ClientsDAO dao;
     
     @Autowired
    InteractionsDAO idao;
     
    @Autowired
    UsersDAO udao;
    
    @RequestMapping("/")
    public ModelAndView viewclients(){
        return new ModelAndView("index");
    }
    
}
