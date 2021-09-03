package services;

import models.ReimbursementView;

import java.util.*;

/**
 * @author Kevin Dian
 */

public interface FinancialManagerService {

    List<ReimbursementView> getAllReimbursementForms();
    List<ReimbursementView> filterPastForms(String status);
    void approveOrDenyForm (Integer managerId, Integer statusId, Integer reimbId);


}
