package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.LoanService;
import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.domain.MVCModel;
import lv.javaguru.java2.dto.LoanDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TakeLoanController extends ErrorHandlingController{

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoanService loanService;

    @Autowired
    UserService userService;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "takeLoan", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        try {
            userService.checkAuthorization();
            return new ModelAndView("takeLoan", "model", null);
        } catch (UnAuthorizedUserException e) {
            errorResponse.setMessage(e.getMessage());
            return new ModelAndView("redirect", "model", new MVCModel("/java2/login",null));
        }
    }

    @RequestMapping(value = "takeLoan", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) throws Exception {
        try {
            LoanDTO loanDTO = (LoanDTO) request.getSession().getAttribute("loanDTO");
            loanDTO.setBankAccountNumb(request.getParameter("bankAccount"));
            loanDTO.setAgreementTeam(request.getParameter("term"));
            loanService.create(loanDTO);

            request.getSession().setAttribute("loanDTO", null);
            return new ModelAndView("redirect", "model", new MVCModel("/java2",null));
        } catch (ServiceException e) {
            errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("takeLoan","model",new MVCModel(null,errorResponse));
         }
    }
}
