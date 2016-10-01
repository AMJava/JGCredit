package lv.javaguru.java2.controllers;

import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.domain.MVCModel;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;

/**
 * Created by Arturs on 16.08.2016.
 */
@Controller
public class HomeController extends ErrorHandlingController{

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "home", method = {RequestMethod.GET})
    public ModelAndView executeGetRequest(HttpServletRequest request) {
        return new ModelAndView("home", "model", null);
    }

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public ModelAndView executeGetRequestIndex(HttpServletRequest request) {
        return new ModelAndView("redirect", "model", new MVCModel("/java2/home",null));
    }

    @RequestMapping(value = "home", method = {RequestMethod.POST})
    public ModelAndView executePostRequest(HttpServletRequest request){
        Float creditSum = Float.parseFloat(request.getParameter("creditSum"));
        Float totalSum = Float.parseFloat(request.getParameter("totalSum"));
        Float monthlySum = Float.parseFloat(request.getParameter("monthlySum"));
        Float weeklySum = Float.parseFloat(request.getParameter("weeklySum"));
        int duration = Integer.parseInt(request.getParameter("month").substring(0,2));
        String term = request.getParameter("term");


           // UserDTO userDTO = convertorDTO.convertUserToDTO(user);
          //  byte[] photoDTO = userDTO.getPhoto();
          //  if (photoDTO != null) {
           //     //FileOutputStream fos = new FileOutputStream("images\\output.jpg");  //windows
          //      FileOutputStream fos = new FileOutputStream("output.jpg");
           //     fos.write(userDTO.getPhoto());
           //     fos.close();
          //  }
           // userService.login(userDTO);
           // request.getSession().setAttribute("userDTO", userDTO);
            return new ModelAndView("redirect", "model", new MVCModel("/java2/loan",null));
    }
}
