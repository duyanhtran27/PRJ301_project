package controller;

import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOProducts;

/**
 *
 * @author admin
 */
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       DAOProducts dao = new DAOProducts();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");

            String service = request.getParameter("service");
            
            if (service == null) { //controller chay dau tien => co the service null
                //default
                service = "listAllProduct";
            }
            
            if(service.equals("deleteProduct")){
                int pid = Integer.parseInt(request.getParameter("pid"));
                int n = dao.removeProduct(pid);
                System.out.println(n);
                response.sendRedirect("productcontroller");
                
            }
            
            if (service.equals("insertProduct")) {
                //getdata
                String productName = request.getParameter("productName");
                String supplierID = request.getParameter("supplierID");
                String categoryID = request.getParameter("categoryID");
                String quantityPerUnit = request.getParameter("quantityPerUnit");
                String unitPrice = request.getParameter("unitPrice");
                String unitsInStock = request.getParameter("unitsInStock");
                String unitsOnOrder = request.getParameter("unitsOnOrder");
                String reorderLevel = request.getParameter("reorderLevel");
                String discontinued = request.getParameter("discontinued");

                //check data: empty, duplicate,isnumber...
                //convert:
                int supID = Integer.parseInt(supplierID);
                int cateID = Integer.parseInt(categoryID);
                double price = Double.parseDouble(unitPrice);
                int unitStock = Integer.parseInt(unitsInStock);
                int unitOrder = Integer.parseInt(unitsOnOrder);
                int reorder = Integer.parseInt(reorderLevel);
                int discon = Integer.parseInt(discontinued);
                System.out.println("OK");

                Products pro = new Products(0, productName, supID,
                        cateID, quantityPerUnit, price, unitStock,
                        unitOrder, reorder, discon == 1 ? true : false);
                int n=dao.addProduct(pro);
                //out.print(n);
                System.out.println("n="+n);
                response.sendRedirect("productcontroller");

            }
            
            if (service.equals("listAllProduct")) {
            out.print("<a href=\"insertProduct.html\"> Insert Product</a>");
            
            out.println("<form action=\"productcontroller\" method=\"get\">");
            out.println("    <p> <input type=\"text\" name=\"pname\"></p>");
            out.println("    <p> <input type=\"submit\" name=\"submit\" value=\"searchName\">");
            out.println("        <input type=\"reset\" value=\"Clear\">");
            out.println("    </p>");
            out.println("</form>");

            //in ra tieu de
            out.println("<table border = 1>\n"
                    + "      <caption>Product List</caption>\n"
                    + "      <tr>\n"
                    + "        <th>ProductID</th>\n"
                    + "        <th>ProductName</th>\n"
                    + "        <th>SupplierID</th>\n"
                    + "        <th>CategoryID</th>\n"
                    + "        <th>QuantityPerUnit</th>\n"
                    + "        <th>UnitPrice</th>\n"
                    + "        <th>UnitsInStock</th>\n"
                    + "        <th>UnitsOnOrder</th>\n"
                    + "        <th>ReorderLevel</th>\n"
                    + "        <th>Discontinued</th>\n"
                    + "        <th>update</th>\n"
                    + "        <th>delete</th>\n"
                    + "      </tr>");

            String submit = request.getParameter("submit");
            Vector<Products> vecto = null; //dam bao ko bi loi khi dinh du lieu truy van cu
            if (submit == null) { //chua submit => show all
                vecto = dao.getProducts("SELECT * FROM Products");
            } else {  //search
                String pname = request.getParameter("pname");
                vecto = dao.getProducts("SELECT * FROM Products WHERE ProductName like '%" + pname + "%'");
            }

            //in ra so phan tu trong bang
            // Vector<Products> vecto = dao.getProducts("select * from products");
            for (Products pro : vecto) {
                out.println("<tr>\n"
                        + "        <td>" + pro.getProductID() + "</td>\n"
                        + "        <td>" + pro.getProductName() + "</td>\n"
                        + "        <td>" + pro.getSupplierID() + "</td>\n"
                        + "        <td>" + pro.getCategoryID() + "</td>\n"
                        + "        <td>" + pro.getQuantityPerUnit() + "</td>\n"
                        + "        <td>" + pro.getUnitPrice() + "</td>\n"
                        + "        <td>" + pro.getUnitsInStock() + "</td>\n"
                        + "        <td>" + pro.getUnitsOnOrder() + "</td>\n"
                        + "        <td>" + pro.getReoderLevel() + "</td>\n"
                        + "        <td>" + pro.isDiscontinued() + "</td>\n"
                        + "        <td><a href=\"productcontroller?service=updateProduct&pid= "+pro.getProductID()+"\">Update </a></td>\n"
                        + "        <td><a href=\"productcontroller?service=deleteProduct&pid="+pro.getProductID()+"\" "+"onclick=\"return confirm('are you sure?')\">Delete </a></td>\n"
                        + "      </tr>");
            }
            out.println("</table>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
