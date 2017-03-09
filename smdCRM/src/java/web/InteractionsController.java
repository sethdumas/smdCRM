/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.InteractionsDAO;
import repository.ClientsDAO;
import validation.InteractionsValidator;
import org.springframework.web.servlet.ModelAndView;
import objects.Interactions;
import objects.Clients;
import objects.Message;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author sethd
 */
@Controller
public class InteractionsController {

    @Autowired
    InteractionsDAO dao;

    @Autowired
    ClientsDAO cdao;

    @Autowired
    private InteractionsValidator interactionsValidator;

    /**
     *
     * @return
     */
    @RequestMapping("/interactions/interactionsform")
    public ModelAndView showform() {
        Interactions interactions = new Interactions();
        interactions.setClients(dao.getClientInteractMap());

        return new ModelAndView("interactionsform", "interactions", interactions);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("/interactions/interactionsform/{id}")
    public ModelAndView showformWithClient(@PathVariable int id) {
        Clients clients = cdao.getClientById(id);

        Interactions interactions = new Interactions();
        interactions.setClientid(id);
        interactions.setClient(clients);

        interactions.setClients(dao.getClientInteractMap());

        return new ModelAndView("interactionsform", "interactions", interactions);
    }

    /**
     *
     * @param interactions
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/interactions/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("interactions") @Valid Interactions interactions, BindingResult result, HttpServletRequest request) {
        int r = dao.save(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New interaction creation failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    /**
     *
     * @param interactions
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/interactions/interactionform/save", method = RequestMethod.POST)
    public ModelAndView inewsave(@ModelAttribute("interactions") @Valid Interactions interactions, BindingResult result, HttpServletRequest request) {
        int r = dao.save(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New interaction creation failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }
    
    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/interactions/viewinteractions")
    public ModelAndView viewinteractions(HttpServletRequest request) {

        return this.viewinteractions(1, request);
    }

    /**
     *
     * @param pageid
     * @param request
     * @return
     */
    @RequestMapping("/interactions/viewinteraction/{pageid}")
    public ModelAndView viewinteractions(@PathVariable int pageid, HttpServletRequest request) {
        int total = 10;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Interactions> list = dao.getInteractionsByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = dao.getInteractionsCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewinteractions", context);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/interactions/editinteractions/{interactionid}")
    public ModelAndView edit(@PathVariable int id) {
        Interactions interactions = dao.getInteractionsById(id);
        return new ModelAndView("interactionseditform", "interactions", interactions);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/interactions/interactionform/{id}")
    public ModelAndView inew(@PathVariable int id) {
        Clients clients = cdao.getClientById(id);

        Interactions interactions = new Interactions();
        interactions.setClientid(id);
        interactions.setClient(clients);

        interactions.setClients(dao.getClientInteractMap());
        
        return new ModelAndView("inew", "interactions",  interactions);
    }

    /**
     *
     * @param interactions
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/interactions/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("interactions") @Valid Interactions interactions, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("interactionseditform", "interactions", interactions);
        }
        int r = dao.update(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit interaction failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    /**
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/interactions/deleteinteractions/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = dao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete interaction failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    /**
     *
     * @param webDataBinder
     */
    @InitBinder("interactions")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(interactionsValidator);
    }

    /**
     *
     * @return
     */
    public InteractionsValidator getInteractionsValidator() {
        return interactionsValidator;
    }

    /**
     *
     * @param interactionsValidator
     */
    public void setInteractionsValidator(InteractionsValidator interactionsValidator) {
        this.interactionsValidator = interactionsValidator;
    }
}