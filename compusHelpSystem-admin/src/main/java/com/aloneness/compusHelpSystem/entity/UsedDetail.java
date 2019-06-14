package com.aloneness.compusHelpSystem.entity;

import java.io.Serializable;
import java.util.Date;

public class UsedDetail implements Serializable{

    private String used_detail_id;
    private Date used_publishtime;
    private String used_title;
    private String used_message;
    private String used_contact;
    private Float used_price;
    private String used_note;
    private String used_img;
    private Date used_finishtime;

    @Override
    public String toString() {
        return "UsedDetail{" +
                "used_detail_id='" + used_detail_id + '\'' +
                ", used_publishtime=" + used_publishtime +
                ", used_title='" + used_title + '\'' +
                ", used_message='" + used_message + '\'' +
                ", used_contact='" + used_contact + '\'' +
                ", used_price=" + used_price +
                ", used_note='" + used_note + '\'' +
                ", used_img='" + used_img + '\'' +
                ", used_finishtime=" + used_finishtime +
                '}';
    }

    public String getUsed_detail_id() {
        return used_detail_id;
    }

    public void setUsed_detail_id(String used_detail_id) {
        this.used_detail_id = used_detail_id;
    }

    public Date getUsed_publishtime() {
        return used_publishtime;
    }

    public void setUsed_publishtime(Date used_publishtime) {
        this.used_publishtime = used_publishtime;
    }

    public String getUsed_title() {
        return used_title;
    }

    public void setUsed_title(String used_title) {
        this.used_title = used_title;
    }

    public String getUsed_message() {
        return used_message;
    }

    public void setUsed_message(String used_message) {
        this.used_message = used_message;
    }

    public String getUsed_contact() {
        return used_contact;
    }

    public void setUsed_contact(String used_contact) {
        this.used_contact = used_contact;
    }

    public Float getUsed_price() {
        return used_price;
    }

    public void setUsed_price(Float used_price) {
        this.used_price = used_price;
    }

    public String getUsed_note() {
        return used_note;
    }

    public void setUsed_note(String used_note) {
        this.used_note = used_note;
    }

    public String getUsed_img() {
        return used_img;
    }

    public void setUsed_img(String used_img) {
        this.used_img = used_img;
    }

    public Date getUsed_finishtime() {
        return used_finishtime;
    }

    public void setUsed_finishtime(Date used_finishtime) {
        this.used_finishtime = used_finishtime;
    }
}
