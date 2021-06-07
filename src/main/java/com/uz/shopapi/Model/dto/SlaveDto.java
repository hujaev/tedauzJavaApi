package com.uz.shopapi.Model.dto;

public class SlaveDto {
    Integer id;
    Integer tovar_id;
    Integer asos_id;
    Integer user_id;
    String tovar_nom;
    Integer kol;
    Integer kol_in;
    Integer kol_ost;
    Integer kol_in_ost;
    Double summa;
    Double summa_in;
    Double summa_all;
    Double sotish;
    Double sotish_in;
    Double sena;
    Double sena_in;
    public SlaveDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTovar_id() {
        return tovar_id;
    }

    public void setTovar_id(Integer tovar_id) {
        this.tovar_id = tovar_id;
    }

    public Integer getAsos_id() {
        return asos_id;
    }

    public void setAsos_id(Integer asos_id) {
        this.asos_id = asos_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public Integer getKol_in() {
        return kol_in;
    }

    public void setKol_in(Integer kol_in) {
        this.kol_in = kol_in;
    }

    public Integer getKol_ost() {
        return kol_ost;
    }

    public void setKol_ost(Integer kol_ost) {
        this.kol_ost = kol_ost;
    }

    public Integer getKol_in_ost() {
        return kol_in_ost;
    }

    public void setKol_in_ost(Integer kol_in_ost) {
        this.kol_in_ost = kol_in_ost;
    }

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public Double getSumma_in() {
        return summa_in;
    }

    public void setSumma_in(Double summa_in) {
        this.summa_in = summa_in;
    }

    public Double getSumma_all() {
        return summa_all;
    }

    public void setSumma_all(Double summa_all) {
        this.summa_all = summa_all;
    }

    public Double getSotish() {
        return sotish;
    }

    public void setSotish(Double sotish) {
        this.sotish = sotish;
    }

    public Double getSotish_in() {
        return sotish_in;
    }

    public void setSotish_in(Double sotish_in) {
        this.sotish_in = sotish_in;
    }

    public Double getSena() {
        return sena;
    }

    public void setSena(Double sena) {
        this.sena = sena;
    }

    public Double getSena_in() {
        return sena_in;
    }

    public void setSena_in(Double sena_in) {
        this.sena_in = sena_in;
    }

    public SlaveDto(Integer id, Integer tovar_id, Integer asos_id, Integer user_id, String tovar_nom, Integer kol, Integer kol_in, Integer kol_ost, Integer kol_in_ost, Double summa, Double summa_in, Double summa_all, Double sotish,Double sotish_in, Double sena, Double sena_in) {
        this.id = id;
        this.tovar_id = tovar_id;
        this.asos_id = asos_id;
        this.user_id = user_id;
        this.tovar_nom = tovar_nom;
        this.kol = kol;
        this.kol_in = kol_in;
        this.kol_ost = kol_ost;
        this.kol_in_ost = kol_in_ost;
        this.summa = summa;
        this.summa_in = summa_in;
        this.summa_all = summa_all;
        this.sotish = sotish;
        this.sotish_in = sotish_in;
        this.sena = sena;
        this.sena_in = sena_in;
    }

}
