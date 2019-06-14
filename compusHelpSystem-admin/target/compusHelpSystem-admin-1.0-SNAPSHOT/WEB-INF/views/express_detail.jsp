<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
    <div class="col-xs-6">
        <dl>
            <dt>订单编号：</dt>
            <dd>${express.expressDetail.express_detail_id}</dd>
            <br />

            <dt>发布者：</dt>
            <dd>${express.publish_id}</dd>
            <br />

            <dt>接受者：</dt>
            <dd>${express.accept_id}</dd>
            <br />

            <dt>订单状态：</dt>
            <dd>${express.order_status}</dd>
            <br />

            <dt>创建时间：</dt>
            <dd><fmt:formatDate value="${express.expressDetail.express_publishtime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
            <br />

            <dt>完成时间：</dt>
            <dd><fmt:formatDate value="${express.expressDetail.express_finishtime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
            <br />
        </dl>
    </div>

    <div class="col-xs-6">
        <dl>
            <dt>快递公司：</dt>
            <dd>${express.expressDetail.express_campany}</dd>
            <br />

            <dt>快递信息：</dt>
            <dd>${express.expressDetail.express_message}</dd>
            <br />

            <dt>预留电话：</dt>
            <dd>${express.expressDetail.express_phone}</dd>
            <br />

            <dt>送达地址：</dt>
            <dd>${express.expressDetail.express_site}</dd>
            <br />

            <dt>报 酬：</dt>
            <dd>¥ ${express.expressDetail.express_reward}</dd>
            <br />

            <dt>联系电话：</dt>
            <dd>${express.expressDetail.express_contact}</dd>
            <br />

            <dt>备 注：</dt>
            <dd>${express.expressDetail.express_note}</dd>
            <br />
        </dl>
    </div>
</div>