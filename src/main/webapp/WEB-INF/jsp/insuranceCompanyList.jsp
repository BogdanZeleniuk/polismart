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
                    <th><a href="rest/insurance/${company.id}"><fmt:message key="company.edit"/></a></th>
                    <th><a href="rest/insurance/${company.id}"><fmt:message key="company.delete"/></a></th>
                </tr>
            </c:forEach>
        </tbody>
    </table><br>
    <a href="insurance/add"><fmt:message key="company.add"/></a>
</section>
<jsp:include page="fragments/footer.jsp"/>
</center>
</body>
</html>
