package com.uz.shopapi.Model.dto;


public class SlaveMainDto {

    Integer id;
    Integer slave_id;
    Integer main_id;
    Integer del_flag;

    public SlaveMainDto() {
    }

    public SlaveMainDto(Integer id, Integer slave_id, Integer main_id, Integer del_flag) {
        this.id = id;
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

    @Override
    public String toString() {
        return "MainDto{" +
                "id=" + id +
                ", slave_id=" + slave_id +
                ", main_id=" + main_id +
                ", del_flag=" + del_flag +
                '}';
    }
}
