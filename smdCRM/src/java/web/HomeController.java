package web;

/**
 *
 * @author sethd
*/

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import objects.Clients;
        
@Controller
public class HomeController {
     @RequestMapping("/")
    public ModelAndView viewclient(){
        return new ModelAndView("index");
    }
    
}
