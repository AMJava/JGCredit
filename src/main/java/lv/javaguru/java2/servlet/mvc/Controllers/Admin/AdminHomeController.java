package lv.javaguru.java2.servlet.mvc.Controllers.Admin;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class AdminHomeController implements MVCController {

    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel("Admin Home", "/templates/admin/admin-home.jsp","");
    }

    public MVCModel executePostRequest(HttpServletRequest request) {
        return new MVCModel("Admin Home", "/templates/admin/admin-home.jsp","");
    }
}
