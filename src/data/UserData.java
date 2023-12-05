package data;

import Model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserData {



        public static void addUser (User newUser){
            //data.UserDAOImpl.insertUser(newUser);

        }


        public User getUser (String userName, String password){
             final UserDAOImpl userDAO = new UserDAOImpl();
            return userDAO.getUserByUsername(userName, password);
        }

/*    public static void getUsers() {
        for (User user : users) {
            System.out.println("UserId:" + user.getId());
            System.out.println("Name:" + user.getName());
            System.out.println("Email:" + user.getEmail());
            System.out.println("---------------------------");
        }
    }

    ;*/

/*    public static int userId() {
        return users.size();
    }*/

    };



