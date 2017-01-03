<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="headTag.jsp"/>
<body>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
            <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <c:url value="/j_spring_security_check" var="loginUrl"/>
                    <form:form class="navbar-form" role="form" action="${loginUrl}"
                         method="post">
                        <div class="form-group">
                            <label for="username"><spring:message code="startPage.Email"/></label>
                            <div class="col-sm-3">
                                <input type="text" placeholder="Login" class="form-control" name="username" id="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password"><spring:message code="startPage.Password"/></label>
                            <div class="col-sm-3">
                                <input type="password" placeholder="Password" class="form-control" name="password" id="password">
                            </div>
                        </div>
                        <div class="form-group">
                        <button type="submit" class="btn btn-success"><spring:message code="startPage.login"/></button>
                        </div>
                    </form:form>
                    <br/>
                    <form class="navbar-form">
                            <a class="btn btn-sm btn-block btn-primary" role="button" href="register"><spring:message code="startPage.Register"/></a>
                    </form>
                </li>
                </ul>
                <jsp:include page="lang.jsp"/>
            </div>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <br/><br/>
        <c:if test="${error eq true}">
            <div class="error">
                <br/><br/>
                    <spring:message code="duplicate.login"/>
            </div>
        </c:if>
        <c:if test="${error eq false}">
            <div class="error">
            </div>
        </c:if>
        <c:if test="${not empty message}">
            <br/><br/>
            <div class="message">
                <spring:message code="${message}"/>
            </div>
        </c:if>

        <p>
        <br/>
        <h5><spring:message code="startPage.userEmailTest"/></h5>
        <h5><spring:message code="startPage.userPasswordTest"/></h5>
        ------------------------------
        <h5><spring:message code="startPage.adminEmailTest"/></h5>
        <h5><spring:message code="startPage.adminPasswordTest"/></h5>

        <p><spring:message code="startPage.technologies"/>
            <a href="http://projects.spring.io/">Spring IoC</a>,
            <a href="https://docs.spring.io/spring/docs/current/spring.../jdbc.html/">Spring JDBC</a>,
            <a href="http://projects.spring.io/spring-security/">Spring Security</a>,
            <a href="http://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>,
            <a href="http://spring.io/blog/2014/05/07/preview-spring-security-test-method-security">Spring Security
                Test</a>,
            <a href="https://projects.spring.io/spring-boot/">Spring Boot</a>,
            <a href="https://spring.io/guides/gs/rest-service/">Spring REST</a>,
            <a href="http://hibernate.org/orm/">Hibernate ORM</a>,
            <a href="http://hibernate.org/validator/">Hibernate Validator</a>,
            <a href="http://www.slf4j.org/">SLF4J</a>,
            <a href="https://github.com/FasterXML/jackson">Json Jackson</a>,
            <a href="http://ru.wikipedia.org/wiki/JSP">JSP</a>,
            <a href="http://en.wikipedia.org/wiki/JavaServer_Pages_Standard_Tag_Library">JSTL</a>,
            <a href="http://tomcat.apache.org/">Apache Tomcat</a>,
            <a href="http://www.webjars.org/">WebJars</a>,
            <a href="http://datatables.net/">DataTables plugin</a>,
            <a href="http://www.postgresql.org/">PostgreSQL</a>,
            <a href="https://www.mongodb.com/">MongoDB</a>,
            <a href="http://junit.org/">JUnit</a>,
            <a href="http://jquery.com/">jQuery</a>,
            <a href="http://ned.im/noty/">jQuery notification</a>,
            <a href="http://getbootstrap.com/">Bootstrap</a>.</p>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>