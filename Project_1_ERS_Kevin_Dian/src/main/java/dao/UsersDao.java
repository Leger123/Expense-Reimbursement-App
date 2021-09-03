package dao;

import java.util.*;

import models.Users;

/**
 * @author Kevin Dian
 */

public interface UsersDao {
    Users getUser(String username, String password);
    //List<Users> getAllUsers();
    //Users insertUser(Users users);

}
