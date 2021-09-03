package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Response;
import models.Reimbursement;
import models.ReimbursementView;
import services.FinancialManagerService;
import services.FinancialManagerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.*;

/**
 * @author Kevin Dian
 */

public class FinancialManagerController {

    private static FinancialManagerController financialManagerController;
    FinancialManagerService financialManagerService;

    private FinancialManagerController() {financialManagerService = new FinancialManagerServiceImpl();}

    public static FinancialManagerController getInstance(){
        if(financialManagerController == null){
            financialManagerController = new FinancialManagerController();
        }

        return financialManagerController;
    }

    public void getAllReimbursementForms(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        List<ReimbursementView> allTickets;

        allTickets = financialManagerService.getAllReimbursementForms();

        out.println(new ObjectMapper().writeValueAsString(new Response("all tickets received",true, allTickets)));

    }

    public void filterPastForms(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        ReimbursementView reimbursementView = new ObjectMapper().readValue(requestBody,ReimbursementView.class);

        financialManagerService.filterPastForms(reimbursementView.getReimbStatus());

        out.println(new ObjectMapper().writeValueAsString(new Response(reimbursementView.getReimbStatus() + " tickets received",true, financialManagerService.filterPastForms(reimbursementView.getReimbStatus()))));
    }

    public void approveOrDenyForm (HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Reimbursement reimbursement = new ObjectMapper().readValue(requestBody,Reimbursement.class);

        financialManagerService.approveOrDenyForm(reimbursement.getErsUsersFkReslvr(),reimbursement.getErsReimbursementStatusFk(),reimbursement.getReimbId());

        out.println(new ObjectMapper().writeValueAsString(new Response( "reimb id " + reimbursement.getReimbId() + " now has its status id number as " + reimbursement.getErsReimbursementStatusFk(),true, null)));
    }

}


