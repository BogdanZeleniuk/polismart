<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.07.2016
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Insurance Company</title>
</head>
<body>
    <jsp:useBean id="company" scope="request" type="com.insurance.polismart.model.InsuranceCompany"></jsp:useBean>
        <form method="post" action="insurance">
            <table>
                <tbody>
                    <tr>
                        <th><input type="hidden" name="id" value="${company.id}"></th>
                    </tr>
                    <tr>
                        <th>Name:<input type="text" name="name" value="${company.name}"></th>
                    </tr>
                    <tr>
                        <th>Description:<input type="text" name="description" value="${company.description}"></th>
                    </tr>
                    <tr>
                        <th>Franchise:<input type="number" name="franchise" value="${company.franchise}"></th>
                    </tr>
                    <tr>
                        <th>Amount:<input type="number" name="amount" value="${company.amount}"></th>
                    </tr>
                    <tr>
                        <th><input type="submit">Ok</th>
                    </tr>
                </tbody>
            </table>
        </form>
</body>
</html>
