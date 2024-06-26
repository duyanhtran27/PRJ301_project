/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Product;
import model.Status;

/**
 *
 * @author ADMIN
 */
public class BillDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void checkout(String customerId, String total, String statusId) {
        String query = "INSERT INTO dbo.Bill VALUES(?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, customerId);
            ps.setString(2, total);
            ps.setString(3, statusId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Status findStatus(String id) {
        try {
            String query = "select * from Status where id = ? ";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Status a = new Status(rs.getInt(1),
                        rs.getString(2)
                );
                return a;
            }

        } catch (Exception e) {
        }
        return null;
    }
}
