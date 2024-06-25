package control;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String redirectedPage = "/login.jsp"; // Pagina predefinita in caso di fallimento del login
        boolean control = false;
        Connection con = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            String sql = "SELECT * FROM UserAccount WHERE email = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("passwordUser");

                if (checkPassword(password, storedPassword)) {
                    control = true;
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
                } else {
                    // Password non corretta
                    request.getSession().setAttribute("login-error", true);
                }
            } else {
                // Utente non trovato
                request.getSession().setAttribute("login-error", true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione SQL in modo appropriato
            request.getSession().setAttribute("login-error", true); // Imposta l'errore di login
        } finally {
            if (con != null) {
                try {
                    DriverManagerConnectionPool.releaseConnection(con);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        response.sendRedirect(request.getContextPath() + redirectedPage);
    }

	private boolean checkPassword(String password, String storedPassword) {
		// TODO Auto-generated method stub
		return false;
	}
}
