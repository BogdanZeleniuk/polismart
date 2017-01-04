<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="webjars/datetimepicker/2.4.7/jquery.datetimepicker.css">

<body>
<jsp:include page="bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><spring:message code="company.title"/></h3>

            <div class="view-box">
                <form:form method="post" class="form-horizontal" role="form" id="filterByData">
                    <div class="form-group">

                        <label class="control-label col-sm-2" for="minAmount"><spring:message code="insurance.minAmount"/></label>

                        <div class="col-sm-3">
                            <input type="number" class="form-control" name="minAmount" id="minAmount" placeholder="from 0">
                        </div>

                        <label class="control-label col-sm-2" for="maxAmount"><spring:message code="insurance.maxAmount"/></label>

                        <div class="col-sm-3">
                            <input type="number" class="form-control" name="maxAmount" id="maxAmount" placeholder="to 5000">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="minFranchise"><spring:message code="insurance.minFranchise"/></label>

                        <div class="col-sm-3">
                            <input type="number" class="form-control" name="minFranchise" id="minFranchise" placeholder=" from 0">
                        </div>

                        <label class="control-label col-sm-2" for="maxFranchise"><spring:message code="insurance.maxFranchise"/></label>

                        <div class="col-sm-3">
                            <input type="number" class="form-control" name="maxFranchise" id="maxFranchise" placeholder="to 5000">
                        </div>
                    </div>
                    <div class="radio">
                    <label class="radio-inline">
                        <input type="radio" name="population" value="Kiev"><spring:message code="insurance.kiev"/><br/>
                        <input type="radio" name="population" value="Kiev district"><spring:message code="insurance.kievDistrict"/><br/>
                        <input type="radio" name="population" value="more than 1 million"><spring:message code="insurance.moreOneMillion"/><br/>
                        <input type="radio" name="population" value="to 1 million"><spring:message code="insurance.toOneMillion"/><br/>
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="population" value="to half of 1 million"><spring:message code="insurance.toHalfAMillion"/><br/>
                        <input type="radio" name="population" value="more than 100 thousand"><spring:message code="insurance.moreOneHundred"/><br/>
                        <input type="radio" name="population" value="to 100 thousand"><spring:message code="insurance.toOneHundred"/><br/>
                        <input type="radio" name="population" value="other"><spring:message code="insurance.other"/><br/>
                    </label>
                    </div>
                    <div class="radio">
                        <label class="radio-inline">
                            <input type="radio" name="engine_power" value="more than 3.0"><spring:message code="insurance.engineThree"/><br/>
                            <input type="radio" name="engine_power" value="more than 2.0"><spring:message code="insurance.engineTwo"/><br/>
                            <input type="radio" name="engine_power" value="more than 1.6"><spring:message code="insurance.engineOne"/><br/>
                            <input type="radio" name="engine_power" value="to 1.6"><spring:message code="insurance.engineToOne"/><br/>
                        </label>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8">
                            <button type="submit" class="btn btn-primary pull-right"><spring:message code="insurance.filter"/></button>
                        </div>
                    </div>
                </form:form>
                <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a class="btn btn-sm btn-info" onclick="add()"><spring:message code="company.add"/></a>
                    </sec:authorize>
                </sec:authorize>
                        <table class="table table-striped display" id="datatable">
                            <thead>
                            <tr>
                                <th><spring:message code="insurance.tableContent"/></th>
                                <th><spring:message code="insurance.tableName"/></th>
                                <th><spring:message code="insurance.tableDescription"/></th>
                                <th><spring:message code="insurance.tableFranchise"/></th>
                                <th><spring:message code="insurance.tablePopulation"/></th>
                                <th><spring:message code="insurance.tableEngine_Power"/></th>
                                <th><spring:message code="insurance.tableAmount"/></th>
                                <th></th>
                                <th></th>
                            </tr>
                            </thead>
                        </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title"><spring:message code="company.add"/></h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="content" class="control-label col-xs-3"><spring:message code="insurance.tableContent"/></label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="content" name="content" placeholder="Logotype">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3"><spring:message code="insurance.tableName"/></label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="control-label col-xs-3"><spring:message code="insurance.tableDescription"/></label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="description" name="description"
                                   placeholder="Description">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="franchise" class="control-label col-xs-3"><spring:message code="insurance.tableFranchise"/></label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="franchise" name="franchise"
                                   placeholder="1000">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="population" class="control-label col-sm-3"><spring:message code="insurance.tablePopulation"/></label>

                        <div class="radio-inline">
                            <input type="radio" class="col-xs-2" id="population" name="population" value="Kiev"><spring:message code="insurance.kiev"/><br/>
                            <input type="radio" class="col-xs-2" id="population" name="population" value="Kiev district"><spring:message code="insurance.kievDistrict"/><br/>
                            <input type="radio" class="col-xs-2" id="population" name="population" value="more than 1 million"><spring:message code="insurance.moreOneMillion"/><br/>
                            <input type="radio" class="col-xs-2" id="population" name="population" value="to 1 million"><spring:message code="insurance.toOneMillion"/><br/>
                        </div>
                        <div class="radio-inline">
                            <input type="radio" class="col-xs-2" id="population" name="population" value="to half of 1 million"><spring:message code="insurance.toHalfAMillion"/><br/>
                            <input type="radio" class="col-xs-2" id="population" name="population" value="more than 100 thousand"><spring:message code="insurance.moreOneHundred"/><br/>
                            <input type="radio" class="col-xs-2" id="population" name="population" value="to 100 thousand"><spring:message code="insurance.toOneHundred"/><br/>
                            <input type="radio" class="col-xs-2" id="population" name="population" value="other"><spring:message code="insurance.other"/><br/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="engine_power" class="control-label col-xs-3"><spring:message code="insurance.tableEngine_Power"/></label>

                        <div class="radio-inline">
                            <input type="radio" class="col-xs-2" id="engine_power" name="engine_power" value="more than 3.0"><spring:message code="insurance.engineThree"/><br/>
                            <input type="radio" class="col-xs-2" id="engine_power" name="engine_power" value="more than 2.0"><spring:message code="insurance.engineTwo"/><br/>
                            <input type="radio" class="col-xs-2" id="engine_power" name="engine_power" value="more than 1.6"><spring:message code="insurance.engineOne"/><br/>
                            <input type="radio" class="col-xs-2" id="engine_power" name="engine_power" value="to 1.6"><spring:message code="insurance.engineToOne"/><br/>>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="amount" class="control-label col-xs-3"><spring:message code="insurance.tableAmount"/></label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="amount" name="amount"
                                   placeholder="1296">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary"><spring:message code="insurance.save"/></button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="webjars/datetimepicker/2.4.7/build/jquery.datetimepicker.full.min.js"></script>
<script type="text/javascript" src="js/utilDT.js"></script>
<script type="text/javascript" src="js/companyDT.js"></script>
</html>
