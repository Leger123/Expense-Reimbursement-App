package services;

import dao.UsersDao;
import dao.UsersDaoImpl;
import models.Users;

/**
 * @author Kevin Dian
 */

public class UsersServiceImpl implements UsersService{
    UsersDao usersDao;

    public UsersServiceImpl() {usersDao = UsersDaoImpl.getInstance();}


    @Override
    public Users login(Users users) {
        Users tempUsers = usersDao.getUser(users.getErsUsername(), users.getErsPassword());
        if(tempUsers == null) {
            return null;
        }

        return tempUsers;
    }
}

