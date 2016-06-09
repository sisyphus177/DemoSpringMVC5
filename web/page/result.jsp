<%--
  Created by IntelliJ IDEA.
  User: raist
  Date: 2016/5/24
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Transfer Result</h1>
<hr />
<div>
    <table>
        <tr>
            <td>ID</td>
            <td>
                <input type="text" name="id" title="id" value="${fromAccount.id}" disabled="disabled">
            </td>
        </tr>
        <tr>
            <td>NAME</td>
            <td>
                <input type="text" name="id" title="id" value="${fromAccount.name}" disabled="disabled">
            </td>
        </tr>
        <tr>
            <td>MONEY</td>
            <td>
                <input type="text" name="id" title="id" value="${fromAccount.money}" disabled="disabled">
            </td>
        </tr>
    </table>
</div>
<hr />
<div>
    <table>
        <tr>
            <td>ID</td>
            <td>
                <input type="text" name="id" title="id" value="${toAccount.id}" disabled="disabled">
            </td>
        </tr>
        <tr>
            <td>NAME</td>
            <td>
                <input type="text" name="id" title="id" value="${toAccount.name}" disabled="disabled">
            </td>
        </tr>
        <tr>
            <td>MONEY</td>
            <td>
                <input type="text" name="id" title="id" value="${toAccount.money}" disabled="disabled">
            </td>
        </tr>
    </table>
</div>
</body>
</html>
