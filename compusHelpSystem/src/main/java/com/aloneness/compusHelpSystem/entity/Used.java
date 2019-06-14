package com.aloneness.compusHelpSystem.entity;

import java.io.Serializable;

public class Used implements Serializable{

    private String used_id;
    private String publish_id;
    private String accept_id;
    private Integer order_type;
    private Integer order_status;
    private UsedDetail usedDetail;

    @Override
    public String toString() {
        return "Used{" +
                "used_id='" + used_id + '\'' +
                ", publish_id='" + publish_id + '\'' +
                ", accept_id='" + accept_id + '\'' +
                ", order_type=" + order_type +
                ", order_status=" + order_status +
                ", usedDetail=" + usedDetail +
                '}';
    }

    public String getUsed_id() {
        return used_id;
    }

    public void setUsed_id(String used_id) {
        this.used_id = used_id;
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

    public UsedDetail getUsedDetail() {
        return usedDetail;
    }

    public void setUsedDetail(UsedDetail usedDetail) {
        this.usedDetail = usedDetail;
    }
}
