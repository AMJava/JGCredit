package lv.javaguru.java2.servlet.mvc.Controllers;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Component
public class LoginController implements MVCController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    ConvertorDTO convertorDTO;

    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel("Login", "/templates/user/login.jsp","AAA");
    }

    public MVCModel executePostRequest(HttpServletRequest request) {
        User user = null;
        try{
            user = userDAO.getByLogin(request.getParameter("user"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        if (user != null && user.getPassword().equals(request.getParameter("pass"))) {
            UserDTO userDTO = convertorDTO.convertUserToDTO(user);
            request.getSession().setAttribute("userDTO", userDTO);
            return new MVCModel(userDTO,"/templates/user/home.jsp", "Authorization successful: " + userDTO.getFName()+" "+userDTO.getLName());
        }
        else {
            return  new MVCModel(null, "/templates/user/login.jsp", "Wrong login or password!");
        }
    }
}
