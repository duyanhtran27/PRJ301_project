package controller;

import entity.Employees;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOEmployees;

/**
 *
 * @author admin
 */
public class EmployeeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOEmployees dao = new DAOEmployees();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Employee Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1'>\n"
                    + "    <caption>Employees List</caption>\n"
                    + "    <tr>\n"
                    + "        <th>EmployeeID</th>\n"
                    + "        <th>LastName</th>\n"
                    + "        <th>FirstName</th>\n"
                    + "        <th>Title</th>\n"
                    + "        <th>TitleOfCourtesy</th>\n"
                    + "        <th>BirthDate</th>\n"
                    + "        <th>HireDate</th>\n"
                    + "        <th>Address</th>\n"
                    + "        <th>City</th>\n"
                    + "        <th>Region</th>\n"
                    + "        <th>PostalCode</th>\n"
                    + "        <th>Country</th>\n"
                    + "        <th>HomePhone</th>\n"
                    + "        <th>Extension</th>\n"
                    + "        <th>Photo</th>\n"
                    + "        <th>Notes</th>\n"
                    + "        <th>ReportsTo</th>\n"
                    + "        <th>PhotoPath</th>\n"
                    + "        <th>update</th>\n"
                    + "        <th>delete</th>\n"
                    + "    </tr>");
            Vector<Employees> vector = dao.getEmployees("Select * from Employees");
            for (Employees emp : vector) {
                out.println("<tr>\n"
                        + "        <td>"+emp.getEmployeeID()+"</td>\n"
                        + "        <td>"+emp.getLastName()+"</td>\n"
                        + "        <td>"+emp.getFirstName()+"</td>\n"
                        + "        <td>"+emp.getTitle()+"</td>\n"
                        + "        <td>"+emp.getTitleOfCourtesy()+"</td>\n"
                        + "        <td>"+emp.getBirthDate()+"</td>\n"
                        + "        <td>"+emp.getHireDate()+"</td>\n"
                        + "        <td>"+emp.getAddress()+"</td>\n"
                        + "        <td>"+emp.getCity()+"</td>\n"
                        + "        <td>"+emp.getRegion()+"</td>\n"
                        + "        <td>"+emp.getPostalCode()+"</td>\n"
                        + "        <td>"+emp.getCountry()+"</td>\n"
                        + "        <td>"+emp.getHomePhone()+"</td>\n"
                        + "        <td>"+emp.getExtension()+"</td>\n"
                        + "        <td>"+emp.getPhoto()+"</td>\n"
                        + "        <td>"+emp.getNotes()+"</td>\n"
                        + "        <td>"+emp.getReportsTo()+"</td>\n"
                        + "        <td>"+emp.getPhoto()+"</td>\n"
                        + "        <td></td>\n"
                        + "        <td></td>\n"
                        + "    </tr>");
            }
            out.println("</table>");
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
