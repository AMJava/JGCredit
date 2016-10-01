package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
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
public class ChangePassController extends ErrorHandlingController{

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "changePassword", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("changePass", "model", null);
}

    @RequestMapping(value = "changePassword", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request)  throws Exception {

        try{
            userService.changePass(
            request.getParameter("password"),
            request.getParameter("newPassword"),
            request.getParameter("newPassword2"));

            return new ModelAndView("redirect", "model", new MVCModel("/java2/profile",null));
        }
        catch(ServiceException e) {
            errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("changePass","model",new MVCModel(null,errorResponse));
        }
        catch(UnAuthorizedUserException e) {
            errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("changePass","model",new MVCModel(null,errorResponse));
        }
    }
}
