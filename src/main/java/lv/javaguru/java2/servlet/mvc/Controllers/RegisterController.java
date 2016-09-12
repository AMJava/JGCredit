package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class RegisterController implements MVCController {

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    UserService userService;

    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel("Register Member", "/templates/user/register.jsp","",null);
    }

    public MVCModel executePostRequest(HttpServletRequest request) {
        Date date = null;
        if(request.getParameter("birthDate") != null && request.getParameter("birthDate")!="")
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = dateFormat.parse(request.getParameter("birthDate"));
                System.out.print(date.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        UserDTO userDTO = new UserDTO(
        (long)0,
        request.getParameter("login"),
        request.getParameter("password"),
        request.getParameter("password2"),
        request.getParameter("email"),
        request.getParameter("fName"),
        request.getParameter("lName"),
        request.getParameter("gender"),
        request.getParameter("personalNumber"),
        date,
        request.getParameter("address"),
        request.getParameter("phoneNumber"),
        request.getParameter("companyName"),
        request.getParameter("jobTitle"),
        request.getParameter("salary"),
        request.getParameter("question"),
        request.getParameter("answer"),
        null
        );
        System.out.println("UserDTO:"+userDTO.toString());

        List<String> errorMessages = null;
        try {
            errorMessages = userService.create(userDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (errorMessages != null)
        {
            request.getSession().setAttribute("userDTO", userDTO);
            return new MVCModel(userDTO,"/redirect.jsp", "/java2",null);
        }else{
            return new MVCModel(userDTO,"/templates/user/register.jsp", null,errorMessages);
        }
    }
}
