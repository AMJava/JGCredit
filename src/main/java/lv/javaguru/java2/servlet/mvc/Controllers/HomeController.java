package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arturs on 16.08.2016.
 */
public class HomeController implements MVCController {
    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("", "/templates/user/user-home.jsp");
    }
}
