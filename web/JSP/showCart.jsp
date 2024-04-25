<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.ProductCart" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
         <table border="1">
            <caption>Cart details</caption>
            <tr>
                <th>ProductID</th>
                <th>ProductName</th>
                <th>UnitPrice</th>
                <th>Quantity</th>
                <th>subTotal</th>
                <th>remove</th>
              
            </tr>
            <%  Vector<ProductCart> vector =
                    (Vector<ProductCart> )request.getAttribute("vectorCart");
                for (ProductCart pro : vector) {
            %>
            <tr>
                <td><%=pro.getProductID()%></td>
                <td><%=pro.getProductName()%></td>
                <td><%=pro.getUnitPrice()%></td>
                <td><%=pro.getQuantity()%></td>
                <td></td>
                <td><a href="Cart?service=remove&pid=<%=pro.getProductID()%>">Delete</a></td>
            </tr>
            <%}%>
            
        </table>
        <p> Grand Total:</p>
        <p><a>remove all</a></p>
         <p><a>check out</a></p>
    </body>
</html>
