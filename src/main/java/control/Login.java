package control;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.DriverManagerConnectionPool;
import model.OrderModel;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			List<String> errors = new ArrayList<>();
        	RequestDispatcher dispatcherToLoginPage = request.getRequestDispatcher("login.jsp");

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
			
    		String redirectedPage = "/loginPage.jsp";
    		Boolean control = false;
    		try {
    			Connection con = DriverManagerConnectionPool.getConnection();
    			String sql = "SELECT email, passwordUser, ruolo, nome, cognome, indirizzo, telefono, numero, intestatario, CVV FROM UserAccount";
    			
    			Statement s = con.createStatement();
    			ResultSet rs = s.executeQuery(sql);
    			
    			while (rs.next()) {
    				if (email.compareTo(rs.getString(1)) == 0) {
    					String psw = checkPsw(password);
    					if (psw.compareTo(rs.getString(2)) == 0) {
    						control = true;
    						User registeredUser = new User();
    						registeredUser.setEmail(rs.getString(1));
    						registeredUser.setNome(rs.getString(4));
    						registeredUser.setCognome(rs.getString(5));
    						registeredUser.setIndirizzo(rs.getString(6));
    						registeredUser.setTelefono(rs.getString(7));
    						registeredUser.setNumero(rs.getString(8));
    						registeredUser.setIntestatario(rs.getString(9));
    						registeredUser.setCvv(rs.getString(10));
    						registeredUser.setRole(rs.getString(3));
    						request.getSession().setAttribute("registeredUser", registeredUser);
    						request.getSession().setAttribute("role", registeredUser.getRole());
    						request.getSession().setAttribute("email", rs.getString(1));
    						request.getSession().setAttribute("nome", rs.getString(6));
    						
    						OrderModel model = new OrderModel();
    						request.getSession().setAttribute("listaOrdini", model.getOrders(rs.getString(1)));
    						
    						redirectedPage = "/index.jsp";
    						DriverManagerConnectionPool.releaseConnection(con);
    					}
    				}
    			}
    		}
    		catch (Exception e) {
    			redirectedPage = "/loginPage.jsp";
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

	}
	
	private static final long serialVersionUID = 1L;


}
