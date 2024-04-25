package model;

/**
 *
 * @author admin
 */
import entity.Products;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOProducts extends DBConnect {

    public int removeProduct(int pid){
        int n=0;
        //check foreign key [order details]
        String sql = "Select * from [Order Details] where [ProductID]="+pid;
        ResultSet rs = this.getData(sql);
        try{
            if(rs.next()){//primary key exist on foreign key --> don't delete
                updateDiscontinue(pid,1);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        String sqlDelete = "Delete from Products where ProductID="+pid;
        try{
            Statement st = conn.createStatement();
            n = st.executeUpdate(sqlDelete);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    public int updateProduct(Products pro) {
        int n = 0;
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[SupplierID] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[QuantityPerUnit] = ?\n"
                + "      ,[UnitPrice] = ?\n"
                + "      ,[UnitsInStock] = ?\n"
                + "      ,[UnitsOnOrder] = ?\n"
                + "      ,[ReorderLevel] = ?\n"
                + "      ,[Discontinued] = ?\n"
                + " WHERE ProductID = ?";

        try {
            PreparedStatement prestate = conn.prepareStatement(sql);
            
            prestate.setString(1, pro.getProductName());
            prestate.setInt(2, pro.getSupplierID());
            prestate.setInt(3, pro.getCategoryID());
            prestate.setString(4, pro.getQuantityPerUnit());
            prestate.setDouble(5, pro.getUnitPrice());
            prestate.setInt(6, pro.getUnitsInStock());
            prestate.setInt(7, pro.getUnitsOnOrder());
            prestate.setInt(8, pro.getReoderLevel());
            prestate.setInt(9, pro.isDiscontinued()==true ? 1: 0);
            prestate.setInt(10, pro.getProductID());
            
            n = prestate.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        return n;

    }
    public int updateDiscontinue(int pid, int discontinue){
        int n=0;
        String sql = "UPDATE [Products]\n" +
"   SET [Discontinued] = ? " +
" WHERE ProductID=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, discontinue);
            ps.setInt(2, pid);
            n = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    public int updateUnitPrice(int pid, double price){
        int n=0;
        String sql = "UPDATE [Products]\n" +
"   SET [UnitPrice] = [UnitPrice]+? " +
" WHERE ProductID=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, price);
            ps.setInt(2, pid);
            n = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    public int updateProducts(Products pro){
        int n=0;
        String sql = "UPDATE [dbo].[Products]\n" +
"   SET [ProductName] = ?,[SupplierID] = ?,[CategoryID] = ?,[QuantityPerUnit] = ?\n" +
"      ,[UnitPrice] = ?,[UnitsInStock] = ?,[UnitsOnOrder] = ?,[ReorderLevel] = ?,[Discontinued] = ?\n" +
" WHERE ProductID=?";
        try{
            PreparedStatement preState = conn.prepareStatement(sql);
            
            preState.setString(1, pro.getProductName());
            preState.setInt(2, pro.getSupplierID());
            preState.setInt(3, pro.getCategoryID());
            preState.setString(4, pro.getQuantityPerUnit());
            preState.setDouble(5, pro.getUnitPrice());
            preState.setInt(6, pro.getUnitsInStock());
            preState.setInt(7, pro.getUnitsOnOrder());
            preState.setInt(8, pro.getReoderLevel());
            preState.setInt(9, (pro.isDiscontinued()==true?1:0));
            preState.setInt(10, pro.getProductID());
            
            n = preState.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    public Vector<Products> getProducts(String sql){
        
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            
        while(rs.next()){
            int ProductID=rs.getInt(1);
            String ProductName=rs.getString("ProductName");
            int SupplierID =rs.getInt(3);
            int CategoryID=rs.getInt(4);
            String QuantityPerUnit=rs.getString(5);
            double UnitPrice=rs.getDouble(6);
            int UnitsInStock=rs.getInt(7);
            int UnitsOnOrder=rs.getInt(8);
            int ReoderLevel=rs.getInt(9);
            boolean Discontinued=rs.getBoolean(10);
            Products pro = new Products(ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit,UnitPrice,UnitsInStock, UnitsOnOrder,ReoderLevel,Discontinued);
            vector.add(pro);
        }
}
        catch(Exception e){
            e.printStackTrace();
        }
        return vector;
    }
    public int addProduct(Products pro){
        int n=0;
        String sql = "INSERT INTO [dbo].[Products]\n" +
"           ([ProductName],[SupplierID],[CategoryID],[QuantityPerUnit],[UnitPrice]\n" +
"           ,[UnitsInStock],[UnitsOnOrder],[ReorderLevel],[Discontinued])\n" +
"     VALUES\n" +
"           ('"+pro.getProductName()+"',"+pro.getSupplierID()+
        ","+pro.getCategoryID()+",'"+pro.getQuantityPerUnit()+
        "',"+pro.getUnitPrice()+","+pro.getUnitsInStock()+
        ","+pro.getUnitsOnOrder()+","+pro.getReoderLevel()+
        ","+(pro.isDiscontinued()==true?1:0)+")";
        
        try{
            Statement st = conn.createStatement();
            n = st.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    
    public int insertProduct(Products pro){
        int n=0;
        String sql = "INSERT INTO [dbo].[Products]\n" +
"           ([ProductName],[SupplierID],[CategoryID],[QuantityPerUnit],[UnitPrice]\n" +
"           ,[UnitsInStock],[UnitsOnOrder],[ReorderLevel],[Discontinued])\n" +
"     VALUES(?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement preState = conn.prepareStatement(sql);
            
            preState.setString(1, pro.getProductName());
            preState.setInt(2, pro.getSupplierID());
            preState.setInt(3, pro.getCategoryID());
            preState.setString(4, pro.getQuantityPerUnit());
            preState.setDouble(5, pro.getUnitPrice());
            preState.setInt(6, pro.getUnitsInStock());
            preState.setInt(7, pro.getUnitsOnOrder());
            preState.setInt(8, pro.getReoderLevel());
            preState.setInt(9, (pro.isDiscontinued()==true?1:0));
            
            n = preState.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    
    public void displayAll() {
        String sql = "Select * from Products";
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            
        while(rs.next()){
            int ProductID=rs.getInt(1);
            String ProductName=rs.getString("ProductName");
            int SupplierID =rs.getInt(3);
            int CategoryID=rs.getInt(4);
            String QuantityPerUnit=rs.getString(5);
            double UnitPrice=rs.getDouble(6);
            int UnitsInStock=rs.getInt(7);
            int UnitsOnOrder=rs.getInt(8);
            int ReoderLevel=rs.getInt(9);
            boolean Discontinued=rs.getBoolean(10);
            Products pro = new Products(ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit,UnitPrice,UnitsInStock, UnitsOnOrder,ReoderLevel,Discontinued);
            System.out.println(pro);    
        }
}
        catch(Exception e){
            e.printStackTrace();
        }
}
    public static void main(String[] args) {
        DAOProducts dao = new DAOProducts();
//        Products obj = new Products(76, "DemoName", 1, 1, "demo"
//                , 1, 2, 1, 1, true);
//        int n = dao.updateProducts(obj);
//        if(n>0){
//            System.out.println("updated");
//        }
        Vector<Products> vector = dao.getProducts("Select * from Products");
        for(Products pro:vector){
            System.out.println(pro);
        }
        int n= dao.removeProduct(80);
        if(n>0){
            System.out.println("deleted");
        }
        //dao.displayAll();
    }
}
