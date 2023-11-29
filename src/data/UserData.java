package data;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static List<User> users;

    public UserData() {
        this.users = new ArrayList<>();
    }

    public void addUser(User newUser) {
    users.add(newUser);
    }

    public User getUser(String userName, String password) {
        for (User user : users) {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static void getUsers() {
        for (User user : users) {
            System.out.println("UserId:" + user.getId());
            System.out.println("Name:" + user.getName());
            System.out.println("Email:" + user.getEmail());
            }
    }

    public static int userId(){
        return users.size();
    }

    @Override
    public String toString() {
        return "users=" + users +
                '}';
    }
}
