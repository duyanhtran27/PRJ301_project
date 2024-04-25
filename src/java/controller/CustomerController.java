
package controller;

import entity.Customers;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.Vector;
import model.DAOCustomers;

/**
 *
 * @author admin
 */
public class CustomerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DAOCustomers dao = new DAOCustomers();
        String service = request.getParameter("service");
        if(service == null){
            service = "listAllCustomers";
        }
        if (service.equals("deleteCustomer")) {
            int cid = Integer.parseInt(request.getParameter("cid"));
            int n = dao.removeCustomer(cid);
            System.out.println(n);
            response.sendRedirect("CustomerController");

        }
        if (service.equals("insertCustomer")){
            String submit = request.getParameter("submit");
            if(submit == null){
                ResultSet rsCity = dao.getData("Select * from City");
                ResultSet rsCoun = dao.getData("Select * from Country");
            }
        }
        if(service.equals("listAllCustomers")){
            String submit = request.getParameter("submit");
            Vector<Customers> vector = null;
            if(submit == null){
                vector = dao.getCustomer("SELECT * FROM Customers");
            }else{
                String cname = request.getParameter("cname");
                vector = dao.getCustomer("SELECT * FROM Customers WHERE CompanyName like '%" + cname + "%'");
            }
            String titlePage = "CustomerManage";
            String titleTable = "List of Customers";
            RequestDispatcher dispath = request.getRequestDispatcher("/JSP/listCustomers.jsp");
            request.setAttribute("data", vector);
            request.setAttribute("titlePage", titlePage);
            request.setAttribute("titleTable", titleTable);
            dispath.forward(request, response);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
