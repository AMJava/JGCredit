package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;

import javax.servlet.http.HttpServletRequest;

public class LoanController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Take a loan", "/templates/user/loan.jsp");
    }

}
