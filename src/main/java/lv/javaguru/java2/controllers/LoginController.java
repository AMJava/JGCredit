package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.domain.MVCModel;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.ConvertorUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;

@Controller
public class LoginController extends ErrorHandlingController{

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    ConvertorUserDTO convertorUserDTO;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "login", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("login", "model", null);
    }

    @RequestMapping(value = "login", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) throws Exception {
        try{

            User user = userService.checkAuthorization(
            request.getParameter("user"),
            request.getParameter("pass"));

            UserDTO userDTO = convertorUserDTO.convertUserToDTO(user);
            byte[] photoDTO = userDTO.getPhoto();
            if (photoDTO != null) {
                //FileOutputStream fos = new FileOutputStream("images\\output.jpg");  //windows
                FileOutputStream fos = new FileOutputStream("output.jpg");
                fos.write(userDTO.getPhoto());
                fos.close();
            }
            userService.login(userDTO);
            request.getSession().setAttribute("userDTO", userDTO);
            return new ModelAndView("redirect", "model", new MVCModel("/java2",null));
        }
        catch(ServiceException e) {
            errorResponse.setMessage(e.getMessage());
            return new ModelAndView("login", "model", new MVCModel(null,errorResponse));
        }
    }
}
