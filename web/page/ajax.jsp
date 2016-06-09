<%--
  Created by IntelliJ IDEA.
  User: raist
  Date: 2016/5/26
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <%--<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.js"></script>--%>
    <script type="text/javascript" src="../resources/jquery-2.2.4.js"></script>
</head>
<body>
<script>
    jQuery(function ($) {
        var urlStr = "<%=request.getContextPath()%>/account/get/<%=request.getParameter("id")%>.json";
        console.log(urlStr);
//        $.ajax({
//            method:"GET",
//            url:urlStr,
//            dataType:"json",
//            success:function(data,textStatus,jqXHR){
//                var account = data;
//                $("#account_id").val(account.id);
//                $("#account_name").val(account.name);
//                //noinspection JSUnresolvedVariable
//                $("#account_money").val(account.money);
//                console.log(textStatus);
//                console.log(jqXHR.getAllResponseHeaders());
//            }
//        });
        $.ajax({
            method:"GET",
            url:urlStr,
            dataType:"json"
        }).done(function(data){
            var account = data;
            $("#account_id").val(account.id);
            $("#account_name").val(account.name);
            //noinspection JSUnresolvedVariable
            $("#account_money").val(account.money);
        }).fail(function( xhr, status, errorThrown ) {
            alert( "Sorry, there was a problem!" );
            console.log( "Error: " + errorThrown );
            console.log( "Status: " + status );
            console.dir( xhr );
        }).always(function( xhr, status ) {
            alert( "The request is complete!" );
            console.log( "Status: " + status );
            console.dir( xhr );
        });
    })
</script>
<h1>Account Overview</h1>
<hr />
<div>
    <table>
        <tr>
            <td>ID</td>
            <td>
                <input id="account_id" type="text" name="id" title="id" disabled="disabled">
            </td>
        </tr>
        <tr>
            <td>NAME</td>
            <td>
                <input id="account_name" type="text" name="id" title="id" disabled="disabled">
            </td>
        </tr>
        <tr>
            <td>MONEY</td>
            <td>
                <input id="account_money" type="text" name="id" title="id" disabled="disabled">
            </td>
        </tr>
    </table>
</div>
</body>
</html>
