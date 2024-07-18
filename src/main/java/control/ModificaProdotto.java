package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBean;
import model.ProductDAODataSource;

@WebServlet("/ModificaProdotto")
public class ModificaProdotto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));

    	ProductDAODataSource productDAO = new ProductDAODataSource();
    	ProductBean prodotto = null;
    	try {
    	    prodotto = productDAO.doRetrieveByKey(idProdotto);
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	    request.setAttribute("error", "Errore durante il recupero del prodotto.");
    	    request.getRequestDispatcher("/home").forward(request, response);
    	    return;
    	}

    	request.setAttribute("prodotto", prodotto);
    	request.getRequestDispatcher("/admin.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idProdottoParam = request.getParameter("ID_PRODOTTO");

            // Controlla se idProdottoParam è null o vuoto
            if (idProdottoParam == null || idProdottoParam.isEmpty()) {
                throw new NumberFormatException("ID prodotto non valido.");
            }

            int idProdotto = Integer.parseInt(idProdottoParam);
            String nome = request.getParameter("nome");
            String descrizione = request.getParameter("descrizione");
            double prezzo = Double.parseDouble(request.getParameter("prezzo"));
            String casa = request.getParameter("casa");
            String display = request.getParameter("display");
            String fotocamera = request.getParameter("fotocamera");
            String archiviazione = request.getParameter("archiviazione");
            String autenticazione = request.getParameter("autenticazione");
            String chip = request.getParameter("chip");
            String sim = request.getParameter("sim");
            String bluetooth = request.getParameter("bluetooth");
            String connettori = request.getParameter("connettori");
            String rete = request.getParameter("rete");
            String batteria = request.getParameter("batteria");
            String dimPes = request.getParameter("dimPes");
            String so = request.getParameter("so");
            String acqua = request.getParameter("acqua");

            ProductBean prodotto = new ProductBean();
            prodotto.setCode(idProdotto);
            prodotto.setNome(nome);
            prodotto.setDescrizione(descrizione);
            prodotto.setPrezzo(prezzo);
            prodotto.setCasa(casa);
            prodotto.setDisplay(display);
            prodotto.setFotocamera(fotocamera);
            prodotto.setArchiviazione(archiviazione);
            prodotto.setAutenticazione(autenticazione);
            prodotto.setChip(chip);
            prodotto.setSIM(sim);
            prodotto.setBluetooth(bluetooth);
            prodotto.setConnettori(connettori);
            prodotto.setRete(rete);
            prodotto.setBatteria(batteria);
            prodotto.setDimPes(dimPes);
            prodotto.setSO(so);
            prodotto.setAcqua(acqua);

            ProductDAODataSource productDAO = new ProductDAODataSource();
            int editResult = productDAO.doEdit(prodotto);

            if (editResult > 0) {
                response.sendRedirect(request.getContextPath() + "/ProductDetail?idProdotto=" + idProdotto);
            } else {
                request.setAttribute("error", "Errore durante l'aggiornamento del prodotto.");
                request.getRequestDispatcher("/admin.jsp").forward(request, response);
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Errore durante l'aggiornamento del prodotto.");
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
    }
}
