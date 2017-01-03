<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="headTag.jsp"/>
<body>
<div class="jumbotron">
        <div class="container">
            <a href="login"><strong><spring:message key="logout.home"/></strong></a>
            <br/> <br/> <br/>
               <h1><spring:message key="logout.text"/></h1>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
