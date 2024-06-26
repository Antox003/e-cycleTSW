package control;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import control.DriverManagerConnectionPool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {

    public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		
    			String email = request.getParameter("email");
    			String password = request.getParameter("password");
    			String redirectedPage = "/login.jsp";
    			List<String> errors = new ArrayList<>();
            	RequestDispatcher dispatcherToLoginPage = request.getRequestDispatcher("login.jsp");
        		Boolean control = false;

    			if(email == null || email.trim().isEmpty()) {
    				errors.add("Il campo username non può essere vuoto!");
    			}
                if(password == null || password.trim().isEmpty()) {
                	errors.add("Il campo password non può essere vuoto!");
    			}
                if (!errors.isEmpty()) {
                	request.setAttribute("errors", errors);
                	dispatcherToLoginPage.forward(request, response);
                	return; // note the return statement here!!!
                }
                
                email = email.trim();
                password = password.trim();
                
                try {
                	Connection con = DriverManagerConnectionPool.getConnection();
        			String sql = "SELECT Nome, Cognome, Data_nascita, Email, password, Telefono, ruolo FROM UserAccount";
        			
        			Statement s = con.createStatement();
        			ResultSet rs = s.executeQuery(sql);
        			
        			while (rs.next()) {
        				if (email.compareTo(rs.getString(4)) == 0) {
        					String psw = checkPsw(password);
        					if (psw.compareTo(rs.getString(5)) == 0) {
        						control = true;
        						UserBean registeredUser = new UserBean();
        						registeredUser.setNome(rs.getString(1));
        						registeredUser.setCognome(rs.getString(2));
        						registeredUser.setData_nascita(rs.getString(3));
        						registeredUser.setEmail(rs.getString(4));
        						registeredUser.setTelefono(rs.getString(6));
        						registeredUser.setRole(rs.getString(7));
        						request.getSession().setAttribute("registeredUser", registeredUser);
        						request.getSession().setAttribute("role", registeredUser.getRole());
        						request.getSession().setAttribute("email", rs.getString(4));
        						request.getSession().setAttribute("nome", rs.getString(1));
        						
        					/*	OrderModel model = new OrderModel();
        						request.getSession().setAttribute("listaOrdini", model.getOrders(rs.getString(1))); */
        						
        						redirectedPage = "/home.jsp";
        						DriverManagerConnectionPool.releaseConnection(con);
        					}
        				}
        			}
        		}
                
                
                catch (Exception e) {
        			redirectedPage = "/login.jsp";
        		}
        		if (control == false) {
        			request.getSession().setAttribute("login-error", true);
        		}
        		else {
        			request.getSession().setAttribute("login-error", false);
        		}
        		response.sendRedirect(request.getContextPath() + redirectedPage);
        	}
        		
        	private String checkPsw(String psw) {
        		MessageDigest md = null;
        		try {
        			md = MessageDigest.getInstance("MD5");
        		}
        		catch (Exception e) {
        			e.printStackTrace();
        		}
        		byte[] messageDigest = md.digest(psw.getBytes());
        		BigInteger number = new BigInteger(1, messageDigest);
        		String hashtext = number.toString(16);
        		
        		return hashtext;
        	}
    			
                
                /*
    			if(username.equals("admin") && password.equals("mypass")){ //admin
    				request.getSession().setAttribute("isAdmin", Boolean.TRUE); //inserisco il token nella sessione
    				response.sendRedirect("protected.jsp");
    			} else if (username.equals("user") && password.equals("mypass")){ //user
    				request.getSession().setAttribute("isAdmin", Boolean.FALSE); //inserisco il token nella sessione
    				response.sendRedirect("home.jsp");
    			} else {
    				errors.add("Username o password non validi!");
    				request.setAttribute("errors", errors);
    				dispatcherToLoginPage.forward(request, response);
    			}
    			*/
    	
}
