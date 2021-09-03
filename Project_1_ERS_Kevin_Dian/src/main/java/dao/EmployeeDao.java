package dao;

import java.util.*;

import models.ReimbursementView;

/**
 * @author Kevin Dian
 */

public interface EmployeeDao {
    List<ReimbursementView> getAllPastTickets (Integer authorId);
    List<ReimbursementView> getAllPendingTickets (Integer authorId);
    void createReimbursement(Double reimbAmmount, String reimbDescription, Integer ersUsersFkAuth, Integer ersReimbTypeFk);


}
