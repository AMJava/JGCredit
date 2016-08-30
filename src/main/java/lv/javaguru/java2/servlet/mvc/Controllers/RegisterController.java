package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ConvertorDTO;
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

@Component
public class RegisterController implements MVCController {

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    private UserDAO userDAO;

    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel("Register Member", "/templates/user/register.jsp","");
    }

    public MVCModel executePostRequest(HttpServletRequest request) {
        // User user = userLoginServiceImpl.CheckAuthorization(
        // request.getParameter("user"),
        // request.getParameter("pass"));
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
        User user = new User(
        (long)0,
        request.getParameter("login"),
        request.getParameter("password"),
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
        null
        );
        System.out.print(user.toString());

        try{
            user = userDAO.getByLogin(request.getParameter("user"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new MVCModel("Register Member", "/templates/user/register.jsp","");
    }
}
