package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class LoanController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Take a loan", "/templates/user/loan.jsp");
    }

}
