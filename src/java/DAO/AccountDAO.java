/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;
import model.category;

/**
 *
 * @author ADMIN
 */
public class AccountDAO {
        Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public User findUserById(String userName, String Password){
       try {
            String query = "select * from [User] where [User].name = ? and [User].password = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, Password);
            rs = ps.executeQuery();

            while (rs.next()) {
                User a = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                return a;
            }

        } catch (Exception e) {
        }
        return null;
    }
    
    public User findUserByUsername(String userName){
       try {
            String query = "select * from [User] where [User].name = ? ";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();

            while (rs.next()) {
                User a = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                return a;
            }

        } catch (Exception e) {
        }
        return null;
    }
    
    
    public void register(String name, String username, String pass) {
        String query = "INSERT INTO [User] VALUES(?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, pass);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        dao.register("a", "a", "a");

    }
}
