package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AboutController{

    @RequestMapping(value = "about", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("about", "model", null);
    }

    @RequestMapping(value = "about", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) {
        return new ModelAndView("about", "model", null);
    }
}
