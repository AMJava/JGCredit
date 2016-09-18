package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.servlet.mvc.Controllers.*;
import lv.javaguru.java2.servlet.mvc.Controllers.Admin.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MVCFilter implements Filter {

    private static final Logger logger = Logger.getLogger(MVCFilter.class.getName());
    private Map<String, MVCController> controllers;
    private ApplicationContext springContext;
    private MVCController getBean(Class clazz){
        return (MVCController) springContext.getBean(clazz);
    }

//, sozdtj luboj class, naprimer SpringConfig
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            springContext =
            new AnnotationConfigApplicationContext(SpringConfig.class);
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }
        controllers = new HashMap<String, MVCController>();
        controllers.put("/home", getBean(HomeController.class));
        controllers.put("/operations", getBean(OperationController.class));
        controllers.put("/about", getBean(AboutController.class));
        controllers.put("/contacts", getBean(ContactsController.class));

        controllers.put("/login", getBean(LoginController.class));
        controllers.put("/logout", getBean(LogoutController.class));
        controllers.put("/register", getBean(RegisterController.class));
        controllers.put("/restorePassword", getBean(RestorePassController.class));
        controllers.put("/error", getBean(ErrorController.class));

        controllers.put("/profile", getBean(ProfileController.class));
        controllers.put("/loans", getBean(LoanController.class));
        controllers.put("/loans/extend", getBean(LoanExtController.class));

        controllers.put("/admin/login", getBean(AdminLoginController.class));
        controllers.put("/admin/home", getBean(AdminHomeController.class));
        controllers.put("/admin/loans", getBean(AdminLoansController.class));
        controllers.put("/admin/loansExt", getBean(AdminLoansExtController.class));
        controllers.put("/admin/users", getBean(AdminContactsController.class));
        controllers.put("/admin/employees", getBean(AdminEmployeesController.class));
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();
        MVCModel model = null;
        MVCController controller = controllers.get(contextURI);
        if (controller != null)  {
            if (req.getMethod().equals("POST")) {
                try {
                    model = controller.executePostRequest(req);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ServiceException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    model = controller.executeGetRequest(req);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                req.setAttribute("model", model.getData());
                req.setAttribute("message", model.getMessage());
                req.setAttribute("error", model.getError());
            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispacher =
            context.getRequestDispatcher(model.getViewName());
            requestDispacher.forward(req, resp);
        }
        else {
            filterChain.doFilter(request,response);
        }
    }

    public void destroy() {

    }

}
