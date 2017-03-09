package web;


import static com.sun.faces.facelets.util.Path.context;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import objects.Clients;
import objects.Message;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ClientsDAO;
import repository.InteractionsDAO;
import repository.UsersDAO;

/**
 *
 * @author sethd
*/
        
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
       
        int crow = dao.getClientsCount();
        context.put("crow", crow);
 
        int irow = idao.getInteractionsCount();
        context.put("irow", irow);
        

     
        return new ModelAndView("index", context);
    }
    
}
        