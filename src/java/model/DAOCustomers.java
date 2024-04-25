package model;

import entity.Customers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class DAOCustomers extends DBConnect{
    
//    public int removeCustomer(int cid){
//        int n=0;
//        String sql = "delete from Customers where CustomerID = "+cid;
//        try{
//            Statement st = conn.createStatement();
//            n = st.executeUpdate(sql);
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return n;
//    }
//    
//    public int updateCustomers(Customers cus){
//        int n=0;
//        String sql = "UPDATE [dbo].[Customers]\n" +
//"   SET [CompanyName] = ?, [ContactName] = ?, [ContactTitle] = ?, [Address] = ?,[City] = ?\n" +
//"      ,[Region] = ? ,[PostalCode] = ?,[Country] = ?,[Phone] = ?,[Fax] = ?\n" +
//" WHERE [CustomerID] = ?";
//        try{
//            PreparedStatement ps = conn.prepareStatement(sql);
//            
//            ps.setString(1, cus.getCompanyName());
//            ps.setString(2, cus.getContactName());
//            ps.setString(3, cus.getContactTitle());
//            ps.setString(4, cus.getAddress());
//            ps.setString(5, cus.getCity());
//            ps.setString(6, cus.getRegion());
//            ps.setString(7, cus.getPostalCode());
//            ps.setString(8, cus.getCountry());
//            ps.setString(9, cus.getPhone());
//            ps.setString(10, cus.getFax());
//            
//            ps.setString(11, cus.getCustomerID());
//            
//            n = ps.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return n;
//    }
//    public Vector<Customers> getCustomers(String sql){
//        Vector<Customers> vector = new Vector<>();
//        try{
//            Statement st = conn.createStatement(
//                    ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = st.executeQuery(sql);
//            
//            while(rs.next()){
//                String CustomerID = rs.getString(1);
//                String CompanyName = rs.getString(2);
//                String ContactName = rs.getString(3);
//                String ContactTitle = rs.getString(4);
//                String Address = rs.getString(5);
//                String City = rs.getString(6);
//                String Region = rs.getString(7);
//                String PostalCode = rs.getString(8);
//                String Country = rs.getString(9);
//                String Phone = rs.getString(10);
//                String Fax = rs.getString(11);
//            Customers cus = new Customers(CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax);
//            vector.add(cus);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return vector;
//    }
//    
//    public int addCustomers(Customers cus){
//        int n = 0;
//        String sql = "INSERT INTO [dbo].[Customers]\n" +
//"           ([CustomerID],[CompanyName],[ContactName],[ContactTitle],[Address],[City]\n" +
//"           ,[Region],[PostalCode],[Country],[Phone],[Fax])\n" +
//"     VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//        try{
//            PreparedStatement preState = conn.prepareStatement(sql);
//            
//            preState.setString(1, cus.getCustomerID());
//            preState.setString(2, cus.getCompanyName());
//            preState.setString(3, cus.getContactName());
//            preState.setString(4, cus.getContactTitle());
//            preState.setString(5, cus.getAddress());
//            preState.setString(6, cus.getCity());
//            preState.setString(7, cus.getRegion());
//            preState.setString(8, cus.getPostalCode());
//            preState.setString(9, cus.getCountry());
//            preState.setString(10, cus.getPhone());
//            preState.setString(11, cus.getFax());
//            
//            n = preState.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return n;
//    }
//    public void displayAllCustomers() {
//        String sql = "Select * from Customers";
//        try {
//            Statement st = conn.createStatement(
//                    ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = st.executeQuery(sql);
//            
//        while(rs.next()){
//            String CustomerID = rs.getString(1);
//            String CompanyName = rs.getString(2);
//            String ContactName = rs.getString(3);
//            String ContactTitle = rs.getString(4);
//            String Address = rs.getString(5);
//            String City = rs.getString(6);
//            String Region = rs.getString(7);
//            String PostalCode = rs.getString(8);
//            String Country = rs.getString(9);
//            String Phone = rs.getString(10);
//            String Fax = rs.getString(11);
//            Customers cus = new Customers(CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax);
//            System.out.println(cus);    
//        }
//}
//        catch(Exception e){
//            e.printStackTrace();
//        }
//}
//    public static void main(String[] args) {
//        DAOCustomers dao = new DAOCustomers();
//        Customers obj = new Customers("ABCD", "Around the Horn", "Pedro Afonso", "Owner", "123 Hai Ba Trung", "Ha Noi", "OR", "10000", "Viet Nam", "12345678", "40.67.89.89");
//        int n = dao.addCustomers(obj);
//        if(n>0){
//            System.out.println("inserted");
//        }
//        Vector<Customers> vector = dao.getCustomers("Select * from Customers");
//        for(Customers cus : vector){
//            System.out.println(cus);
//        }
//        //dao.displayAllCustomers();
//    }
     public Vector<Customers> getCustomer(String sql) {
        Vector<Customers> vector = new Vector<Customers>();
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String customerID = rs.getString("CustomerID");
                String companyName = rs.getString("CompanyName");
                String contactName = rs.getString("ContactName");
                String contactTitle = rs.getString("ContactTitle");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                String region = rs.getString("Region");
                String postalCode = rs.getString("PostalCode");
                String country = rs.getString("Country");
                String phone = rs.getString("Phone");
                String fax = rs.getString("Fax");

                Customers customer = new Customers(customerID, companyName, contactName,
                        contactTitle, address, city, region, postalCode, country, phone, fax);

                vector.add(customer);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vector;
    }

    public int insertCustomers(Customers cus) {
        int n = 0;
        String sql = " INSERT INTO [dbo].[Customers]\n"
                + "           ([CustomerID]\n"
                + "           ,[CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement prestate;
        try {
            prestate = conn.prepareCall(sql);
            prestate.setString(1, cus.getCustomerID());
            prestate.setString(2, cus.getCompanyName());
            prestate.setString(3, cus.getContactName());
            prestate.setString(4, cus.getContactTitle());
            prestate.setString(5, cus.getAddress());
            prestate.setString(6, cus.getCity());
            prestate.setString(7, cus.getRegion());
            prestate.setString(8, cus.getPostalCode());
            prestate.setString(9, cus.getCountry());
            prestate.setString(10, cus.getPhone());
            prestate.setString(11, cus.getFax());
            n = prestate.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;

    }

    //update 1 phan tu trong bang 
    public int updateContactName(int customerID, String contactName) {
        int n = 0;
        String sql = "UPDATE [dbo].[Customers]\n"
                + "   SET [ContactName] = ?\n"
                + " WHERE CustomerID = ?";
        try {
            PreparedStatement prestate = conn.prepareStatement(sql);
            prestate.setString(1, contactName);
            prestate.setInt(2, customerID);
            n = prestate.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return n;
    }

    //update ca bang table
    public int updateCustomer(Customers cus) {
        int n = 0;
        String sql = "UPDATE [dbo].[Customers]\n"
                + "   SET [CustomerID] = ?\n"
                + "      ,[CompanyName] = ?\n"
                + "      ,[ContactName] = ?\n"
                + "      ,[ContactTitle] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[City] = ?\n"
                + "      ,[Region] = ?\n"
                + "      ,[PostalCode] = ?\n"
                + "      ,[Country] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Fax] = ?\n"
                + " WHERE < CustomerID = ?>";
        PreparedStatement prestate;
        try {
            prestate = conn.prepareStatement(sql);
            prestate.setString(1, cus.getCustomerID());
            prestate.setString(2, cus.getCompanyName());
            prestate.setString(3, cus.getContactName());
            prestate.setString(4, cus.getContactTitle());
            prestate.setString(5, cus.getAddress());
            prestate.setString(6, cus.getCity());
            prestate.setString(7, cus.getRegion());
            prestate.setString(8, cus.getPostalCode());
            prestate.setString(9, cus.getCountry());
            prestate.setString(10, cus.getPhone());
            prestate.setString(11, cus.getFax());

            n = prestate.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return n;

    }

    public int removeCustomer(int customerID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Customers]\n"
                + "      WHERE CustomerID =" + customerID;

        try {
            Statement st = conn.createStatement(); 
            n = st.executeUpdate(sql);
        } catch (Exception ex) {
              ex.printStackTrace();
        }
        
        return n;
    }

    public static void main(String[] args) {
        DAOCustomers dao = new DAOCustomers();
//        Customers cus = new Customers("1DA", "FPT",
//                "NgocHung", "depzai", "DHFPT", "HN",
//                "VN", "VN123", "BG", "00", "ttt");
//        int n = customer.insertCustomers(cus);
//        if (n < 0) {
//            System.out.println("FAIL TO INSERT");
//        }

          int n = dao.updateContactName(2, "Ngoc Hung");
          int a = dao.removeCustomer(3);
        Vector<Customers> vector = dao.getCustomer("SELECT * FROM Customers");
        for (Customers customers : vector) {
            System.out.println(customers);
        }
    }
}
