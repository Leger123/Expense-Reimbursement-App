package frontcontroller;


import controller.EmployeeController;
import controller.FinancialManagerController;
import controller.UsersController;
import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kevin Dian
 */

//endpoint routing
@WebServlet(name="dispatcher", urlPatterns = "/api/*")
public class Dispatcher extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI();
        System.out.println(URI);

        switch(URI) {
            //This is for logging in.
            case "/Project_1_ERS_Kevin_Dian/api/login":
                if (req.getMethod().equals("POST"))
                    UsersController.getInstance().login(req, resp);
                break;

            //This is for employee operations.
            case "/Project_1_ERS_Kevin_Dian/api/employee":
                switch (req.getMethod()) {
                    case "GET":
                        EmployeeController.getInstance().getAllPendingTickets(req, resp);
                        break;
                    case "POST":
                        EmployeeController.getInstance().createReimbursement(req,resp);
                        break;
                }
                    break;
            case "/Project_1_ERS_Kevin_Dian/api/employee-pasttickets":
                if (req.getMethod().equals("GET"))
                    EmployeeController.getInstance().getAllPastTickets(req,resp);
                    break;

            //This is for financial manager operations.
            case "/Project_1_ERS_Kevin_Dian/api/financialmanager":
                switch (req.getMethod()) {
                    case "GET":
                        FinancialManagerController.getInstance().getAllReimbursementForms(req, resp);
                        break;
                    case "PATCH":
                        FinancialManagerController.getInstance().approveOrDenyForm(req, resp);
                        break;
                }
            case "/Project_1_ERS_Kevin_Dian/api/financialmanager-filterforms":
                if (req.getMethod().equals("GET"))
                    FinancialManagerController.getInstance().filterPastForms(req, resp);
                    break;
            case "/Project_1_ERS_Kevin_Dian/api/check-session":
                if(req.getMethod().equals("GET"))
                    UsersController.getInstance().checkSession(req, resp);
                break;
            case "/Project_1_ERS_Kevin_Dian/api/logout":
                if(req.getMethod().equals("GET"))
                    UsersController.getInstance().logout(req, resp);
                break;
        }
    }
}

