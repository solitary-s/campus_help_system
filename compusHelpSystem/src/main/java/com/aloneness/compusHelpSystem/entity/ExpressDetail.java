package com.aloneness.compusHelpSystem.entity;

import java.io.Serializable;
import java.util.Date;

public class ExpressDetail implements Serializable{

    private String express_detail_id;
    private Date express_publishtime;
    private String express_campany;
    private String express_message;
    private String express_phone;
    private String express_site;
    private Float express_reward;
    private String express_contact;
    private String express_note;
    private Date express_finishtime;

    @Override
    public String toString() {
        return "ExpressDetail{" +
                "express_detail_id='" + express_detail_id + '\'' +
                ", express_publishtime=" + express_publishtime +
                ", express_campany='" + express_campany + '\'' +
                ", express_message='" + express_message + '\'' +
                ", express_phone='" + express_phone + '\'' +
                ", express_site='" + express_site + '\'' +
                ", express_reward=" + express_reward +
                ", express_contact='" + express_contact + '\'' +
                ", express_note='" + express_note + '\'' +
                ", express_finishtime=" + express_finishtime +
                '}';
    }

    public String getExpress_detail_id() {
        return express_detail_id;
    }

    public void setExpress_detail_id(String express_detail_id) {
        this.express_detail_id = express_detail_id;
    }

    public Date getExpress_publishtime() {
        return express_publishtime;
    }

    public void setExpress_publishtime(Date express_publishtime) {
        this.express_publishtime = express_publishtime;
    }

    public String getExpress_campany() {
        return express_campany;
    }

    public void setExpress_campany(String express_campany) {
        this.express_campany = express_campany;
    }

    public String getExpress_message() {
        return express_message;
    }

    public void setExpress_message(String express_message) {
        this.express_message = express_message;
    }

    public String getExpress_phone() {
        return express_phone;
    }

    public void setExpress_phone(String express_phone) {
        this.express_phone = express_phone;
    }

    public String getExpress_site() {
        return express_site;
    }

    public void setExpress_site(String express_site) {
        this.express_site = express_site;
    }

    public Float getExpress_reward() {
        return express_reward;
    }

    public void setExpress_reward(Float express_reward) {
        this.express_reward = express_reward;
    }

    public String getExpress_contact() {
        return express_contact;
    }

    public void setExpress_contact(String express_contact) {
        this.express_contact = express_contact;
    }

    public String getExpress_note() {
        return express_note;
    }

    public void setExpress_note(String express_note) {
        this.express_note = express_note;
    }

    public Date getExpress_finishtime() {
        return express_finishtime;
    }

    public void setExpress_finishtime(Date express_finishtime) {
        this.express_finishtime = express_finishtime;
    }
}
