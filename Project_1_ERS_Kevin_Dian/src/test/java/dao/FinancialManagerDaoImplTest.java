package dao;

import models.ReimbursementView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * @author Kevin Dian
 */

class FinancialManagerDaoImplTest {

    FinancialManagerDao financialManagerDao;

    @BeforeEach
    void setUp(){
        financialManagerDao = Mockito.mock(FinancialManagerDao.class);
    }

    @Test
    void getAllReimbursementForms() {
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
        List<ReimbursementView> actualResult = financialManagerDao.getAllReimbursementForms();

        //Assert
        Mockito.verify(financialManagerDao, Mockito.times(1)).getAllReimbursementForms();
    }

    @Test
    void filterPastForms() {
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
        List<ReimbursementView> actualResult = financialManagerDao.filterPastForms("Denied");

        //Assert
        Mockito.verify(financialManagerDao, Mockito.times(1)).filterPastForms("Denied");
    }

    @Test
    void approveOrDenyForm() {
        //Assign
        Integer managerId = 3;
        Integer statusId = 2;
        Integer reimbId = 19;

        //Act
        financialManagerDao.approveOrDenyForm(managerId, statusId, reimbId);

        //Assert
        Mockito.verify(financialManagerDao, Mockito.times(1)).approveOrDenyForm(managerId, statusId, reimbId);
    }
}