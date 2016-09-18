package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.sql.SQLException;

@Component
public class LogoutController implements MVCController {

//    @Autowired
//    UserLoginServiceImpl userLoginServiceImpl;

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public MVCModel executeGetRequest(HttpServletRequest request) {
        if (request.getSession().getAttribute("userDTO") != null) {
            request.getSession().removeAttribute("userDTO");
        }
        return new MVCModel(null, "/index.jsp", "");
    }

    @Override
    public MVCModel executePostRequest(HttpServletRequest request) {
        if (request.getSession().getAttribute("userDTO") != null) {
            request.getSession().removeAttribute("userDTO");
        }
        return new MVCModel(null, "/index.jsp", "");
    }
    }

