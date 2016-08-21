package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class LoginController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Login", "/templates/user/login.jsp");
    }

}
