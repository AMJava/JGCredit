package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.domain.MVCModel;
import lv.javaguru.java2.dto.ConvertorUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestorePassController extends ErrorHandlingController{

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    ConvertorUserDTO convertorUserDTO;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "restorePassword", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("restorePass", "model", null);
    }


    @RequestMapping(value = "restorePassword", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) throws Exception {

        try{
            userService.restorePass(
            request.getParameter("user"),
            request.getParameter("question"),
            request.getParameter("answer"));

            return new ModelAndView("redirect", "model", new MVCModel("/java2",null));
        }
        catch(ServiceException e) {
            errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("restorePass","model",new MVCModel(null,errorResponse));
        } catch(CommunicationException e) {
            errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("restorePass","model",new MVCModel(null,errorResponse));
        }
    }
}
