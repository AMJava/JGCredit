package lv.javaguru.java2.servlet.mvc.Controllers.Admin;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class AdminContactsController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Contacts", "/templates/admin/admin-users.jsp");
    }

}