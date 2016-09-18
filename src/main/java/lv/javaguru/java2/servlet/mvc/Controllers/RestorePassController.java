package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;

@Component
public class RestorePassController implements MVCController {

    @Autowired
    UserService userService;

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    ErrorResponse errorResponse;

    @Override
    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel(null, "/templates/user/restorePass.jsp","",null);
    }

    @Override
    public MVCModel executePostRequest(HttpServletRequest request) {

        try{
            userService.restorePass(
            request.getParameter("user"),
            request.getParameter("question"),
            request.getParameter("answer"));

            //request.getSession().setAttribute("userDTO", userDTO);
            return new MVCModel(null,"/redirect.jsp", "/java2",null);
        }
        catch(ServiceException e) {
            errorResponse.setMessage(e.getMessage());
            return  new MVCModel(null, "/templates/user/restorePass.jsp", "",errorResponse);
        } catch(CommunicationException e) {
            errorResponse.setMessage(e.getMessage());
            return  new MVCModel(null, "/templates/user/restorePass.jsp", "",errorResponse);
        }  catch (Exception e) {
            errorResponse.setMessage(e.getMessage());
            return  new MVCModel(null, "/error.jsp", "",errorResponse);
        }
    }
}
