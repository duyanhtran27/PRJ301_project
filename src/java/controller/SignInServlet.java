
package controller;

import entity.Employees;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOEmployees;

/**
 *
 * @author admin
 */
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        request.setAttribute("check", "null");
        request.getRequestDispatcher("/JSP/signIn.jsp").include(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        DAOEmployees dao = new DAOEmployees();
        HttpSession session = request.getSession();
        Employees emp = dao.login(user, pass);
        if(emp != null){
            request.setAttribute("check", "success");
            session.setAttribute("user", user);
            session.setAttribute("pass", pass);
            request.getRequestDispatcher("/JSP/signIn.jsp").forward(request, response);
        } else {
            request.setAttribute("check", "fail");
            request.getRequestDispatcher("/JSP/signIn.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
