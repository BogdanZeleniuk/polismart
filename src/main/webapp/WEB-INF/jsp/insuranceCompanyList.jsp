<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">

<body>
<jsp:include page="bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><fmt:message key="company.title"/></h3>

            <div class="view-box">
                <form:form method="post" class="form-horizontal" role="form" id="filterByData">
                    <div class="form-group">

                        <label class="control-label col-sm-2" for="minAmount">Minimal amount:</label>

                        <div class="col-sm-3">
                            <input type="number" class="form-control" name="minAmount" id="minAmount" placeholder="from 0">
                        </div>

                        <label class="control-label col-sm-2" for="maxAmount">Maximal amount:</label>

                        <div class="col-sm-3">
                            <input type="number" class="form-control" name="maxAmount" id="maxAmount" placeholder="to 5000">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="minFranchise">Minimal franchise:</label>

                        <div class="col-sm-3">
                            <input type="number" class="form-control" name="minFranchise" id="minFranchise" placeholder=" from 0">
                        </div>

                        <label class="control-label col-sm-2" for="maxFranchise">Maximal Franchise:</label>

                        <div class="col-sm-3">
                            <input type="number" class="form-control" name="maxFranchise" id="maxFranchise" placeholder="to 5000">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8">
                            <button type="submit" class="btn btn-primary pull-right">Filter</button>
                        </div>
                    </div>
                </form:form>
                <a class="btn btn-sm btn-info" onclick="add()"><fmt:message key="company.add"/></a>
                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Franchise</th>
                        <th>Amount</th>
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
                <h2 class="modal-title"><spring:message code="company.edit"/></h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="control-label col-xs-3">Description</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="description" name="description"
                                   placeholder="Description">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="franchise" class="control-label col-xs-3">Franchise</label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="franchise" name="franchise"
                                   placeholder="1000">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="amount" class="control-label col-xs-3">Amount</label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="amount" name="amount"
                                   placeholder="1296">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
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
<script type="text/javascript" src="resources_webapp/js/utilDT.js"></script>
<script type="text/javascript" src="resources_webapp/js/companyDT.js"></script>
</html>
