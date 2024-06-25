package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {
    private static final int MAX_CONNECTIONS = 10; // Numero massimo di connessioni nel pool
    private static List<Connection> freeDbConnections;
    private static List<Connection> usedDbConnections;

    static {
        freeDbConnections = new LinkedList<>();
        usedDbConnections = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("DB driver not found: " + e.getMessage());
        }
    }

    private static synchronized Connection createDBConnection() throws SQLException {
        String ip = "localhost";
        String port = "3306";
        String db = "ecycle";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(
            "jdbc:mysql://" + ip + ":" + port + "/" + db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
            username, password);
    }

    public static synchronized Connection getConnection() throws SQLException {
        Connection connection;

        if (!freeDbConnections.isEmpty()) {
            connection = freeDbConnections.remove(freeDbConnections.size() - 1);
            if (connection.isClosed()) {
                connection = createDBConnection();
            }
            usedDbConnections.add(connection);
        } else if (usedDbConnections.size() < MAX_CONNECTIONS) {
            connection = createDBConnection();
            usedDbConnections.add(connection);
        } else {
            throw new SQLException("Max connections reached");
        }

        return connection;
    }

    public static synchronized void releaseConnection(Connection connection) throws SQLException {
        if (connection != null) {
            usedDbConnections.remove(connection);
            if (!connection.isClosed()) {
                freeDbConnections.add(connection);
            } else {
                connection = createDBConnection();
                freeDbConnections.add(connection);
            }
        }
    }

    public static void shutdown() {
        try {
            for (Connection connection : freeDbConnections) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
            for (Connection connection : usedDbConnections) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
            freeDbConnections.clear();
            usedDbConnections.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
