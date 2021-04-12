package com.uz.shopapi.Request;

public class RequestMainSlave {

    private Integer slave_id;
    private String serial;

    public RequestMainSlave() {
    }

    public Integer getSlave_id() {
        return slave_id;
    }

    public void setSlave_id(Integer slave_id) {
        this.slave_id = slave_id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
