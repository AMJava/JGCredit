package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.domain.MVCModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactsController extends ErrorHandlingController{

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "contacts", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        try {
            userService.checkAuthorization();
            return new ModelAndView("contacts", "model", null);
        } catch (UnAuthorizedUserException e) {
            errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("login","model",new MVCModel(null,errorResponse));
        }
    }

    @RequestMapping(value = "contacts", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) throws Exception {
        return new ModelAndView("contacts", "model", null);
    }
}
