package services;

import models.Reimbursement;
import models.ReimbursementView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * @author Kevin Dian
 */

class EmployeeServiceImplTest {

    EmployeeService employeeService = Mockito.mock(EmployeeService.class);
    ReimbursementView reimbursementView;
    Reimbursement reimbursement;


    @BeforeEach
    void setUp(){
       reimbursement = new Reimbursement();
       reimbursementView = new ReimbursementView();
    }

    @Test
    void getAllPastTickets() {
        ReimbursementView reimbursementView = new ReimbursementView(
                1,
                100.0,
                null,
                null,
                "Reimbursement for Steak n Shake meal.",
                null,
                1,
                "Kevin",
                "Dian",
                3,
                "King",
                "Solomon",
                "Approved",
                "Lodging"
        );

        List<ReimbursementView> actualResult = employeeService.getAllPastTickets(1);

        Mockito.verify(employeeService, Mockito.times(1)).getAllPastTickets(1);

    }

    @Test
    void getAllPendingTickets() {
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

        List<ReimbursementView> actualResult = employeeService.getAllPendingTickets(1);

        Mockito.verify(employeeService, Mockito.times(1)).getAllPendingTickets(1);

    }

    @Test
    void createReimbursement() {

        //Assign
        Double amount = 300.0;
        String description = "For a royal meal";
        Integer authorId = 2;
        Integer typeId = 3;

        //Act
        employeeService.createReimbursement(amount, description, authorId, typeId);

        //Assert
        Mockito.verify(employeeService, Mockito.times(1)).createReimbursement(amount,description,authorId,typeId);

    }
}