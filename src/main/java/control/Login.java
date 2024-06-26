package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DriverManagerConnectionPool;
import model.OrderModel;
import model.UserBean;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
        String redirectedPage = "/login.jsp"; // Pagina predefinita in caso di fallimento del login
        
        Connection con = null;
        boolean loginError = true; // Flag per gestire errori di login

        try {
            con = DriverManagerConnectionPool.getConnection();
            String sql = "SELECT * FROM UserAccount WHERE email = ? AND passwordUser = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Login riuscito
                UserBean registeredUser = new UserBean();
                registeredUser.setEmail(rs.getString("email"));
                registeredUser.setNome(rs.getString("nome"));
                registeredUser.setCognome(rs.getString("cognome"));
                registeredUser.setIndirizzo(rs.getString("indirizzo"));
                registeredUser.setTelefono(rs.getString("telefono"));
                registeredUser.setRole(rs.getString("ruolo"));

                HttpSession session = request.getSession();
                session.setAttribute("registeredUser", registeredUser);
                session.setAttribute("role", registeredUser.getRole());
                session.setAttribute("email", rs.getString("email"));
                session.setAttribute("nome", rs.getString("nome"));

                OrderModel model = new OrderModel();
                session.setAttribute("listaOrdini", model.getOrders(rs.getString("email")));

                redirectedPage = "/home.jsp"; // Reindirizza alla pagina home in caso di login riuscito
                
                loginError = false; // Resetta il flag di errore di login
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione SQL in modo appropriato
            throw new ServletException("Errore durante l'accesso al database", e); // Lancio dell'eccezione ServletException per gestire l'errore 500
        } finally {
            if (con != null) {
                try {
                    DriverManagerConnectionPool.releaseConnection(con);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Gestione del login fallito
        if (loginError) {
            request.setAttribute("loginError", true);
        }

        // Reindirizza alla pagina appropriata
        request.getRequestDispatcher(redirectedPage).forward(request, response);
    }
}
