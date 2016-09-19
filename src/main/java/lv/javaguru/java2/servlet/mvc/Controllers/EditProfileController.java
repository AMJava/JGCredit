package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.businesslogic.SessionUserDTOService;
import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EditProfileController implements MVCController {

    @Autowired
    SessionUserDTOService sessionUserDTOService;

    @Autowired
    UserService userService;

    @Autowired
    ErrorResponse errorResponse;

    public MVCModel executeGetRequest(HttpServletRequest request) {
        try {
            userService.checkAuthorization();
            return new MVCModel("Profile", "/templates/user/editProfile.jsp", "", null);
        } catch (UnAuthorizedUserException e) {
            errorResponse.setMessage(e.getMessage());
            return new MVCModel(null, "/templates/user/login.jsp", "", errorResponse);
        }
    }

    public MVCModel executePostRequest(HttpServletRequest request) throws SQLException {
        UserDTO userDTO = null;
        try {
            userDTO = userService.gerSessionUserDTO();
            userDTO.setAddress(request.getParameter("address"));
            userDTO.setPhoneNumber(request.getParameter("phoneNumber"));
            userDTO.setCompany(request.getParameter("companyName"));
            userDTO.setJobTitle(request.getParameter("jobTitle"));
            userDTO = userService.updateEditable(userDTO);
            userService.login(userDTO);
            request.getSession().setAttribute("userDTO", userDTO);
            return new MVCModel(userDTO, "/redirect.jsp", "/java2/profile", null);
        } catch(ServiceException e) {
                errorResponse.setMessage(e.getMessage());
                return  new MVCModel(null, "/templates/user/editProfile.jsp", "",errorResponse);
            }
          catch (Exception e) {
            errorResponse.setMessage(e.getMessage());
            return new MVCModel(null, "/error.jsp", "", errorResponse);
        }
    }
}
