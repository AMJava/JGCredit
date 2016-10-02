package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.LoanService;
import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.domain.Loan;
import lv.javaguru.java2.domain.MVCModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoanController extends ErrorHandlingController{

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    LoanService loanService;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "loans", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) throws Exception {
        try {
            userService.checkAuthorization();
            List<Loan> loans = loanService.getUserLoans();
            return new ModelAndView("loan", "model", new MVCModel(loans,null));
        } catch (UnAuthorizedUserException e) {
            errorResponse.setMessage(e.getMessage());
            return new ModelAndView("redirect", "model", new MVCModel("/java2/login",null));
        }
    }

    @RequestMapping(value = "loans", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) throws Exception {
        return new ModelAndView("loan", "model", null);
    }
}
