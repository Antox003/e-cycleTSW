package model;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

public class SpedizioneDAODataSource implements IBeanDAO<SpedizioneBean> {

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

    private static final String TABLE_NAME = "SPEDIZIONE";
    private static final String COLUMN_STATO = "Stato";
    private static final String COLUMN_PROVINCIA = "Provincia";
    private static final String COLUMN_CITTA = "Citta";
    private static final String COLUMN_CAP = "Cap";
    private static final String COLUMN_INDIRIZZO = "Indirizzo";
    private static final String COLUMN_CIVICO = "Civico";
    private static final String COLUMN_ACCOUNT = "ID_ACCOUNT";


    

    @Override
    public synchronized void doSave(SpedizioneBean product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_STATO + ", " + COLUMN_PROVINCIA + ", " + COLUMN_CITTA + ", "+ COLUMN_CAP + ", " + COLUMN_INDIRIZZO  +  ", " +  COLUMN_CIVICO + ", " + COLUMN_ACCOUNT + ") VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = ds.getConnection();
            System.out.println("Database connection established for doSave");

            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, product.getStato());
            preparedStatement.setString(2, product.getProvincia());
            preparedStatement.setString(3, product.getCitta());
            preparedStatement.setString(4, product.getCap());
            preparedStatement.setString(5, product.getIndirizzo());
            preparedStatement.setString(6, product.getCivico());
            preparedStatement.setInt(7, product.getAccount());


            


            preparedStatement.executeUpdate();
            System.out.println("Product saved: " + product.getStato());

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
    }

    @Override
    public synchronized boolean doDelete(int code) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ACCOUNT + " = ?";

        try {
            connection = ds.getConnection();
            System.out.println("Database connection established for doDelete");

            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, code);

            result = preparedStatement.executeUpdate();
            System.out.println("Product deleted with ID: " + code);

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
        return (result != 0);
    }

    @Override
    public synchronized List<SpedizioneBean> doRetrieveAll(String order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<SpedizioneBean> spedizione = new ArrayList<>();

        String selectSQL = "SELECT " + COLUMN_STATO + ", " + COLUMN_PROVINCIA + ", " + COLUMN_CITTA + ", "+ COLUMN_CAP + ", " + COLUMN_INDIRIZZO  +  ", " +  COLUMN_CIVICO + ", " + COLUMN_ACCOUNT+ " FROM " + TABLE_NAME;

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                SpedizioneBean bean = new SpedizioneBean();
                bean.setAccount(rs.getInt("ID_ACCOUNT"));
                bean.setStato(rs.getString("Stato"));
                bean.setProvincia(rs.getString("Provincia"));
                bean.setCitta(rs.getString("Citta"));
                bean.setCap(rs.getString("Cap"));
                bean.setIndirizzo(rs.getString("Indirizzo"));
                bean.setCivico(rs.getString("Civico"));
                
				spedizione.add(bean);
				
				
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error retrieving products from database.", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return spedizione;
    }


    @Override
    public SpedizioneBean doRetrieveByKey(int idAccount) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        SpedizioneBean spedizione = null;

        String selectSQL = "SELECT * FROM SPEDIZIONE WHERE ID_ACCOUNT = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, idAccount);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                spedizione = new SpedizioneBean();
                spedizione.setStato(rs.getString("Stato"));
                spedizione.setProvincia(rs.getString("Provincia"));
                spedizione.setCitta(rs.getString("Citta"));
                spedizione.setCap(rs.getString("CAP"));
                spedizione.setIndirizzo(rs.getString("Indirizzo"));
                spedizione.setCivico(rs.getString("Civico"));
                spedizione.setAccount(rs.getInt("ID_ACCOUNT"));
            }

        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return spedizione;
    }
    
    
    
}
