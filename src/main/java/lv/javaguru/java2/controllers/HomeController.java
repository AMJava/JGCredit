package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.LoanService;
import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ExistingLoanUserException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.domain.MVCModel;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.LoanDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.sql.SQLException;

/**
 * Created by Arturs on 16.08.2016.
 */
@Controller
public class HomeController extends ErrorHandlingController{

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    LoanService loanService;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "home", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("home", "model", null);
    }

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public ModelAndView executeGetRequestIndex(HttpServletRequest request) {
        return new ModelAndView("redirect", "model", new MVCModel("/java2/home",null));
    }

    @RequestMapping(value = "home", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) throws Exception {
        try {
            userService.checkAuthorization();
            loanService.checkExistingLoans();
            LoanDTO loanDTO = new LoanDTO();
            loanDTO.setLoan(Double.parseDouble(request.getParameter("creditSum")));
            loanDTO.setLoanSum(Double.parseDouble(request.getParameter("totalSum")));
            loanDTO.setDuration(Integer.parseInt(request.getParameter("month").substring(0,2)));
            loanDTO.setTerm(request.getParameter("term"));

            if(request.getParameter("term").equals("weekly")){
                loanDTO.setTermPayment(Double.parseDouble(request.getParameter("weeklySum")));
            }else{
                loanDTO.setTermPayment(Double.parseDouble(request.getParameter("monthlySum")));
            }
            request.getSession().setAttribute("loanDTO", loanDTO);
            return new ModelAndView("redirect", "model", new MVCModel("/java2/takeLoan",null));
        } catch (UnAuthorizedUserException e) {
            errorResponse.setMessage(e.getMessage());
            return new ModelAndView("redirect", "model", new MVCModel("/java2/login",null));
        } catch (NullPointerException e) {
            errorResponse.setMessage("NullPointerException, Please Contact Second Line Support");
            return  new ModelAndView("home","model",new MVCModel("",errorResponse));
        } catch (ExistingLoanUserException e) {
            errorResponse.setMessage(e.getMessage());
            System.out.println("IN");
            return  new ModelAndView("home","model",new MVCModel("",errorResponse));
        }
    }
}
