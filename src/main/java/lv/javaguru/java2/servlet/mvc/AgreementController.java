package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class AgreementController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Take a loan", "/agreement.jsp");
    }

}
