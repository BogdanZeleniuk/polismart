<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31.07.2016
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<form method="post" action="users">
    <fmt:message key="app.login"/>: <select name="userId">
        <option value="1">User</option>
        <option value="2">Admin</option>
    </select>
    <button type="submit"><fmt:message key="common.select"/></button>
</form>
<ul>
    <li><a href="users"><fmt:message key="users.title"/></a></li>
    <li><a href="meals"><fmt:message key="company.title"/></a></li>
</ul>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
