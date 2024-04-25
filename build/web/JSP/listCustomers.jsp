<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector, entity.Customers" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% String titlePage = 
                (String)request.getAttribute("titlePage");%>
        <title><%=titlePage%></title>
        <script>
            function confirmDelete() {
                return confirm("Are you sure you want to delete this product?");
            }
        </script>
    </head>
    <body>
        <p><a href="CustomerController?service=insertCustomer">Insert Customer</a></p>
        <form action="CustomerController">
            <p><input type="text" name="cname" id="" /></p>
            <input type="submit" name="submit" value="searchName" />
            <input type="reset" value="Clear" />
            <input type="hidden" name="service" value="listAllCustomers" />
        </form>
        <table border = 1>
            <% String titleTable = (String)request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
            <tr>
                <th>CustomerID</th>
                <th>CompanyName</th>
                <th>ContactName</th>
                <th>ContactTitle</th>
                <th>Address</th>
                <th>City</th>
                <th>Region</th>
                <th>PostalCode</th>
                <th>Country</th>
                <th>Phone</th>
                <th>Fax</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            <% Vector<Customers> vector = 
                    (Vector<Customers>)request.getAttribute("data");
            for (Customers cus : vector) {
            %>
            <tr>
                <td><%=cus.getCustomerID()%></td>
                <td><%=cus.getCompanyName()%></td>
                <td><%=cus.getContactName()%></td>
                <td><%=cus.getContactTitle()%></td>
                <td><%=cus.getAddress()%></td>
                <td><%=cus.getCity()%></td>
                <td><%=cus.getRegion()%></td>
                <td><%=cus.getPostalCode()%></td>
                <td><%=cus.getCountry()%></td>
                <td><%=cus.getPhone()%></td>
                <td><%=cus.getFax()%></td>
                <td></td>
                <td><a href="CustomerController?service=deleteCustomer&cid=<%=cus.getCustomerID()%>" onclick="return confirmDelete()">Delete</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
