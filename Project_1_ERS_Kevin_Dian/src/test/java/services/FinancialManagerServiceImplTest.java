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

class FinancialManagerServiceImplTest {

    FinancialManagerService financialManagerService = Mockito.mock(FinancialManagerService.class);
    ReimbursementView reimbursementView;
    Reimbursement reimbursement;

    @BeforeEach
    void setUp(){
        reimbursement = new Reimbursement();
        reimbursementView = new ReimbursementView();
    }

    @Test
    void getAllReimbursementForms() {
        ReimbursementView reimbursementView = new ReimbursementView(
                14,
                7.00,
                null,
                null,
                "Reimbursement for a MacDonald's Meal.",
                null,
                2,
                "John",
                "Doe",
                null,
                null,
                null,
                "Pending",
                "Food"
        );

        //Act
        List<ReimbursementView> actualResult = financialManagerService.getAllReimbursementForms();

        //Assert
        Mockito.verify(financialManagerService, Mockito.times(1)).getAllReimbursementForms();
    }

    @Test
    void filterPastForms() {
        ReimbursementView reimbursementView = new ReimbursementView(
                10,
                50.00,
                null,
                null,
                "Reimbursement for stay at a motel.",
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

        //Act
        List<ReimbursementView> actualResult = financialManagerService.filterPastForms("Approved");

        //Assert
        Mockito.verify(financialManagerService, Mockito.times(1)).filterPastForms("Approved");
    }

    @Test
    void approveOrDenyForm() {
        //Assign
        Integer managerId = 4;
        Integer statusId = 2;
        Integer reimbId = 14;

        //Act
        financialManagerService.approveOrDenyForm(managerId, statusId, reimbId);

        //Assert
        Mockito.verify(financialManagerService, Mockito.times(1)).approveOrDenyForm(managerId, statusId, reimbId);
    }
}