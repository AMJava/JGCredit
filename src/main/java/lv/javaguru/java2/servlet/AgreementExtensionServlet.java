package lv.javaguru.java2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.CustomerDAOImpl;
import lv.javaguru.java2.domain.Customer;

public class AgreementExtensionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        // Set response content type
        resp.setContentType("text/html");

        // Prepare output html
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");
        String padding = "padding: 10px;", border = "border:1px solid green;";
        out.println("<div style=\" + border + padding + \">Java 2</div>");

    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        String json = req.getParameter("data");
        Gson gson = new Gson();
        Customer customer = gson.fromJson(json,Customer.class);
        CustomerDAOImpl impl = new CustomerDAOImpl();
        try {
            impl.create(customer);
        } catch (DBException e) {
            System.out.println("Exception creating Customer");
            e.printStackTrace();
        }
    }

}
