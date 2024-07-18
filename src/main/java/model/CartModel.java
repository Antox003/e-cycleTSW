package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.ProductBean;
import control.DriverManagerConnectionPool;

public class CartModel {
	private static DataSource ds;

    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/ecycle");

            System.out.println("DataSource lookup successful");

        } catch (NamingException e) {
            System.out.println("Error during DataSource lookup: " + e.getMessage());
        }
    }
    public synchronized CartBean updateCarrello(ProductBean bean, CartBean cart) {
        Collection<ProductBean> collection = cart.getCarrello();
        Collection<ProductBean> lista = new LinkedList<ProductBean>();

        if (collection != null && collection.size() != 0) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                ProductBean prodotto = (ProductBean) it.next();
                if (prodotto.getCode() == bean.getCode()) {
                    prodotto.setNome(bean.getNome());
                    prodotto.setDescrizione(bean.getDescrizione());
                    prodotto.setPrezzo(bean.getPrezzo());
                }
                lista.add(prodotto);
            }
            cart.setLista(lista);
        }
        return cart;
    }

    public synchronized CartBean acquista(CartBean cart, UserBean user) throws SQLException {
        Connection con = null;
        Collection<ProductBean> carrello = cart.getCarrello();
        String sql = "INSERT INTO ORDINI (ID_ORDINE, Numero_prodotti, Data_aquisto, ID_ACCOUNT, ID_PRODOTTO, ID_INDIRIZZO) VALUES (?, ?, current_date(), ?, ?, ?)";

        try {
            con = DriverManagerConnectionPool.getConnection();

            if (carrello != null && carrello.size() != 0) {
                for (Iterator<ProductBean> i = cart.getCarrello().iterator(); i.hasNext();) {
                    ProductBean bean = (ProductBean) i.next();
                    Double prezzoTot = bean.getPrezzo() * bean.getQuantity();

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, bean.getCode());
                    ps.setString(2, user.getEmail());
                    ps.setDouble(3, prezzoTot);
                    ps.setInt(4, bean.getQuantity());

                    ps.executeUpdate();
                }
                con.commit();
                cart.removeAllItems();
            }
            return cart;
        } catch (Exception e) {
            throw new SQLException("Errore nell'acquisto del carrello", e);
        } finally {
            if (con != null) {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public synchronized CartBean aggiungiAlCarrello(CartBean carrello, int codiceProdotto) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;        
        ProductBean bean = new ProductBean();

        String selectSQL = "SELECT * FROM PRODOTTO WHERE ID_PRODOTTO = ?";

        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, codiceProdotto);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                bean.setCode(rs.getInt("ID_PRODOTTO"));
                bean.setNome(rs.getString("nome"));
                bean.setDescrizione(rs.getString("descrizione"));
                bean.setPrezzo(rs.getDouble("prezzo"));
                bean.setQuantity(1);  // Imposta la quantità iniziale a 1
            }

            carrello.addItem(bean);  // Aggiunge il prodotto al carrello
            return carrello;
        } catch (Exception e) {
            throw new SQLException("Errore nell'aggiunta del prodotto al carrello", e);
        } finally {
            if (connection != null) {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }
    }

	public CartBean doOrder(CartBean carrello, UserBean user) throws SQLException {
		        Connection conn = null;
		        PreparedStatement stmt = null;
		        OrdiniBean ordini = new OrdiniBean();
		        ProductBean bean = new ProductBean();
		        try {
					conn = ds.getConnection(); // Ottieni la connessione al database

		            // Esempio di operazione: inserisci i dettagli dell'ordine nella tabella degli ordini
		            String insertOrderQuery = "INSERT INTO ORDINI (Numero_Prodotti, Data_acquisto, ID_ACCOUNT, Nome_prodotto) VALUES (?, ?, ?, ?)";
		            stmt = conn.prepareStatement(insertOrderQuery);
		            stmt.setString(1, ordini.getNumeroprodotti());
		            stmt.setDate(2, new java.sql.Date(System.currentTimeMillis())); 
		            stmt.setInt(3, user.getCode());
		            stmt.setString(4, bean.getNome());
		            stmt.executeUpdate();


		            // Ritorna il carrello aggiornato dopo l'ordine
		            return carrello;

		        } catch (SQLException e) {
		            // Gestisci eventuali eccezioni SQL
		            if (conn != null) {
		            }
		            throw e; // Rilancia l'eccezione per essere gestita dal chiamante
		        } finally {
		            // Chiudi le risorse PreparedStatement e Connection
		            if (stmt != null) {
		                stmt.close();
		            }
		            if (conn != null) {
		               
		                conn.close();
		            }
		        }
		    }
		
	}

