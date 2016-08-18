package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.servlet.mvc.Controllers.*;
import lv.javaguru.java2.servlet.mvc.Controllers.Admin.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MVCFilter implements Filter {

    private Map<String, MVCController> controllers;


    public void init(FilterConfig filterConfig) throws ServletException {
        controllers = new HashMap<String, MVCController>();
        controllers.put("/loan", new LoanController());
        controllers.put("/loan/extend", new LoanExtController());
        controllers.put("/home", new HomeController());
        controllers.put("/about", new AboutController());
        controllers.put("/register", new RegisterController());
        controllers.put("/contacts", new ContactsController());
        controllers.put("/login", new LoginController());
        controllers.put("/admin/login", new AdminLoginController());
        controllers.put("/admin/home", new AdminHomeController());
        controllers.put("/admin/loans", new AdminLoansController());
        controllers.put("/admin/loansExt", new AdminLoansExtController());
        controllers.put("/admin/users", new AdminContactsController());
        controllers.put("/admin/employees", new AdminEmployeesController());
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();
        MVCController controller = controllers.get(contextURI);
        if (controller != null) {
            MVCModel model = controller.execute(req);

            req.setAttribute("model", model.getData());

            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispacher =
                    context.getRequestDispatcher(model.getViewName());
            requestDispacher.forward(req, resp);
        }
        else filterChain.doFilter(request,response);
    }

    public void destroy() {

    }

}
