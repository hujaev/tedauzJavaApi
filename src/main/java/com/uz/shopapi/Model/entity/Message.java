package com.uz.shopapi.Model.entity;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "prot_sms")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String zapros, rezult;

    @Column(length = 150)
    private String platforma;

    @Column(length = 50)
    private String tel;

    @Column(nullable = false)
    private int flag = 0;

    private LocalDateTime sana;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", zapros='" + zapros + '\'' +
                ", rezult='" + rezult + '\'' +
                ", platforma='" + platforma + '\'' +
                ", tel='" + tel + '\'' +
                ", flag=" + flag +
                ", sana=" + sana +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZapros() {
        return zapros;
    }

    public void setZapros(String zapros) {
        this.zapros = zapros;
    }

    public String getRezult() {
        return rezult;
    }

    public void setRezult(String rezult) {
        this.rezult = rezult;
    }

    public String getPlatforma() {
        return platforma;
    }

    public void setPlatforma(String platforma) {
        this.platforma = platforma;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public LocalDateTime getSana() {
        return sana;
    }

    public void setSana(LocalDateTime sana) {
        this.sana = sana;
    }
}
