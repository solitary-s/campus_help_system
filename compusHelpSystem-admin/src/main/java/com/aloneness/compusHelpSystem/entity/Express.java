package com.aloneness.compusHelpSystem.entity;

import com.aloneness.compusHelpSystem.persistence.BaseEntity;

import java.io.Serializable;

public class Express extends BaseEntity implements Serializable {

    private Integer express_id;
    private String publish_id;
    private String accept_id;
    private Integer order_type;
    private Integer order_status;
    private ExpressDetail expressDetail;

    @Override
    public String toString() {
        return "Express{" +
                "express_id=" + express_id +
                ", publish_id='" + publish_id + '\'' +
                ", accept_id='" + accept_id + '\'' +
                ", order_type=" + order_type +
                ", order_status=" + order_status +
                ", expressDetail=" + expressDetail +
                '}';
    }

    public Integer getExpress_id() {
        return express_id;
    }

    public void setExpress_id(Integer express_id) {
        this.express_id = express_id;
    }

    public String getPublish_id() {
        return publish_id;
    }

    public void setPublish_id(String publish_id) {
        this.publish_id = publish_id;
    }

    public String getAccept_id() {
        return accept_id;
    }

    public void setAccept_id(String accept_id) {
        this.accept_id = accept_id;
    }

    public Integer getOrder_type() {
        return order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public ExpressDetail getExpressDetail() {
        return expressDetail;
    }

    public void setExpressDetail(ExpressDetail expressDetail) {
        this.expressDetail = expressDetail;
    }
}
