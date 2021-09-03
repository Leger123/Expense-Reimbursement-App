package dao;

import models.ReimbursementView;

import java.util.List;

/**
 * @author Kevin Dian
 */

public interface FinancialManagerDao {
    List<ReimbursementView> getAllReimbursementForms();
    List<ReimbursementView> filterPastForms(String status);
    void approveOrDenyForm (Integer managerId, Integer statusId, Integer reimbId);


}
