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
import java.io.FileOutputStream;
import java.sql.SQLException;

@Component
public class LoginController implements MVCController {

//    @Autowired
//    UserLoginServiceImpl userLoginServiceImpl;

    @Autowired
    ConvertorDTO convertorDTO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public MVCModel executeGetRequest(HttpServletRequest request) {
        return new MVCModel("", "/templates/user/login.jsp","");
    }

    @Override
    public MVCModel executePostRequest(HttpServletRequest request) {

       // User user = userLoginServiceImpl.CheckAuthorization(
       // request.getParameter("user"),
       // request.getParameter("pass"));

        User user = null;
        try{
            user = userDAO.getByLogin(request.getParameter("user"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        if (user != null && user.getPassword().equals(request.getParameter("pass"))) {
            UserDTO userDTO = convertorDTO.convertUserToDTO(user);
            byte[] photoDTO = userDTO.getPhoto();
            if (photoDTO != null)
            try{
                //FileOutputStream fos = new FileOutputStream("images\\output.jpg");  //windows
                FileOutputStream fos = new FileOutputStream("output.jpg");
                fos.write(userDTO.getPhoto());
                fos.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            request.getSession().setAttribute("userDTO", userDTO);
            return new MVCModel(userDTO,"/index.jsp", "Authorization successful: " + userDTO.getFName()+" "+userDTO.getLName());
        }
        else {
            return  new MVCModel(null, "/templates/user/login.jsp", "Wrong login or password!");
        }
    }
}
