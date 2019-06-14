<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
    <div class="col-xs-6">
        <dl>
            <dt>订单编号：</dt>
            <dd>${used.usedDetail.used_detail_id}</dd>
            <br />

            <dt>发布者：</dt>
            <dd>${used.publish_id}</dd>
            <br />

            <dt>接受者：</dt>
            <dd>${used.accept_id}</dd>
            <br />

            <dt>订单状态：</dt>
            <dd>${used.order_status}</dd>
            <br />

            <dt>创建时间：</dt>
            <dd><fmt:formatDate value="${used.usedDetail.used_publishtime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
            <br />

            <dt>完成时间：</dt>
            <dd><fmt:formatDate value="${used.usedDetail.used_finishtime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
            <br />
        </dl>
    </div>

    <div class="col-xs-6">
        <dl>
            <dt>二手物品：</dt>
            <dd>${used.usedDetail.used_title}</dd>
            <br />

            <dt>具体信息：</dt>
            <dd>${used.usedDetail.used_message}</dd>
            <br />

            <dt>出售价格：</dt>
            <dd>¥ ${used.usedDetail.used_price}</dd>
            <br />

            <dt>联系方式：</dt>
            <dd>${used.usedDetail.used_contact}</dd>
            <br />

            <dt>备 注：</dt>
            <dd>${used.usedDetail.used_note}</dd>
            <br />

            <dt>图 片：</dt>
            <dd><img src="http://localhost:8080/uploads/${used.usedDetail.used_img}" class="img-responsive"></dd>
            <br />
        </dl>
    </div>
</div>