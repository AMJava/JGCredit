package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ErrorController implements MVCController {

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel(null, "/error.jsp", "",null);
    }

    @Override
    public MVCModel executePostRequest(HttpServletRequest request) {
        return new MVCModel(null, "/error.jsp", "",null);
    }
    }

