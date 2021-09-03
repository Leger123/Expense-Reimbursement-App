package services;

import models.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kevin Dian
 */

class UsersServiceImplTest {

    UsersService usersService = Mockito.mock(UsersService.class);
    Users users;


    @BeforeEach
    void setUp(){
        users = new Users();
    }

    @Test
    void login() {
        Users users = new Users(
                1,
                "hothead",
                "lemon555",
                "Kevin",
                "Dian",
                "thedurabletrooper@gmail.com",
                1
        );

        Users expectedResult = users;

        Mockito.when(usersService.login(users)).thenReturn(users);

        Users actualResult = usersService.login(users);

        assertEquals(expectedResult,actualResult);
    }
}