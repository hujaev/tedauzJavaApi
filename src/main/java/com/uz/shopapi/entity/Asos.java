package com.uz.shopapi.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "asos")
@EntityListeners(AuditingEntityListener.class)
public class Asos implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column
    Integer client_id;

    @Column
    Integer user_id;
    @Column
    Integer h_id;

    @Column
    Integer xodim_id;

    @Column
    String sana;

    @Column

    Integer diler_id;

    @Column
    Integer tur_oper;

    @Column
    Double summa;

    @Column
    Integer sotuv_turi;
    @Column
    String nomer;
    @Column
    Integer del_flag;
    @Column
    Double kurs;
    @Column
    Double sum_d;
    @Column
    Integer  kol;
    @Column
    Integer  dollar;


    public Integer getSotuv_turi() {
        return sotuv_turi;
    }

    public void setSotuv_turi(Integer sotuv_turi) {
        this.sotuv_turi = sotuv_turi;
    }

    public Integer getH_id() {
        return h_id;
    }

    public void setH_id(Integer h_id) {
        this.h_id = h_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getXodim_id() {
        return xodim_id;
    }

    public void setXodim_id(Integer xodim_id) {
        this.xodim_id = xodim_id;
    }

    public String getSana() {
        return sana;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }

    public Integer getDiler_id() {
        return diler_id;
    }

    public void setDiler_id(Integer diler_id) {
        this.diler_id = diler_id;
    }

    public Integer getTur_oper() {
        return tur_oper;
    }

    public void setTur_oper(Integer tur_oper) {
        this.tur_oper = tur_oper;
    }

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public Double getKurs() {
        return kurs;
    }

    public void setKurs(Double kurs) {
        this.kurs = kurs;
    }

    public Double getSum_d() {
        return sum_d;
    }

    public void setSum_d(Double sum_d) {
        this.sum_d = sum_d;
    }

    public Integer getKol() {
        return kol;
    }

    public void setKol(Integer kol) {
        this.kol = kol;
    }

    public Integer getDollar() {
        return dollar;
    }

    public void setDollar(Integer dollar) {
        this.dollar = dollar;
    }
}
