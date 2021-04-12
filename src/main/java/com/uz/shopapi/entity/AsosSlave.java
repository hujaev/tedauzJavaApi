package com.uz.shopapi.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "asos_slave")
@EntityListeners(AuditingEntityListener.class)
public class AsosSlave implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    @Column
    Integer tovar_id;

    @Column
    Integer asos_id;

    @Column
    Integer user_id;

    @Column
    String tovar_nom;

    @Column
    Integer kol;
    @Column
    Integer kol_in;

    @Column
    Integer kol_ost;

    @Column
    Integer kol_in_ost;

    @Column
    Double summa;

    @Column
    Double summa_in;

    @Column
    Double summa_all;

    @Column
    Double sotish;
    @Column
    Double sotish_in;

    @Column
    Double sena;

    @Column
    Double sena_in;
// asos_id,del_flag,kol_ost,kol_in_ost,suma_all_ost,zakaz_si

    @Column
    Integer turi;

    @Column
    Integer subkod;
    @Column
    Integer del_flag;

    @Column
    Double summa_all_ost;

    @Column
    Double zakaz_see;

    @Column
    Integer resept;

    @Column
    Integer izm_id;
    @Column
    Integer izm1;




    public AsosSlave() {
    }

    public Integer getIzm_id() {
        return izm_id;
    }

    public void setIzm_id(Integer izm_id) {
        this.izm_id = izm_id;
    }

    public Integer getIzm1() {
        return izm1;
    }

    public void setIzm1(Integer izm1) {
        this.izm1 = izm1;
    }

    public Integer getTuri() {
        return turi;
    }

    public void setTuri(Integer turi) {
        this.turi = turi;
    }

    public Integer getSubkod() {
        return subkod;
    }

    public void setSubkod(Integer subkod) {
        this.subkod = subkod;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public Double getSumma_all_ost() {
        return summa_all_ost;
    }

    public void setSumma_all_ost(Double summa_all_ost) {
        this.summa_all_ost = summa_all_ost;
    }

    public Double getZakaz_see() {
        return zakaz_see;
    }

    public void setZakaz_see(Double zakaz_see) {
        this.zakaz_see = zakaz_see;
    }

    public Integer getResept() {
        return resept;
    }

    public void setResept(Integer resept) {
        this.resept = resept;
    }

    public Double getSotish_in() {
        return sotish_in;
    }

    public void setSotish_in(Double sotish_in) {
        this.sotish_in = sotish_in;
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
}
