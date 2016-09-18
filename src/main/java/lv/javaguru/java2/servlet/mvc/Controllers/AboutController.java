package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class AboutController implements MVCController {

    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel("About", "/templates/user/about.jsp","",null);
    }

    public MVCModel executePostRequest(HttpServletRequest request) {
        return new MVCModel("About", "/templates/user/about.jsp","",null);
    }
}
