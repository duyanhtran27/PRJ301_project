package controller;

import entity.ProductCart;
import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Vector;
import model.DAOProducts;

/**
 *
 * @author admin
 */
public class Cart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOProducts dao=new DAOProducts();
        HttpSession session=request.getSession(true);
        String service=request.getParameter("service");
        
        if(service.equals("add2cart")){
            int pid=Integer.parseInt(request.getParameter("pid"));
            String key=pid+"";
            ProductCart proCart=(ProductCart)session.getAttribute(key);
            if(proCart==null){
                String sql="Select * from Products where ProductID="+pid;
                 Vector<Products> vector=dao.getProducts(sql);
                 Products pro=vector.get(0);
                proCart=new ProductCart(pid,
                        pro.getProductName(),
                        pro.getUnitPrice(), 1);
            }else{
                proCart.setQuantity(proCart.getQuantity()+1); 
            }
            session.setAttribute(key, proCart);
            response.sendRedirect("Cart?service=showCart");           
        }
        
        if(service.equals("showCart")){
            Vector<ProductCart> vectorCart=new Vector<ProductCart>();
            Enumeration enu=session.getAttributeNames(); //key
            while(enu.hasMoreElements()){
                String key=(String)enu.nextElement();
                ProductCart proCart=(ProductCart)session.getAttribute(key);
                vectorCart.add(proCart);
            }
            request.setAttribute("vectorCart", vectorCart);
            request.getRequestDispatcher("/JSP/showCart.jsp").forward(request, response);
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
