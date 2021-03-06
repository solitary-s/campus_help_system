<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <title>后台管理系统 | 快递管理</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp" />
    <jsp:include page="../includes/menu.jsp" />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                快递管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">编辑快递订单</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/express/update" method="post" modelAttribute="express">
                            <%--<form:hidden path="id" />--%>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="expressDetail.express_detail_id" class="col-sm-2 control-label">订单编号</label>
                                    <div class="col-sm-10">
                                        <form:input readonly="true" cssClass="form-control" path="expressDetail.express_detail_id"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="publish_id" class="col-sm-2 control-label">发布者</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="publish_id" placeholder="请输入发布者" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="order_status" class="col-sm-2 control-label">订单状态</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="order_status" placeholder="请输入订单状态" />
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label for="expressDetail.express_campany" class="col-sm-2 control-label">快递公司</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="expressDetail.express_campany" placeholder="请输入快递公司" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="expressDetail.express_message" class="col-sm-2 control-label">快递信息</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="expressDetail.express_message" placeholder="请输入快递信息" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="expressDetail.express_phone" class="col-sm-2 control-label">预留电话</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="expressDetail.express_phone" placeholder="请输入预留电话" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="expressDetail.express_site" class="col-sm-2 control-label">送达地址</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="expressDetail.express_site" placeholder="请输入送达地址" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="expressDetail.express_reward" class="col-sm-2 control-label">报酬</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="expressDetail.express_reward" placeholder="请输入报酬" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="expressDetail.express_contact" class="col-sm-2 control-label">联系电话</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="expressDetail.express_contact" placeholder="请输入联系电话" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="expressDetail.express_note" class="col-sm-2 control-label">备注</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="expressDetail.express_note" placeholder="请输入备注" />
                                    </div>
                                </div>

                            </div>

                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp" />
</div>

<jsp:include page="../includes/footer.jsp" />
</body>
</html>