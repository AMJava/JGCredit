package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
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
public class RestorePassController{

    @Autowired
    UserService userService;

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "restorePassword", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("restorePass", "model", null);
    }


    @RequestMapping(value = "restorePassword", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) {

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
        }  catch (Exception e) {
            errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("error","model",new MVCModel(null,errorResponse));
        }
    }
}
