package com.uz.shopapi.dto;

public class MainDto {

    Integer id;
    Integer status;
    Integer clientid;
    String serial;
    Integer qrkod;
    Integer tovar_id;
    String tovarnom;
    String text;
    String rasm;
    String ovoz;
    Integer tur_oper;
    Integer parent_id;
    Integer slave_id;

    public MainDto() {
    }

    public MainDto(Integer id, Integer status, Integer clientid, String serial, Integer qrkod, Integer tovar_id, String tovarnom, String text, String rasm, String ovoz, Integer tur_oper, Integer parent_id, Integer slave_id) {
        this.id = id;
        this.status = status;
        this.clientid = clientid;
        this.serial = serial;
        this.qrkod = qrkod;
        this.tovar_id = tovar_id;
        this.tovarnom = tovarnom;
        this.text = text;
        this.rasm = rasm;
        this.ovoz = ovoz;
        this.tur_oper = tur_oper;
        this.parent_id = parent_id;
        this.slave_id = slave_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getQrkod() {
        return qrkod;
    }

    public void setQrkod(Integer qrkod) {
        this.qrkod = qrkod;
    }

    public Integer getTovar_id() {
        return tovar_id;
    }

    public void setTovar_id(Integer tovar_id) {
        this.tovar_id = tovar_id;
    }

    public String getTovarnom() {
        return tovarnom;
    }

    public void setTovarnom(String tovarnom) {
        this.tovarnom = tovarnom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRasm() {
        return rasm;
    }

    public void setRasm(String rasm) {
        this.rasm = rasm;
    }

    public String getOvoz() {
        return ovoz;
    }

    public void setOvoz(String ovoz) {
        this.ovoz = ovoz;
    }

    public Integer getTur_oper() {
        return tur_oper;
    }

    public void setTur_oper(Integer tur_oper) {
        this.tur_oper = tur_oper;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getSlave_id() {
        return slave_id;
    }

    public void setSlave_id(Integer slave_id) {
        this.slave_id = slave_id;
    }

    @Override
    public String toString() {
        return "MainDto{" +
                "id=" + id +
                ", status=" + status +
                ", clientid=" + clientid +
                ", serial='" + serial + '\'' +
                ", qrkod=" + qrkod +
                ", tovar_id=" + tovar_id +
                ", tovarnom='" + tovarnom + '\'' +
                ", text='" + text + '\'' +
                ", rasm='" + rasm + '\'' +
                ", ovoz='" + ovoz + '\'' +
                ", tur_oper=" + tur_oper +
                ", parent_id=" + parent_id +
                ", slave_id=" + slave_id +
                '}';
    }
}
