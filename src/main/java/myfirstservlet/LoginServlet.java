package myfirstservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;

@WebServlet(description = "Login Servlet Testing", urlPatterns = { "/LoginServlet" }, initParams = {
		@WebInitParam(name = "user", value = "Sanobar"), @WebInitParam(name = "password", value = "sana123")
		})

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get request parameter for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		// get servlet config init params
		String userID = getServletConfig().getInitParameter(user);
		String password = getServletConfig().getInitParameter("password");
		if (userID.equals(user) && password.equals(pwd)) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.htmml");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either username or password in wrong.</font>");
			rd.include(request, response);
		}

	}

}
