package dao;

import models.ReimbursementView;

import java.sql.*;
import java.util.*;

/**
 * @author Kevin Dian
 */

public class EmployeeDaoImpl implements EmployeeDao{


    private static EmployeeDao employeeDao;

    private EmployeeDaoImpl(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static EmployeeDao getInstance(){
        if(employeeDao == null){
            employeeDao = new EmployeeDaoImpl();
        }

        return employeeDao;
    }


    @Override
    public List<ReimbursementView> getAllPastTickets (Integer authorId) {
        List<ReimbursementView> pastList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursement_table WHERE ers_users_fk_auth = ? AND reimb_status = 'Approved'\n"+
            "OR (ers_users_fk_auth = ? AND reimb_status = 'Denied');";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, authorId);
            ps.setInt(2, authorId);

            //this is wh
            ResultSet rs = ps.executeQuery();


            //this is iterating through the records
            while(rs.next()) {
                pastList.add(
                        new ReimbursementView(rs.getInt(1),
                                rs.getDouble(2),
                                rs.getTimestamp(3),
                                rs.getTimestamp(4),
                                rs.getString(5),
                                rs.getBlob(6),
                                rs.getInt(7),
                                rs.getString(8),
                                rs.getString(9),
                                rs.getInt(10),
                                rs.getString(11),
                                rs.getString(12),
                                rs.getString(13),
                                rs.getString(14))
                );
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

            return pastList;
    }

    @Override
    public List<ReimbursementView> getAllPendingTickets(Integer authorId) {
        List<ReimbursementView> pendingList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursement_table WHERE ers_users_fk_auth = ? AND reimb_status = 'Pending';";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, authorId);

            //this is wh
            ResultSet rs = ps.executeQuery();


            //this is iterating through the records
            while(rs.next()) {
                pendingList.add(
                        new ReimbursementView(rs.getInt(1),
                                rs.getDouble(2),
                                rs.getTimestamp(3),
                                rs.getTimestamp(4),
                                rs.getString(5),
                                rs.getBlob(6),
                                rs.getInt(7),
                                rs.getString(8),
                                rs.getString(9),
                                rs.getInt(10),
                                rs.getString(11),
                                rs.getString(12),
                                rs.getString(13),
                                rs.getString(14))
                );
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return pendingList;
    }

    @Override
    public void createReimbursement(Double reimbAmmount, String reimbDescription, Integer ersUsersFkAuth, Integer ersReimbTypeFk) {
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "INSERT INTO ers_reimbursement VALUES(DEFAULT, ?, DEFAULT, DEFAULT,?, DEFAULT, ?, DEFAULT, DEFAULT, ?);\n" +
                            "REFRESH MATERIALIZED VIEW reimbursement_table;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, reimbAmmount);
            ps.setString(2, reimbDescription);
            ps.setInt(3, ersUsersFkAuth);
            ps.setInt(4, ersReimbTypeFk);

            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
