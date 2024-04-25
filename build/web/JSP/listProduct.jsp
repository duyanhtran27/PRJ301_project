
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector, entity.Products" %>
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
        <p align="right"><a href="Cart?service=showCart">showCart</a> </p>
        <p align="right"><a href="EmployeeController?service=login">Login</a> <br>
        <%
            String userName=(String)session.getAttribute("user");
            if(userName!=null){
        %>
        <span style="color:red; text-align: right">Welcome <%=userName%></span>
        <%}%></p>
        <p><a href="ProductController?service=insertProduct">insert Products</a></p>
        <form action="ProductController">
            <p><input type="text" name="pname" id="" /></p>
            <input type="submit" name="submit" value="searchName" />
            <input type="reset" value="Clear" />
            <input type="hidden" name="service" value="listAllProducts" />
        </form>
        <table border = 1>
        <% String titleTable = (String)request.getAttribute("titleTable");%>
    <caption><%=titleTable%></caption>
    <tr>
        <th>ProductID</th>
        <th>ProductName</th>
        <th>SupplierID</th>
        <th>CategoryID</th>
        <th>QuantityPerUnit</th>
        <th>UnitPrice</th>
        <th>UnitsInStock</th>
        <th>UnitsOnOrder</th>
        <th>ReorderLevel</th>
        <th>Discontinued</th>
        <th>update</th>
       <th>delete</th>
    </tr>
    <% Vector<Products> vector = 
            (Vector<Products>)request.getAttribute("data");
    for (Products pro : vector) {
    %>
    <tr>
        <td><%=pro.getProductID() %></td>
        <td><%=pro.getProductName()%></td>
        <td><%=pro.getSupplierID()%></td>
        <td><%=pro.getCategoryID()%></td>
        <td><%=pro.getQuantityPerUnit()%></td>
        <td><%=pro.getUnitPrice()%></td>
        <td><%=pro.getUnitsInStock()%></td>
        <td><%=pro.getUnitsOnOrder()%></td>
        <td><%=pro.getReoderLevel()%></td>
        <td><%=pro.isDiscontinued()%></td>
        <td><a href="ProductController?service=updateProduct&pid=<%=pro.getProductID()%>">Update</td>
        <td><a href="ProductController?service=deleteProduct&pid=<%=pro.getProductID()%>" onclick="return confirmDelete()">Delete</a></td>
        <td><a href="Cart?service=add2cart&pid=<%=pro.getProductID()%>">add2cart</a></td>
    </tr>
    <%}%>
</table>
    </body>
</html>
