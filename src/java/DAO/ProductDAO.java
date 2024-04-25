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
import model.Product;
import model.User;
import model.category;

/**
 *
 * @author ADMIN
 */
public class ProductDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Product> findProductByCatgeId(String id){
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from Production where categoryId ="+id;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
        public Product findProductById(String id){
       try {
            String query = "select * from Production where Production.id =? ";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Product a = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
                return a;
            }

        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Product a = dao.findProductById("1");
        System.out.println(a);

    }
}
