package model;

/**
 *
 * @author admin
 */
import entity.Employees;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

public class DAOEmployees extends DBConnect {

    public Vector<Employees> getEmployees(String sql) {
        Vector<Employees> vector = new Vector<>();
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int EmployeeID = rs.getInt(1);
                String LastName = rs.getString(2);
                String FirstName = rs.getString(3);
                String Title = rs.getString(4);
                String TitleOfCourtesy = rs.getString(5);
                Date BirthDate = rs.getDate(6);
                Date HireDate = rs.getDate(7);
                String Address = rs.getString(8);
                String City = rs.getString(9);
                String Region = rs.getString(10);
                String PostalCode = rs.getString(11);
                String Country = rs.getString(12);
                String HomePhone = rs.getString(13);
                String Extension = rs.getString(14);
                String Photo = rs.getString(15);
                String Notes = rs.getString(16);
                int ReportsTo = rs.getInt(17);
                String PhotoPath = rs.getString(18);

                Employees emp = new Employees(EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath);
                vector.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    public Employees login(String user, String pass) {
        String sql = "select * from Employees where FirstName=? and EmployeeID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int EmployeeID = rs.getInt(1);
                String LastName = rs.getString(2);
                String FirstName = rs.getString(3);
                String Title = rs.getString(4);
                String TitleOfCourtesy = rs.getString(5);
                Date BirthDate = rs.getDate(6);
                Date HireDate = rs.getDate(7);
                String Address = rs.getString(8);
                String City = rs.getString(9);
                String Region = rs.getString(10);
                String PostalCode = rs.getString(11);
                String Country = rs.getString(12);
                String HomePhone = rs.getString(13);
                String Extension = rs.getString(14);
                String Photo = rs.getString(15);
                String Notes = rs.getString(16);
                int ReportsTo = rs.getInt(17);
                String PhotoPath = rs.getString(18);

                Employees emp = new Employees(EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath);
                ps.close();
                rs.close();

                return emp;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateEmployees(Employees emp) {
        int n = 0;
        String sql = "UPDATE [dbo].[Employees]\n"
                + "   SET [LastName] = ?,[FirstName] = ?,[Title] = ?,[TitleOfCourtesy] = ?,[BirthDate] = ?,[HireDate] = ?\n"
                + "      ,[Address] = ?,[City] = ?,[Region] = ? ,[PostalCode] = ?,[Country] = ?,[HomePhone] = ?,[Extension] = ?\n"
                + "      ,[Photo] = ?,[Notes] = ?,[ReportsTo] = ?,[PhotoPath] = ?\n"
                + " WHERE [EmployeeID]=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, emp.getLastName());
            ps.setString(2, emp.getFirstName());
            ps.setString(3, emp.getTitle());
            ps.setString(4, emp.getTitleOfCourtesy());
            ps.setDate(5, (java.sql.Date) emp.getBirthDate());
            ps.setDate(6, (java.sql.Date) emp.getHireDate());
            ps.setString(7, emp.getAddress());
            ps.setString(8, emp.getCity());
            ps.setString(9, emp.getRegion());
            ps.setString(10, emp.getPostalCode());
            ps.setString(11, emp.getCountry());
            ps.setString(12, emp.getHomePhone());
            ps.setString(13, emp.getExtension());
            ps.setString(14, emp.getPhoto());
            ps.setString(15, emp.getNotes());
            ps.setInt(16, emp.getReportsTo());
            ps.setString(17, emp.getPhotoPath());

            ps.setInt(18, emp.getEmployeeID());
            n = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int addEmployees(Employees emp) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Employees]\n"
                + "           ([LastName],[FirstName],[Title],[TitleOfCourtesy],[BirthDate],[HireDate],[Address],[City],[Region]\n"
                + "		   ,[PostalCode],[Country],[HomePhone],[Extension],[Photo],[Notes],[ReportsTo],[PhotoPath])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, emp.getEmployeeID());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getFirstName());
            ps.setString(4, emp.getTitle());
            ps.setString(5, emp.getTitleOfCourtesy());
            ps.setDate(6, (java.sql.Date) emp.getBirthDate());
            ps.setDate(7, (java.sql.Date) emp.getHireDate());
            ps.setString(8, emp.getAddress());
            ps.setString(9, emp.getCity());
            ps.setString(10, emp.getRegion());
            ps.setString(11, emp.getPostalCode());
            ps.setString(12, emp.getCountry());
            ps.setString(13, emp.getHomePhone());
            ps.setString(14, emp.getExtension());
            ps.setString(15, emp.getPhoto());
            ps.setString(16, emp.getNotes());
            ps.setInt(17, emp.getReportsTo());
            ps.setString(18, emp.getPhotoPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public void displayAllEmployees() {
        String sql = "Select * from Employees";
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int EmployeeID = rs.getInt(1);
                String LastName = rs.getString(2);
                String FirstName = rs.getString(3);
                String Title = rs.getString(4);
                String TitleOfCourtesy = rs.getString(5);
                Date BirthDate = rs.getDate(6);
                Date HireDate = rs.getDate(7);
                String Address = rs.getString(8);
                String City = rs.getString(9);
                String Region = rs.getString(10);
                String PostalCode = rs.getString(11);
                String Country = rs.getString(12);
                String HomePhone = rs.getString(13);
                String Extension = rs.getString(14);
                String Photo = rs.getString(15);
                String Notes = rs.getString(16);
                int ReportsTo = rs.getInt(17);
                String PhotoPath = rs.getString(18);

                Employees emp = new Employees(EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath);
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DAOEmployees dao = new DAOEmployees();
        Vector<Employees> vector = dao.getEmployees("Select * from Employees");
        for (Employees emp : vector) {
            System.out.println(emp);
        }
        //dao.displayAllEmployees();
    }
}
