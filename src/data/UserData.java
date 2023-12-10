package data;

import Model.User;
public class UserData {

        public User getUser (String userName, String password){
             final UserDAOImpl userDAO = new UserDAOImpl();
            return userDAO.getUserByUsername(userName, password);
        }
    };



