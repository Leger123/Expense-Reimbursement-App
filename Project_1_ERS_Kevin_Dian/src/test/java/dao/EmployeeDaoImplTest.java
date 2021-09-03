package dao;

import models.ReimbursementView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

/**
 * @author Kevin Dian
 */

class EmployeeDaoImplTest {
    EmployeeDao employeeDao;

    @BeforeEach
    void setUp(){
        employeeDao = Mockito.mock(EmployeeDao.class);
    }

    @Test
    void getAllPastTickets() {
        //Assign
        ReimbursementView reimbursementView = new ReimbursementView(
                2,
                300.0,
                null,
                null,
                "Reimbursement for an extravagant meal.",
                null,
                2,
                "John",
                "Doe",
                3,
                "King",
                "Solomon",
                "Denied",
                "Food"
        );

        //Act
        List<ReimbursementView> actualResult = employeeDao.getAllPastTickets(2);

        //Assert
        Mockito.verify(employeeDao, Mockito.times(1)).getAllPastTickets(2);
    }

    @Test
    void getAllPendingTickets() {
        //Assign
        ReimbursementView reimbursementView = new ReimbursementView(
                19,
                80.00,
                null,
                null,
                "ABC Hotel",
                null,
                1,
                "Kevin",
                "Dian",
                null,
                null,
                null,
                "Pending",
                "Lodging"
        );

        //Act
        List<ReimbursementView> actualResult = employeeDao.getAllPendingTickets(1);

        //Assert
        Mockito.verify(employeeDao, Mockito.times(1)).getAllPendingTickets(1);

    }

    @Test
    void createReimbursement() {
        //Assign
        Double amount = 300.0;
        String description = "For a royal meal";
        Integer authorId = 2;
        Integer typeId = 3;

        //Act
        employeeDao.createReimbursement(amount, description, authorId, typeId);

        //Assert
        Mockito.verify(employeeDao, Mockito.times(1)).createReimbursement(amount,description,authorId,typeId);

    }
}