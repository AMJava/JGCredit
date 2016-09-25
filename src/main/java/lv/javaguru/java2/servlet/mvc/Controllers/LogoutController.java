package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController{

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "logout", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        if (request.getSession().getAttribute("userDTO") != null) {
            request.getSession().removeAttribute("userDTO");
        }
        return new ModelAndView("home", "model", null);
    }


    @RequestMapping(value = "logout", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) {
        if (request.getSession().getAttribute("userDTO") != null) {
            request.getSession().removeAttribute("userDTO");
        }
        return new ModelAndView("home", "model", null);
    }
    }

