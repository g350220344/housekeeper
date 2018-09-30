package com.cindata.housekeeper.web.model;

import java.util.Date;

public class PvUvInfo {
    private String id;

    private String userid;

    private String type;

    private String ip;

    private Date puvdate;

    private String groupid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getPuvdate() {
        return puvdate;
    }

    public void setPuvdate(Date puvdate) {
        this.puvdate = puvdate;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }
}