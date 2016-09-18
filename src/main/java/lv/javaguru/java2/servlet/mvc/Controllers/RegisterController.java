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
        return new MVCModel("Register Member", "/templates/user/register.jsp","");
    }

    public MVCModel executePostRequest(HttpServletRequest request) {
        Date date = null;
        String BirthDate = request.getParameter("birthDate");
        if(BirthDate != null && BirthDate !="")
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = dateFormat.parse(BirthDate);
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
        null,
        request.getParameter("term")
        );
        System.out.println("UserDTO:"+userDTO.toString());

        List<String> errorMessages = null;
        try {
            errorMessages = userService.create(userDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (errorMessages == null)
        {
            System.out.print("TEST1");
            request.getSession().setAttribute("userErrorDTO", null);
            request.getSession().setAttribute("userDTO", userDTO);
            return new MVCModel(userDTO,"/redirect.jsp", "/java2");
        }else{
            System.out.print("TEST2");
            request.getSession().setAttribute("userErrorDTO", userDTO);
            request.getSession().setAttribute("userErrors", errorMessages);
            return new MVCModel(null,"/templates/user/register.jsp", null);
        }
    }
}
