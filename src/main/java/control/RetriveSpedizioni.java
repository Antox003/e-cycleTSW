package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SpedizioneBean;
import model.SpedizioneDAODataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/spedizione")
public class RetriveSpedizioni extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SpedizioneDAODataSource spedizioneDAO = new SpedizioneDAODataSource();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAccount = 0;
        try {
            idAccount = Integer.parseInt(request.getParameter("ID_ACCOUNT"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            SpedizioneBean spedizione = spedizioneDAO.doRetrieveByKey(idAccount);
            request.setAttribute("spedizione", spedizione);  // Passa l'oggetto SpedizioneBean alla JSP
        } catch (SQLException e) {
            throw new ServletException("Cannot retrieve spedizione from database", e);
        }

        request.getRequestDispatcher("/spedizione.jsp").forward(request, response);
    }
}

