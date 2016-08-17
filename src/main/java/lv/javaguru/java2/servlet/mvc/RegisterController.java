package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class RegisterController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Register Member", "/templates/user/register.jsp");
    }

}
