package com.uz.shopapi.dto;

import javax.persistence.Column;

public class AsosSlaveDto {
    Integer id;

    Integer tovarId;

    Integer asosId;

    Integer userId;

    String tovar_nom;

    Integer kol;

    Integer kolIn;

    Integer kolOst;

    Integer kolInOst;

    Double summa;
    
    Double summaIn;
    
    Double summaAll;
    
    Double sotish;

    Double sotishIn;

    Double sena;

    Double senaIn;

    public AsosSlaveDto() {
    }

    public AsosSlaveDto(Integer id, Integer tovarId, Integer asosId, Integer userId, String tovar_nom, Integer kol, Integer kolIn, Integer kolOst, Integer kolInOst, Double summa, Double summaIn, Double summaAll, Double sotish, Double sena, Double senaIn) {
        this.id = id;
        this.tovarId = tovarId;
        this.asosId = asosId;
        this.userId = userId;
        this.tovar_nom = tovar_nom;
        this.kol = kol;
        this.kolIn = kolIn;
        this.kolOst = kolOst;
        this.kolInOst = kolInOst;
        this.summa = summa;
        this.summaIn = summaIn;
        this.summaAll = summaAll;
        this.sotish = sotish;
        this.sena = sena;
        this.senaIn = senaIn;
    }

    public Double getSotishIn() {
        return sotishIn;
    }

    public void setSotishIn(Double sotishIn) {
        this.sotishIn = sotishIn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTovarId() {
        return tovarId;
    }

    public void setTovarId(Integer tovarId) {
        this.tovarId = tovarId;
    }

    public Integer getAsosId() {
        return asosId;
    }

    public void setAsosId(Integer asosId) {
        this.asosId = asosId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTovar_nom() {
        return tovar_nom;
    }

    public void setTovar_nom(String tovar_nom) {
        this.tovar_nom = tovar_nom;
    }

    public Integer getKol() {
        return kol;
    }

    public void setKol(Integer kol) {
        this.kol = kol;
    }

    public Integer getKolIn() {
        return kolIn;
    }

    public void setKolIn(Integer kolIn) {
        this.kolIn = kolIn;
    }

    public Integer getKolOst() {
        return kolOst;
    }

    public void setKolOst(Integer kolOst) {
        this.kolOst = kolOst;
    }

    public Integer getKolInOst() {
        return kolInOst;
    }

    public void setKolInOst(Integer kolInOst) {
        this.kolInOst = kolInOst;
    }

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public Double getSummaIn() {
        return summaIn;
    }

    public void setSummaIn(Double summaIn) {
        this.summaIn = summaIn;
    }

    public Double getSummaAll() {
        return summaAll;
    }

    public void setSummaAll(Double summaAll) {
        this.summaAll = summaAll;
    }

    public Double getSotish() {
        return sotish;
    }

    public void setSotish(Double sotish) {
        this.sotish = sotish;
    }

    public Double getSena() {
        return sena;
    }

    public void setSena(Double sena) {
        this.sena = sena;
    }

    public Double getSenaIn() {
        return senaIn;
    }

    public void setSenaIn(Double senaIn) {
        this.senaIn = senaIn;
    }
}
