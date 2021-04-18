package com.uz.shopapi.dto;


public class AsosDto {

    Integer id;
    Integer client_id;
    Integer userId;
    Integer xodimId;
    Integer haridorId;
    String  sana;
    Integer dilerId;
    Integer turOper;
    Double summa;
    Integer sotuvTuri;
    String nomer;
    Integer del_flag;
    Integer dollar;
    Double  kurs;
    Double  sum_d;
    Integer kol;


    public AsosDto() {
    }

    public AsosDto(Integer id, Integer client_id, Integer userId, Integer xodimId, Integer haridorId, String sana, Integer dilerId, Integer turOper, Double summa, Integer sotuvTuri, String nomer, Integer del_flag, Integer dollar, Double kurs, Double sum_d, Integer kol) {
        this.id = id;
        this.client_id = client_id;
        this.userId = userId;
        this.xodimId = xodimId;
        this.haridorId = haridorId;
        this.sana = sana;
        this.dilerId = dilerId;
        this.turOper = turOper;
        this.summa = summa;
        this.sotuvTuri = sotuvTuri;
        this.nomer = nomer;
        this.del_flag = del_flag;
        this.dollar = dollar;
        this.kurs = kurs;
        this.sum_d = sum_d;
        this.kol = kol;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSotuvTuri() {
        return sotuvTuri;
    }

    public void setSotuvTuri(Integer sotuvTuri) {
        this.sotuvTuri = sotuvTuri;
    }

    public Integer getHaridorId() {
        return haridorId;
    }

    public void setHaridorId(Integer haridorId) {
        this.haridorId = haridorId;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getXodimId() {
        return xodimId;
    }

    public void setXodimId(Integer xodimId) {
        this.xodimId = xodimId;
    }

    public String getSana() {
        return sana;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }

    public Integer getDilerId() {
        return dilerId;
    }

    public void setDilerId(Integer dilerId) {
        this.dilerId = dilerId;
    }

    public Integer getTurOper() {
        return turOper;
    }

    public void setTurOper(Integer turOper) {
        this.turOper = turOper;
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

    public Integer getDollar() {
        return dollar;
    }

    public void setDollar(Integer dollar) {
        this.dollar = dollar;
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
}
