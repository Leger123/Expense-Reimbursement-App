package services;

import models.ReimbursementView;

import java.util.*;

/**
 * @author Kevin Dian
 */

public interface EmployeeService {

    List<ReimbursementView> getAllPastTickets (Integer authorId);
    List<ReimbursementView> getAllPendingTickets (Integer authorId);
    void createReimbursement(Double reimbAmmount, String reimbDescription, Integer ersUsersFkAuth, Integer ersReimbTypeFk);

}
