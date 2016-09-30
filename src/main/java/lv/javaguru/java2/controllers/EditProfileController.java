package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.SessionUserDTOService;
import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.domain.MVCModel;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class EditProfileController{

    @Autowired
    SessionUserDTOService sessionUserDTOService;

    @Autowired
    UserService userService;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "editProfile", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        try {
            userService.checkAuthorization();
            return new ModelAndView("editProfile", "model", null);
        } catch (UnAuthorizedUserException e) {
            errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("login","model",new MVCModel(null,errorResponse));
        }
    }

    @RequestMapping(value = "editProfile", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) throws SQLException {
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
            return new ModelAndView("redirect", "model", new MVCModel("/java2/profile",null));
        } catch(ServiceException e) {
                errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("editProfile","model",new MVCModel(null,errorResponse));
            }
          catch (Exception e) {
            errorResponse.setMessage(e.getMessage());
              return  new ModelAndView("error","model",new MVCModel(null,errorResponse));
        }
    }
}
