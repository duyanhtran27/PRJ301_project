
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet, java.util.Vector, entity.Products"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ResultSet rsCate = (ResultSet) request.getAttribute("rsCate");
    ResultSet rsSup = (ResultSet) request.getAttribute("rsSup");
    Vector<Products> vector = (Vector<Products>) request.getAttribute("vector");
    Products pro = vector.get(0);
        %>
<form action="ProductController" method="post">
    <table>
         <tr>
            <td>ProductID</td>
            <td><input type="text" name="ProductID" id="" readonly value="<%=pro.getProductID()%>"></td>
        </tr>
        <tr>
            <td>ProductName</td>
            <td><input type="text" name="ProductName" id="" value="<%=pro.getProductName()%>"></td>
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
            <td><input type="text" name="QuantityPerUnit" id="" value="<%=pro.getQuantityPerUnit()%>"></td>
        </tr>
        <tr>
            <td>UnitPrice</td>
            <td><input type="text" name="UnitPrice" id="" value="<%=pro.getUnitPrice()%>"></td>
        </tr>
        <tr>
            <td>UnitsInStock</td>
            <td><input type="text" name="UnitsInStock" id="" value="<%=pro.getUnitsInStock()%>"></td>
        </tr>
        <tr>
            <td>UnitsOnOrder</td>
            <td><input type="text" name="UnitsOnOrder" id="" value="<%=pro.getUnitsOnOrder()%>"></td>
        </tr>
        <tr>
            <td>ReorderLevel</td>
            <td><input type="text" name="ReorderLevel" id="" value="<%=pro.getReoderLevel()%>"></td>
        </tr>
        <tr>
            <td>Discontinued</td>
            <td>
                <input type="radio" name="Discontinued" value="1" 
                       <%=(pro.isDiscontinued()==false?"checked":"")%> >Continued
                <input type="radio" name="Discontinued" value="0"
                       <%=(pro.isDiscontinued()==true?"checked":"")%>>Discontinued
            </td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="update Product"></td>
            <td><input type="reset" value="reset">
                <input type="hidden" name="service" value="updateProduct">
            </td>
        </tr>
    </table>

</form>
    </body>
</html>