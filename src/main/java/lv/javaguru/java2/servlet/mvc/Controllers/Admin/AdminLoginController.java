package lv.javaguru.java2.servlet.mvc.Controllers.Admin;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Admin Login", "/templates/admin/admin-login.jsp");
    }

}
