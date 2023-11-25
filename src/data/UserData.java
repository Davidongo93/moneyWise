package data;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private List<User> users;

    public UserData() {
        this.users = new ArrayList<>();
    }

    public void addUser(User newUser) {
    users.add(newUser);
    }

    public User getUser(String userName, String password) {
        for (User user : users) {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                return user;  // Retorna el usuario si se encuentra una coincidencia
            }
        }
        return null;  // Retorna null si no se encuentra ninguna coincidencia
    }
    @Override
    public String toString() {
        return "UserData{" +
                "users=" + users +
                '}';
    }
// Métodos para almacenar y recuperar datos de usuarios
}
