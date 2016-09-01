<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.07.2016
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <h3><fmt:message key="company.title"/></h3>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Franchise</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${insuranceCompanyList}" var="company">
                <jsp:useBean id="company" scope="page" type="com.insurance.polismart.model.InsuranceCompany"/>
                <tr>
                    <th>${company.name}</th>
                    <th>${company.description}</th>
                    <th>${company.franchise}</th>
                    <th>${company.amount}</th>
                    <th><a href="insurance/id=${company.id}">Update</a></th>
                    <th><a href="insurance/id=${company.id}">Delete</a></th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="insurance/add"><fmt:message key="company.add"/></a>
</section>
</body>
</html>
