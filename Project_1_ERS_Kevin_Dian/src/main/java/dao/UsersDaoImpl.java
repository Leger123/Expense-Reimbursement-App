package dao;

import models.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Dian
 */

public class UsersDaoImpl implements UsersDao{

    private static UsersDao usersDao;

    private UsersDaoImpl(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static UsersDao getInstance(){
        if(usersDao == null){
            usersDao = new UsersDaoImpl();
        }

        return usersDao;
    }

    @Override
    public Users getUser(String username, String password) {
        Users users = null;

        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)) {

            String sql = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            //This will iterate the results from the database
            while(rs.next()) {
                users = new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /*
    @Override
    public List<Users> getAllUsers() {

        List<Users> users = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();




        }catch(SQLException e){
            e.printStackTrace();
        }


        return null;
    }

     */

    /*
    @Override
    public Users insertUser(Users users) {
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "INSERT INTO ers_users VALUES (DEFAULT, ?, ?, ?, ?, ?, 1);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();




        }catch(SQLException e){
            e.printStackTrace();
        }


        return null;
    }

     */

}
