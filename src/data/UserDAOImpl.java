package data;
import Model.Entry;
import Model.User;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class UserDAOImpl implements UserDAO {
    private final Connection connection;
    private Statement statement;

    public UserDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public void insertUser(User user) {
        String insertUserQuery = "INSERT INTO users (name, email, pass) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("User created successfully!");

            // Obtener el ID generado para el nuevo usuario
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(String.valueOf(generatedKeys.getInt(1)));
                    System.out.println(user.toString());
                } else {
                    throw new SQLException("No se pudo obtener el ID generado para el usuario.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en tu aplicación
        }
    }

    @Override
    public  User getUserByUsername(String username, String password) {
        // Consulta parametrizada para verificar la existencia del usuario
        String selectUserQuery = "SELECT * FROM users WHERE name = ? AND pass = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectUserQuery)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Verificar si se encontró algún resultado
                if (resultSet.next()) {
                    // Se encontró un usuario con el nombre de usuario y contraseña proporcionados
                    int userId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String userPassword = resultSet.getString("pass");

                    // Crea un objeto User con los datos obtenidos
                    User user = new User();
                    user.setId(String.valueOf(userId));
                    user.setName(name);
                    user.setPassword(userPassword);

                    // Puedes usar el objeto User según sea necesario
                    return user;
                } else {
                    // No se encontró ningún usuario con el nombre de usuario y contraseña proporcionados
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en tu aplicación
            return null;
        }
    }
/*
    @Override
    public User getUserByUsername(String username) {

        return null;
    }

    @Override
    public void updateUser(User user) {
        // Implementa la lógica para actualizar un usuario
    }

    @Override
    public void deleteUserByUsername(String username) {
        // Implementa la lógica para eliminar un usuario por su nombre de usuario
    }

    @Override
    public List<Entry> getUserEntries(String username) {
        String getUserEntriesQuery = "SELECT e.id, e.description, e.category FROM entries e " +
                "JOIN users u ON e.user_id = u.id " +
                "WHERE u.username = ?";
        List<Entry> entries = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(getUserEntriesQuery)) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Entry entry = new Entry();
                    entry.setId(resultSet.getString("id"));
                    entry.setDescription(resultSet.getString("description"));
                    entry.setCategory(resultSet.getString("category"));
                    entries.add(entry);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en tu aplicación
        }

        return entries;
    } */
}
