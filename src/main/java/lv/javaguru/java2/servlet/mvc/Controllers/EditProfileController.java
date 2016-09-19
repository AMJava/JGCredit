package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.businesslogic.SessionUserDTOService;
import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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
            return new MVCModel("Profile", "/templates/user/editProfile.jsp","",null);
        } catch (UnAuthorizedUserException e) {
            errorResponse.setMessage(e.getMessage());
            return  new MVCModel(null, "/templates/user/login.jsp", "",errorResponse);
        }
    }

    public MVCModel executePostRequest(HttpServletRequest request) {
        return new MVCModel("Profile", "/templates/user/editProfile.jsp","",null);
    }
}
