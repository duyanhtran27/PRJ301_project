package controller;

import entity.Categories;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.Vector;
import model.DAOCategories;

/**
 *
 * @author admin
 */
public class CategoriesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DAOCategories dao = new DAOCategories();
        String service = request.getParameter("service");
        if (service == null) { // run direct controller
            //default
            service = "listAllCategories";
        }
        if (service.equals("deleteCategory")) {
            int cateid = Integer.parseInt(request.getParameter("cateid"));
            int n = dao.removeCategory(cateid);
            System.out.println(n);
            response.sendRedirect("CategoriesController");

        }

        if (service.equals("insertCategory")) {
            String submit = request.getParameter("submit");
            if (submit == null) {//show form insert
                request.getRequestDispatcher("/JSP/insertCategory.jsp")
                        .forward(request, response);
            } else {
                //String CategoryID = request.getParameter("CategoryID");
                String CategoryName = request.getParameter("CategoryName");
                String Description = request.getParameter("Description");
                String Picture = request.getParameter("Picture");

                Categories cate = new Categories(0, CategoryName, Description, Picture);
                dao.insertCategories(cate);
                response.sendRedirect("CategoriesController");
            }
        }

        if (service.equals("updateCategory")) {
            String submit = request.getParameter("submit");
            if (submit == null) {//show form update
                Vector<Categories> vector
                        = dao.getCategories("select * from Categories where CategoryID="
                                + Integer.parseInt(request.getParameter("cateid")));
                request.setAttribute("vector", vector);

                request.getRequestDispatcher("/JSP/updateCategory.jsp")
                        .forward(request, response);

            } else {
                String cateId = request.getParameter("CategoryID");
                int CategoryID = Integer.parseInt(cateId);
                String CategoryName = request.getParameter("CategoryName");
                String Description = request.getParameter("Description");
                String Picture = request.getParameter("Picture");
                
                Categories cate = new Categories(CategoryID, CategoryName, Description, Picture);

                dao.updateCategory(cate);

                response.sendRedirect("CategoriesController");
            }
        }

        if (service.equals("listAllCategories")) {
            // get data from DAO
            String submit = request.getParameter("submit");
            Vector<Categories> vector = null;
            if (submit == null) {//chua submit --> show all
                vector = dao.getCategories("select * from Categories");
            } else { // search
                String catename = request.getParameter("catename");
                vector = dao.getCategories("select * from Categories "
                        + " where CategoryName like '%" + catename + "%'");
            }
            String titlePage = "Categories Manage";
            String titleTable = "List of Categories";
            //select view (JSP)
            RequestDispatcher dispath
                    = request.getRequestDispatcher("/JSP/listCategories.jsp");
            //set data for view
            request.setAttribute("data", vector);
            request.setAttribute("titlePage", titlePage);
            request.setAttribute("titleTable", titleTable);
            //run
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
