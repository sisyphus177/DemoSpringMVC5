<%--
  Created by IntelliJ IDEA.
  User: raist
  Date: 2016/5/24
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer</title>
</head>
<body>
<h1>Transfer Money</h1>
<hr>
<form action="${pageContext.request.contextPath}/account/doTransfer" name="transferForm" method="post">
    <table>
        <tr>
            <td>From</td>
            <td>
                <input type="text" name="fromAccount" title="from">
            </td>
        </tr>
        <tr>
            <td>To</td>
            <td>
                <input type="text" name="toAccount" title="to">
            </td>
        </tr>
        <tr>
            <td>Money</td>
            <td>
                <input type="text" name="transferMoney" title="money">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
