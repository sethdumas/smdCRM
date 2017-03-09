package web;

/**
 *
 * @author sethd
*/

import static com.sun.faces.facelets.util.Path.context;
import java.util.HashMap;
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
        
        HashMap<String, Object> context = new HashMap<>();
        context.put("crow", dao.getClientsCount());
        context.put("irow", idao.getInteractionsCount());
        
        
        
        return new ModelAndView("index");
    }
    
}
