package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

@Component
public class LoginController implements MVCController {

    @Autowired
    UserService userService;

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    ErrorResponse errorResponse;

    @Override
    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel(null, "/templates/user/login.jsp","",null);
    }

    @Override
    public MVCModel executePostRequest(HttpServletRequest request) {

        try{

            User user = userService.checkAuthorization(
            request.getParameter("user"),
            request.getParameter("pass"));

            UserDTO userDTO = convertorDTO.convertUserToDTO(user);
            byte[] photoDTO = userDTO.getPhoto();
            if (photoDTO != null) {
                //FileOutputStream fos = new FileOutputStream("images\\output.jpg");  //windows
                FileOutputStream fos = new FileOutputStream("output.jpg");
                fos.write(userDTO.getPhoto());
                fos.close();
            }
            userService.login(userDTO);
            request.getSession().setAttribute("userDTO", userDTO);
            return new MVCModel(userDTO,"/redirect.jsp", "/java2",null);
        }
        catch(ServiceException e) {
            errorResponse.setMessage(e.getMessage());
            return  new MVCModel(null, "/templates/user/login.jsp", "",errorResponse);
        } catch (Exception e) {
            errorResponse.setMessage(e.getMessage());
            return  new MVCModel(null, "/error.jsp", "",errorResponse);
        }
    }
}
