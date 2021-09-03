package services;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import models.ReimbursementView;

import java.util.List;

/**
 * @author Kevin Dian
 */

public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDao employeeDao;

    public EmployeeServiceImpl() {employeeDao = EmployeeDaoImpl.getInstance();}


    @Override
    public List<ReimbursementView> getAllPastTickets(Integer authorId) {
        return employeeDao.getAllPastTickets(authorId);
    }

    @Override
    public List<ReimbursementView> getAllPendingTickets(Integer authorId) {
        return employeeDao.getAllPendingTickets(authorId);
    }

    @Override
    public void createReimbursement(Double reimbAmmount, String reimbDescription, Integer ersUsersFkAuth, Integer ersReimbTypeFk) {
        employeeDao.createReimbursement(reimbAmmount, reimbDescription, ersUsersFkAuth, ersReimbTypeFk);
    }
}


