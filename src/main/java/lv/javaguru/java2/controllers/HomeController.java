package lv.javaguru.java2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arturs on 16.08.2016.
 */
@Controller
public class HomeController{

    @RequestMapping(value = "home", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("home", "model", null);
    }

    @RequestMapping(value = "home", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) {
        return new ModelAndView("home", "model", null);
    }
}
