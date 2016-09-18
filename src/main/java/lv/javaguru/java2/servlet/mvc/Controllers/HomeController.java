package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arturs on 16.08.2016.
 */
@Component
public class HomeController implements MVCController {

    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel(null, "/index.jsp", "");
    }

    public MVCModel executePostRequest(HttpServletRequest request) {
        return new MVCModel(null, "/index.jsp","");
    }
}
