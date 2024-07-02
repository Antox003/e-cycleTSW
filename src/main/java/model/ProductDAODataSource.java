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

public class ProductDAODataSource implements IBeanDAO<ProductBean> {

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

    private static final String TABLE_NAME = "PRODOTTO";
    private static final String COLUMN_ID_PRODOTTO = "ID_PRODOTTO";
    private static final String COLUMN_NOME = "Nome";
    private static final String COLUMN_DESCRIZIONE = "Descrizione";
    private static final String COLUMN_PREZZO = "Prezzo";

    @Override
    public synchronized void doSave(ProductBean product) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_NOME + ", " + COLUMN_DESCRIZIONE + ", " + COLUMN_PREZZO + ") VALUES (?, ?, ?)";

        try {
            connection = ds.getConnection();
            System.out.println("Database connection established for doSave");

            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, product.getNome());
            preparedStatement.setString(2, product.getDescrizione());
            preparedStatement.setDouble(3, product.getPrezzo());

            preparedStatement.executeUpdate();
            System.out.println("Product saved: " + product.getNome());

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

        String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_PRODOTTO + " = ?";

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
    public synchronized List<ProductBean> doRetrieveAll(String order) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<ProductBean> products = new ArrayList<>();

        String selectSQL = "SELECT " + COLUMN_ID_PRODOTTO + ", " + COLUMN_NOME + ", " + COLUMN_DESCRIZIONE + ", " + COLUMN_PREZZO + " FROM " + TABLE_NAME;


        if (order != null && !order.isEmpty()) {
            selectSQL += " ORDER BY " + order;
        }

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ProductBean bean = new ProductBean();
                bean.setCode(rs.getInt("ID_PRODOTTO"));
                bean.setNome(rs.getString("Nome"));
                bean.setDescrizione(rs.getString("Descrizione"));
                bean.setPrezzo(rs.getDouble("Prezzo"));

                products.add(bean);
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
        return products;
    }


    @Override
    public synchronized ProductBean doRetrieveByKey(int code) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ProductBean bean = new ProductBean();
        String selectSQL = "SELECT " + COLUMN_ID_PRODOTTO + ", " + COLUMN_NOME + ", " + COLUMN_DESCRIZIONE + ", " + COLUMN_PREZZO + " FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_PRODOTTO + " = ?";
        try {
            connection = ds.getConnection();
            System.out.println("Database connection established for doRetrieveByKey");

            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, code);
            System.out.println("Executing query: " + selectSQL);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                bean.setCode(rs.getInt(COLUMN_ID_PRODOTTO));
                bean.setNome(rs.getString(COLUMN_NOME));
                bean.setDescrizione(rs.getString(COLUMN_DESCRIZIONE));
                bean.setPrezzo(rs.getDouble(COLUMN_PREZZO));

                System.out.println("Retrieved product by key: " + bean.getNome() + ", " + bean.getDescrizione() + ", " + bean.getPrezzo());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error executing query: " + selectSQL, e);
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
        return bean;
    }
}
