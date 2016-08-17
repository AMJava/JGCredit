package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class AboutController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("About", "/templates/user/about.jsp");
    }

}
