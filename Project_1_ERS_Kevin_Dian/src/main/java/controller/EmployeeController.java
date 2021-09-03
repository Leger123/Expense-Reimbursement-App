package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Response;
import models.Reimbursement;
import services.EmployeeService;
import services.EmployeeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

/**
 * @author Kevin Dian
 */

public class EmployeeController {
    private static EmployeeController employeeController;
    EmployeeService employeeService;
    private EmployeeController() {employeeService = new EmployeeServiceImpl();}

    public static EmployeeController getInstance(){
        if(employeeController == null){
            employeeController = new EmployeeController();
        }

        return employeeController;
    }

    public void getAllPastTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Integer authorId = Integer.parseInt(req.getParameter("authorId"));

        out.println(new ObjectMapper().writeValueAsString(new Response("past tickets received",true, employeeService.getAllPastTickets(authorId))));

    }

    public void getAllPendingTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Integer authorId = Integer.parseInt(req.getParameter("authorId"));

        out.println(new ObjectMapper().writeValueAsString(new Response("pending tickets received",true, employeeService.getAllPendingTickets(authorId))));

    }

    public void createReimbursement (HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Reimbursement reimbursement = new ObjectMapper().readValue(requestBody,Reimbursement.class);

        employeeService.createReimbursement(reimbursement.getReimbAmount(), reimbursement.getReimbDescription(), reimbursement.getErsUsersFkAuth(), reimbursement.getErsReimbursementTypeFk());

        out.println(new ObjectMapper().writeValueAsString(new Response("reimbursement form has been created for user id " + reimbursement.getErsUsersFkAuth(), true, null)));
    }


}


