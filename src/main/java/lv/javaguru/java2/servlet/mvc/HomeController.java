package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arturs on 16.08.2016.
 */
public class HomeController implements MVCController {
    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("", "/index.jsp");
    }
}
