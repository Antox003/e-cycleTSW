package ecycle.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		List<String> errors = new ArrayList<>();
		RequestDispatcher dispatcherToLoginPage = request.getRequestDispatcher("common/login.jsp");
		
		if(username == null || username.trim().isEmpty()) {
			errors.add("Il campo non può essere vuoto!");
		}
		if(password == null || password.trim().isEmpty()) {
			errors.add("Il campo non puoò essere vuoto!");
		}
		
		if(!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			dispatcherToLoginPage.forward(request, response);
			return;
		}
		
		username = username.trim();
		password = password.trim();
		
		if(username.equals("admin") && password.equals("mypass")) {
			request.getSession().setAttribute("isAdmin", Boolean.TRUE);
			response.sendRedirect("admin/protected.jsp");
		} else if (username.equals("user") && password.equals("mypass")) {
			request.getSession().setAttribute("isAdmin", Boolean.FALSE);
			response.sendRedirect("common/home.jsp");
		} else {
			errors.add("Username o password non validi!");
			request.setAttribute("errors", errors);
			dispatcherToLoginPage.forward(request, response);
		}
	}
}
