package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.LoanService;
import lv.javaguru.java2.domain.CalculateLoanRequest;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.CalculateLoanResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@RestController
public class CalculateLoanController {

    @Autowired
    LoanService loanService;

    private static Logger logger = LoggerFactory.getLogger(ErrorHandlingController.class);

    @ExceptionHandler(Exception.class)
    public CalculateLoanResponse handleError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        CalculateLoanResponse result = new CalculateLoanResponse();
        result.setTotal((double) 0);
        return result;
    }

    @RequestMapping(value = "/api/calculateLoan")
    public CalculateLoanResponse CalculateLoan(@RequestBody CalculateLoanRequest request) throws SQLException {

        Double total = loanService.CalculateLoan(request.getAmount(),request.getDuration(),request.getTerm());
        CalculateLoanResponse result = new CalculateLoanResponse();

         result.setTotal(total);

        return result;

    }
}
