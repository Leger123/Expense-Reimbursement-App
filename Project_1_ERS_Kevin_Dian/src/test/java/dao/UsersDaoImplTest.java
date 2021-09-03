package dao;

import models.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kevin Dian
 */

class UsersDaoImplTest {

    UsersDao usersDao;

    @BeforeEach
    void setUp(){
        usersDao = UsersDaoImpl.getInstance();
    }

    @Test
    void getUser() {
        //Assign
        Users users = new Users();
        users.setErsUsername("hothead");
        users.setErsPassword("lemon555");

        Users expecetedResult = users;

        //Act
        Users actualResult = usersDao.getUser("hothead","lemon555");

        //Assert
        assertEquals(expecetedResult.getErsUsername(), actualResult.getErsUsername());
    }
}