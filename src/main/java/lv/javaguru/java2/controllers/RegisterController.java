package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.ErrorResponse;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterController{

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    UserService userService;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "register", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("register", "model", null);
    }

    @RequestMapping(value = "register", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request) {
        Date date = null;
        UserDTO userDTO = null;
        try {
            String BirthDate = request.getParameter("birthDate");
            if (BirthDate != null && BirthDate != "") {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date = dateFormat.parse(BirthDate);
                System.out.print(date.toString());
            }
            userDTO = new UserDTO(
            (long) 0, request.getParameter("login"), request.getParameter("password"),
            request.getParameter("password2"), request.getParameter("email"),
            request.getParameter("fName"), request.getParameter("lName"),
            request.getParameter("gender"), request.getParameter("personalNumber"),
            date, request.getParameter("address"), request.getParameter("phoneNumber"),
            request.getParameter("companyName"), request.getParameter("jobTitle"),
            request.getParameter("salary"), request.getParameter("question"),
            request.getParameter("answer"), null, request.getParameter("term")
            );

            userDTO = userService.create(userDTO);
            userService.login(userDTO);
            request.getSession().setAttribute("userErrorDTO", null);
            request.getSession().setAttribute("userDTO", userDTO);
            return new ModelAndView("redirect", "model", new MVCModel("/java2",null));
        } catch (ServiceException e) {
            errorResponse.setMessage(e.getMessage());
            System.out.print(errorResponse.getMessage());
            request.getSession().setAttribute("userErrorDTO", userDTO);
            return  new ModelAndView("register","model",new MVCModel(null,errorResponse));
        } catch (Exception e) {
            errorResponse.setMessage(e.getMessage());
            return  new ModelAndView("error","model",new MVCModel(null,errorResponse));
        }
    }
}
