<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="webjars/datetimepicker/2.4.7/jquery.datetimepicker.css">

<body>
    <jsp:include page="fragments/bodyHeader.jsp"/>
        <center>
            <section>
                <h3><fmt:message key="users.title"/></h3>
                <hr>
                <table border="1" cellpadding="8" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Roles</th>
                        <th>Active</th>
                        <th>Registered</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user">
                        <jsp:useBean id="user" scope="page" type="com.insurance.polismart.model.User"/>
                        <tr>
                            <th>${user.name}</th>
                            <th>${user.email}</th>
                            <th>${user.roles}</th>
                            <th>
                                <input type="checkbox"
                                       <c:if test="${user.enabled}">checked</c:if> id="${user.id}"/>
                            </th>
                            <th><fmt:formatDate value="${user.registered}" pattern="dd-MMMM-yyyy"/></th>
                            <th><a href="rest/admin/users/${user.id}"><fmt:message key="users.edit"/></a></th>
                            <th><a href="rest/admin/users/${user.id}"><fmt:message key="users.delete"/></a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table><br>
                <a href="/rest/admin/users/add"><fmt:message key="users.add"/></a>
            </section>
            <jsp:include page="fragments/footer.jsp"/>
        </center>
</body>
</html>
