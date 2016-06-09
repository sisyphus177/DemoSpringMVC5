<%--
  Created by IntelliJ IDEA.
  User: raist
  Date: 2016/5/24
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
    <h1>Account Overview</h1>
    <hr />
    <div>
        <table>
            <tr>
                <td>ID</td>
                <td>
                    <input type="text" name="id" title="id" value="${account.id}" disabled="disabled">
                </td>
            </tr>
            <tr>
                <td>NAME</td>
                <td>
                    <input type="text" name="id" title="id" value="${account.name}" disabled="disabled">
                </td>
            </tr>
            <tr>
                <td>MONEY</td>
                <td>
                    <input type="text" name="id" title="id" value="${account.money}" disabled="disabled">
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
