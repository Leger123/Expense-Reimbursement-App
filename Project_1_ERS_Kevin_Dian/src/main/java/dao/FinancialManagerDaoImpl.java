package dao;

import models.ReimbursementView;

import java.sql.*;
import java.util.*;

/**
 * @author Kevin Dian
 */

public class FinancialManagerDaoImpl implements FinancialManagerDao{


    private static FinancialManagerDao financialManagerDao;

    private FinancialManagerDaoImpl(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public static FinancialManagerDao getInstance(){
        if(financialManagerDao == null){
            financialManagerDao = new FinancialManagerDaoImpl();
        }

        return financialManagerDao;
    }




    @Override
    public List<ReimbursementView> getAllReimbursementForms() {
        List<ReimbursementView> reimbursementList1 = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursement_table;";

            PreparedStatement ps = conn.prepareStatement(sql);

            //this is wh
            ResultSet rs = ps.executeQuery();


            //This is iterating through the records
            while(rs.next()) {
                reimbursementList1.add(
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

        return reimbursementList1;

    }

    @Override
    public List<ReimbursementView> filterPastForms(String status) {
        List<ReimbursementView> reimbursementList2 = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursement_table WHERE reimb_status = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, status);

            //this is wh
            ResultSet rs = ps.executeQuery();


            //This is iterating through the records
            while(rs.next()) {
                reimbursementList2.add(
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

        return reimbursementList2;
    }

    @Override
    public void approveOrDenyForm(Integer managerId, Integer statusId, Integer reimbId) {
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){
            String sql = "UPDATE ers_reimbursement SET ers_users_fk_reslvr = ?, reimb_resolved = current_timestamp, ers_reimbursement_status_fk = ? WHERE reimb_id = ?;\n" +
                    "REFRESH MATERIALIZED VIEW reimbursement_table;";

            PreparedStatement ps = conn.prepareStatement(sql);

            //we need this line to fill the ? input
            ps.setInt(1, managerId);
            ps.setInt(2, statusId);
            ps.setInt(3, reimbId);

            ps.executeUpdate();


        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    /*
    @Override
    public List<Reimbursement> getAllApprovedReimbursementForms(Integer resolverId) {
        List<Reimbursement> reimbursementList2 = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursement_table WHERE ers_users_fk_reslvr = ? AND reimb_status = 'Approved';";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, resolverId);

            //this is wh
            ResultSet rs = ps.executeQuery();


            //this is iterating through the records
            while(rs.next()) {
                reimbursementList2.add(
                        new Reimbursement(rs.getInt(1),
                                rs.getDouble(2),
                                rs.getTimestamp(3),
                                rs.getTimestamp(4),
                                rs.getString(5),
                                rs.getBlob(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getString(9),
                                rs.getString(10),
                                rs.getString(11),
                                rs.getString(12))
                );
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return reimbursementList2;

    }

     */

    /*
    @Override
    public List<Reimbursement> getAllDeniedReimbursementForms(Integer resolverlastId) {
        List<Reimbursement> reimbursementList3 = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(ConnectionUtil.url,ConnectionUtil.username,ConnectionUtil.password)){

            String sql = "SELECT * FROM reimbursement_table WHERE ers_users_fk_reslvr = 3 AND reimb_status = 'Denied';";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, resolverLastName);

            //this is wh
            ResultSet rs = ps.executeQuery();


            //this is iterating through the records
            while(rs.next()) {
                reimbursementList3.add(
                        new Reimbursement(rs.getInt(1),
                                rs.getDouble(2),
                                rs.getTimestamp(3),
                                rs.getTimestamp(4),
                                rs.getString(5),
                                rs.getBlob(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getString(9),
                                rs.getString(10),
                                rs.getString(11),
                                rs.getString(12))
                );
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return reimbursementList3;

    }

     */

}
