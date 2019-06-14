<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

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

                    <div class="box box-info box-info-search" style="display: none;">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>

                        <div class="box-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="publish_id" class="col-sm-4 control-label">发布者</label>

                                        <div class="col-sm-8">
                                            <input id="publish_id" class="form-control" placeholder="手机账号" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="accept_id" class="col-sm-4 control-label">接受者</label>

                                        <div class="col-sm-8">
                                            <input id="accept_id" class="form-control" placeholder="手机账号" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="express_detail_id" class="col-sm-4 control-label">订单编号</label>

                                        <div class="col-sm-8">
                                            <input id="express_detail_id" class="form-control" placeholder="订单编号" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                        </div>
                    </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">快递列表</h3>
                        </div>

                        <div class="box-body">
                            <button type="button" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')"><i class="fa fa-search"></i> 搜索</button>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master" /></th>
                                    <th>订单编号ID</th>
                                    <th>发布者</th>
                                    <th>接受者</th>
                                    <th>订单状态</th>
                                    <th>物流公司</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp" />
</div>

<jsp:include page="../includes/footer.jsp" />

<!-- 自定义模态框 -->
<sys:modal />

<script>
    var _dataTable;

    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.account + '" type="checkbox" class="minimal" />';
                }
            },
            {"data": "expressDetail.express_detail_id"},
            {"data": "publish_id"},
            {"data": "accept_id"},
            {"data": "order_status"},
            {"data": "expressDetail.express_campany"},
            {"data": "expressDetail.express_publishtime",
                "render" : function(data, type, full, meta) {
                    return moment(data).format("YYYY-MM-DD HH:mm:ss");
                }
            },
            {
                "data": function (row, type, val, meta) {
                    var detailUrl = "/express/detail?express_detail_id=" + row.expressDetail.express_detail_id;
                    var deleteUrl = "/express/delete";
                    return '<button type="button" class="btn btn-sm btn-default" onclick="App.showDetail(\'' + detailUrl + '\');"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;' +
                        '<a href="/express/formUpdate?express_detail_id=' + row.expressDetail.express_detail_id + '" type="button" class="btn btn-sm btn-primary">' +
                        '<i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;' +
                        '<button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle(\'' + deleteUrl + '\', \'' + row.expressDetail.express_detail_id+ '\')">' +
                        '<i class="fa fa-trash-o"></i> 删除</button>';
                }
            }
        ];
        _dataTable = App.initDataTables("/express/page", _columns);
    });

    function search() {
        var publish_id = $("#publish_id").val();
        var accept_id = $("#accept_id").val();
        var express_detail_id = $("#express_detail_id").val();

        var param = {
            "publish_id": publish_id,
            "accept_id": accept_id,
            "express_detail_id": express_detail_id
        };

        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>
</body>
</html>