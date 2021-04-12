package com.uz.shopapi.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "main")
@EntityListeners(AuditingEntityListener.class)

public class Main implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    @Column(name = "status")
    private Integer status;
    @Column(name = "clientid")
    private Integer clientid;
    @Column(name = "serial")
    private  String serial;
    @Column(name = "qrkod")
    private Integer qrkod;
    @Column(name = "tovar_id")
    private Integer tovar_id;
    @Column(name = "tovarnom")
    private  String tovarnom;
    @Column(name = "text")
    private  String text;
    @Column(name = "rasm")
    private String rasm;
    @Column(name = "ovoz")
    private String ovoz;
    @Column(name = "tur_oper")
    private  Integer tur_oper;
    @Column(name = "parent_id")
    private Integer parent_id;
    @Column(name = "slave_id")
    private Integer slave_id;

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
}
