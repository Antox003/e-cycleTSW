package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBean;
import model.ProductDAODataSource;

@WebServlet("/AdminProductList")
public class AdminProductList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAODataSource productDAO = new ProductDAODataSource();

    public AdminProductList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            int idProdotto = Integer.parseInt(request.getParameter("id"));
            try {
                ProductBean prodotto = productDAO.doRetrieveByKey(idProdotto);
                if (prodotto == null) {
                    request.setAttribute("error", "Prodotto non trovato");
                } else {
                    request.getSession().setAttribute("prodotto", prodotto); // Mette il prodotto in sessione
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Errore durante il recupero del prodotto");
            }
        }

        try {
            List<ProductBean> productList = productDAO.doRetrieveAll("Nome");
            request.setAttribute("productList", productList);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Errore durante il recupero dei prodotti");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
