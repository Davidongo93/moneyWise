package data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInitializer {
    public static void main(String[] args) {
        createTables();
    }

    private static void createTables() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DbConnect.getConnection();
            statement = connection.createStatement();

            // Verificar si las tablas ya existen
            if (tablesExist(connection, "users") && tablesExist(connection, "entries")) {
                System.out.println("You can breath freely, MoneyWise are full steam workin'.");
            } else {
                // Crear las tablas si no existen
                String createUsersTable = "CREATE TABLE users (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR(255) NOT NULL)";
                statement.executeUpdate(createUsersTable);

                String createEntriesTable = "CREATE TABLE entries (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "user_id INT," +
                        "content VARCHAR(1000) NOT NULL," +
                        "FOREIGN KEY (user_id) REFERENCES users(id))";
                statement.executeUpdate(createEntriesTable);

                System.out.println("Tables created successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnect.closeConnection(connection);
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para verificar si una tabla existe
    private static boolean tablesExist(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metadata = connection.getMetaData();
        try (var resultSet = metadata.getTables(null, null, tableName.toUpperCase(), null)) {
            return resultSet.next();
        }
    }

}

