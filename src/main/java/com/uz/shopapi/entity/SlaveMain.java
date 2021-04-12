package com.uz.shopapi.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "slave_main")
@EntityListeners(AuditingEntityListener.class)
public class SlaveMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "slave_id")
    Integer slave_id;
    @Column(name = "main_id")
    Integer main_id;
    @Column(name = "del_flag")
    Integer del_flag;

    public SlaveMain() {
    }

    public SlaveMain(Integer slave_id, Integer main_id, Integer del_flag) {
        this.slave_id = slave_id;
        this.main_id = main_id;
        this.del_flag = del_flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSlave_id() {
        return slave_id;
    }

    public void setSlave_id(Integer slave_id) {
        this.slave_id = slave_id;
    }

    public Integer getMain_id() {
        return main_id;
    }

    public void setMain_id(Integer main_id) {
        this.main_id = main_id;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }
}
