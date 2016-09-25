package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.unused.MVCController;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactsController{

    @RequestMapping(value = "contacts", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("contacts", "model", null);
    }

    @RequestMapping(value = "contacts", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) {
        return new ModelAndView("contacts", "model", null);
    }
}
