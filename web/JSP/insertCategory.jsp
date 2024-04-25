
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
    </head>
    <body>
        <form action="CategoriesController" method="post">
            <table>
                <tr>
                    <td>CategoryName</td>
                    <td><input type="text" name="CategoryName" id=""></td>
                </tr>           
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="Description" id=""></td>
                </tr>
                <tr>
                    <td>Picture</td>
                    <td><input type="text" name="Picture" id=""></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="insert Category"></td>
                    <td><input type="reset" value="reset">
                        <input type="hidden" name="service" value="insertCategory">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
