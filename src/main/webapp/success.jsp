<%@ page import="com.ming.po.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ming.po.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table border="1" width="100">
    <tr>
        <td>UserName</td>
        <td>OrderNum</td>
    </tr>
    <%
        User user = (User)request.getAttribute("userInfo");
    %>
        <tr>
            <td><%=user.getUserName()%></td>
            <td>
               <%
                List<Order> orderList = user.getOrderList();
                for (Iterator it = orderList.iterator(); it.hasNext();){
                    Order order = (Order) it.next();
               %>
                    <%=order.getOrderNum()%>
                <%}%>

            </td>
        </tr>
</table>
</body>
</html>
