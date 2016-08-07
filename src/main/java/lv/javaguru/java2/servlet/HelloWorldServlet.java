package lv.javaguru.java2.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
	                     HttpServletResponse resp) throws ServletException, IOException {

		// Set response content type
		resp.setContentType("text/html");

		// Prepare output html
//		PrintWriter out = resp.getWriter();
//		out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");
//		out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");
//		String padding= "padding: 10px;", border= "border:1px solid green;";
//		out.println("<div style=\" + border + padding + \">Java 2</div>");

//		request.setAttribute("sorts", ie.getBrands(taste));
//		request.setAttribute("info", getServletInfo());
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req, resp);
	}

}
