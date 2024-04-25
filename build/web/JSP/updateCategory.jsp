<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet, java.util.Vector, entity.Categories"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Category</title>
    </head>
    <body>
        <%
            Vector<Categories> vector = (Vector<Categories>) request.getAttribute("vector");
            Categories pro = vector.get(0);
        %>
        <form action="CategoriesController" method="post">
            <table>
                <tr>
                    <td>CategoryID</td>
                    <td><input type="text" name="CategoryID" id="" readonly value="<%=pro.getCategoryID()%>"></td>
                </tr>
                <tr>
                    <td>CategoryName</td>
                    <td><input type="text" name="CategoryName" id="" value="<%=pro.getCategoryName()%>"></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="Description" id="" value="<%=pro.getDescription()%>"></td>
                </tr>
                <tr>
                    <td>Picture</td>
                    <td><input type="text" name="Picture" id="" value="<%=pro.getPicture()%>"></td>
                </tr>

                <tr>
                    <td><input type="submit" name="submit" value="update Category"></td>
                    <td><input type="reset" value="reset">
                        <input type="hidden" name="service" value="updateCategory">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
