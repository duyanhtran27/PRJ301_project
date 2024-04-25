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
import model.category;

/**
 *
 * @author ADMIN
 */
public class CategoryDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<category> listCategory(){
        ArrayList<category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new category(rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        List<category> a = dao.listCategory();
        for (category category1 : a) {
            System.out.println(category1);
        }

    }
}
