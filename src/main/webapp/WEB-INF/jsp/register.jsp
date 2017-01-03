<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="polismart" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="headTag.jsp"/>
<body>
<div class="jumbotron">
<div class="container">
    <div class="shadow">
        <jsp:include page="lang.jsp"/>
        <ul class="nav navbar-nav navbar-left">
            <li>
                <h4><spring:message code="register.title"/></h4>
                <br/>
                <c:url value="/j_spring_security_check" var="loginUrl"/>
                <form:form class="form-horizontal" role="form" action="${loginUrl}"
                           method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="username"><spring:message code="register.email"/></label>
                        <div class="col-sm-10">
                            <input type="text" placeholder="Login" class="form-control" name='username' id="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="password"><spring:message code="register.password"/></label>
                        <div class="col-sm-10">
                            <input type="password" placeholder="Password" class="form-control" name='password' id="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-3">
                            <button type="submit" class="btn btn-info"><spring:message code="register.save"/></button>
                        </div>
                    </div>
                </form:form>
            </li>
        </ul>
    </div>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <div class="nav navbar-nav navbar-left">
            <h4><spring:message code="register.regTitle"/></h4>
            <br/>
            <div class="view-box">
                <form:form modelAttribute="userDTO" class="form-horizontal" method="post"
                           action="register" charset="utf-8"
                           accept-charset="UTF-8">

                    <polismart:inputField label="Name" name="name"/>
                    <polismart:inputField label="Email" name="email"/>
                    <polismart:inputField label="Password" name="password" inputType="password"/>

                    <div class="form-group">
                        <div class="col-sm-9">
                            <button type="submit" class="btn btn-info"><spring:message code="users.add"/></button>
                        </div>
                    </div>
                </form:form>
            </div>
                </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>