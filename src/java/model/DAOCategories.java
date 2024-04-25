package model;

/**
 *
 * @author admin
 */
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.PreparedStatement;
import entity.Categories;
import java.sql.SQLException;

public class DAOCategories extends DBConnect {

    public Vector<Categories> getCategories(String sql) {
        Vector<Categories> vector = new Vector<Categories>();
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int categoryID = rs.getInt("CategoryID");
                String categoryName = rs.getString("CategoryName");
                String description = rs.getString("Description");

                Categories categories = new Categories(categoryID, categoryName, description);

                vector.add(categories);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    public int insertCategories(Categories cate) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Categories] ([CategoryName],[Description],[Picture])\n"
                + "     VALUES(?,?,?)";

        try {
            PreparedStatement prestate = conn.prepareStatement(sql);
            prestate.setString(1, cate.getCategoryName());
            prestate.setString(2, cate.getDescription());
            prestate.setString(3, cate.getPicture());
            
            n = prestate.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n;
    }

    public int updateCategoryName(int cateid, String cateName) {
        int n = 0;
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [CategoryName] = ?>\n"
                + " WHERE CategoryID = ?";
        PreparedStatement prestate;
        try {
            prestate = conn.prepareStatement(sql);
            prestate.setString(1, cateName);
            prestate.setInt(2, cateid);
            n = prestate.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n;
    }

    //update mot bang 
    public int updateCategory(Categories cate) {
        int n = 0;
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [CategoryName] = ?\n"
                + "      ,[Description] = ?\n"
                + " WHERE CategoryID = ?";

        PreparedStatement prestate;
        try {
            prestate = conn.prepareStatement(sql);
            prestate.setString(1, cate.getCategoryName());
            prestate.setString(2, cate.getDescription());
            n = prestate.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    //xoa phan tu trong bang category
    public int removeCategory(int cateid) {
        int n = 0;
        String sql = "SELECT * FROM [Categories] WHERE CategoryID =" + cateid;
        ResultSet rs = this.getData(sql);
        try {
            if (rs.next()) {
                //neu co dk xoa bang dien vao
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //Neu ko can check phan tu , xoa
        String sqlDelete = "DELETE FROM [dbo].[Categories]\n"
                + "      WHERE CategoryID = " + cateid;
        Statement st;
        try {
            st = conn.createStatement();
            n = st.executeUpdate(sqlDelete);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        DAOCategories cate = new DAOCategories();
        // Categories categori = new Categories(1, "Laptop", "Break");
        // int n = cate.insertCategories(categori);

        int n = cate.removeCategory(2);
        Vector<Categories> vector = cate.getCategories("SELECT * FROM Categories");
        for (Categories categories : vector) {
            System.out.println(categories);
        }
    }
}
