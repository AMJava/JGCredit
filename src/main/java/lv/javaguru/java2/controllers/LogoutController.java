package lv.javaguru.java2.controllers;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.MVCModel;
import lv.javaguru.java2.dto.ConvertorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController extends ErrorHandlingController{

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "logout", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        if (request.getSession().getAttribute("userDTO") != null) {
            request.getSession().removeAttribute("userDTO");
        }
        return new ModelAndView("redirect", "model", new MVCModel("/java2/home",null));
    }


    @RequestMapping(value = "logout", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) throws Exception {
        if (request.getSession().getAttribute("userDTO") != null) {
            request.getSession().removeAttribute("userDTO");
        }
        return new ModelAndView("home", "model", null);
    }
    }

