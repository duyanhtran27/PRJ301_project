<%@page import="java.util.Vector, entity.Categories" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% String titlePage = 
                (String)request.getAttribute("titlePage");%>
        <title><%=titlePage%></title>
        <script>
            function confirmDelete() {
                return confirm("Are you sure you want to delete?");
            }
        </script>
    </head>
    <body>
        <p><a href="CategoriesController?service=insertCategory">Insert Categories</a></p>
        <form action="CategoriesController">
            <p><input type="text" name="catename" id="" /></p>
            <input type="submit" name="submit" value="searchName" />
            <input type="reset" value="Clear" />
            <input type="hidden" name="service" value="listAllCategories" />
        </form>
        <table border = 1>  
            <% String titleTable = (String)request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
            <tr>
                <th>CategoryID</th>
                <th>CategoryName</th>
                <th>Description</th>
                <th>Picture</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            <% Vector<Categories> vector = 
                    (Vector<Categories>)request.getAttribute("data");
            for (Categories cate : vector) {
            %>
            <tr>
                <td><%=cate.getCategoryID() %></td>
                <td><%=cate.getCategoryName()%></td>
                <td><%=cate.getDescription()%></td>
                <td><%=cate.getPicture()%></td>
                <td><a href="CategoriesController?service=updateCategory&cateid=<%=cate.getCategoryID()%>">Update</a></td>
                <td><a href="CategoriesController?service=deleteCategories&cateid=<%=cate.getCategoryID()%>" onclick="return confirmDelete()">Delete</a></td>s
            </tr>
            <%}%>
        </table>
    </body>
</html>
