
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ResultSet rsCate=(ResultSet)request.getAttribute("rsCate");
            ResultSet rsSup=(ResultSet)request.getAttribute("rsSup");
        %>
          <form action="ProductController" method="post">
    <table>
        <tr>
            <td>ProductName</td>
            <td><input type="text" name="ProductName" id=""></td>
        </tr>
        <tr>
            <td>Supplier</td>
            <td>
                <select name="SupplierID" id="">
                    <%while (rsSup.next()){%>
                        <option value="<%=rsSup.getInt(1)%>">
                            <%=rsSup.getString(2)%></option>
                    <%}%>
                   
                </select>
            </td>
        </tr>
        <tr>
            <td>Category</td>
            <td>
                <select name="CategoryID" id="">
                     <%while (rsCate.next()){%>
                        <option value="<%=rsCate.getInt(1)%>"><%=rsCate.getString(2)%></option>
                    <%}%>
                </select>
            </td>
        </tr>
        <tr>
            <td>QuantityPerUnit</td>
            <td><input type="text" name="QuantityPerUnit" id=""></td>
        </tr>
        <tr>
            <td>UnitPrice</td>
            <td><input type="text" name="UnitPrice" id=""></td>
        </tr>
        <tr>
            <td>UnitsInStock</td>
            <td><input type="text" name="UnitsInStock" id=""></td>
        </tr>
        <tr>
            <td>UnitsOnOrder</td>
            <td><input type="text" name="UnitsOnOrder" id=""></td>
        </tr>
        <tr>
            <td>ReorderLevel</td>
            <td><input type="text" name="ReorderLevel" id=""></td>
        </tr>
        <tr>
            <td>Discontinued</td>
            <td>
                <input type="radio" name="Discontinued" value="1">Continued
                <input type="radio" name="Discontinued" value="0">Discontinued
            </td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="insert Product"></td>
            <td><input type="reset" value="reset">
                <input type="hidden" name="service" value="insertProduct">
            </td>
        </tr>
    </table>

</form>
    </body>
</html>