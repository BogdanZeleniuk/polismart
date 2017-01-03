<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <a href="insurance" class="navbar-brand"><spring:message code="app.title"/></a>

        <div class="collapse navbar-collapse">
            <form class="navbar-form navbar-right">
                <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a class="btn btn-info" role="button" href="users"><spring:message code="users.title"/></a>
                    </sec:authorize>
                        <a class="btn btn-info" role="button">${userDTO.name} <spring:message code="users.profile"/></a>
                        <a class="btn btn-primary" role="button" href="<c:url value="/logout"/>"><spring:message code="app.logout"/></a>
                </sec:authorize>
            </form>
            <jsp:include page="lang.jsp"/>
        </div>
    </div>
</div>