package services;

import dao.FinancialManagerDao;
import dao.FinancialManagerDaoImpl;
import models.ReimbursementView;

import java.util.List;

/**
 * @author Kevin Dian
 */

public class FinancialManagerServiceImpl implements FinancialManagerService{

    FinancialManagerDao financialManagerDao;

    public FinancialManagerServiceImpl(){financialManagerDao = FinancialManagerDaoImpl.getInstance();}


    @Override
    public List<ReimbursementView> getAllReimbursementForms() {
        return financialManagerDao.getAllReimbursementForms();
    }

    @Override
    public List<ReimbursementView> filterPastForms(String status) {
        return financialManagerDao.filterPastForms(status);
    }

    @Override
    public void approveOrDenyForm(Integer managerId, Integer statusId, Integer reimbId) {
        financialManagerDao.approveOrDenyForm(managerId, statusId, reimbId);
    }
}


