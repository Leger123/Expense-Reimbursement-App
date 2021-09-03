package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Response;
import models.Users;
import services.UsersService;
import services.UsersServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

/**
 * @author Kevin Dian
 */

public class UsersController extends HttpServlet {

    //We will be using the singleton pattern to have the method be called once.
    private static UsersController usersController;
    UsersService usersService;

    private UsersController(){
        usersService = new UsersServiceImpl();
    }

    public static UsersController getInstance(){
        if(usersController == null)
            usersController = new UsersController();

        return usersController;
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Users users = new ObjectMapper().readValue(requestBody,Users.class);

        Users tempUser = usersService.login(users);

        if(tempUser != null){
            //create session if successful
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("currentUser", tempUser);

            out.println(new ObjectMapper().writeValueAsString(new Response("Login is Successful", true, tempUser)));
        }else{
            out.println(new ObjectMapper().writeValueAsString(new Response("Invalid username or password", false, null)));
        }

    }

    public void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Users users = (Users) req.getSession().getAttribute("currentUser");

        if(users != null){
            out.println(new ObjectMapper().writeValueAsString(new Response("Session in progress", true, users)));
        }else{
            out.println(new ObjectMapper().writeValueAsString(new Response("No session was found", false, null)));
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        req.getSession().setAttribute("currentUser", null);

        out.println(new ObjectMapper().writeValueAsString(new Response("Session Terminated",true,null)));
    }


}


