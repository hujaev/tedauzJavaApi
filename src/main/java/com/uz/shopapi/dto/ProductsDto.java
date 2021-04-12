package com.uz.shopapi.dto;

public class ProductsDto {
    Integer id;
    Integer productId;
    String nameShort;
    String name;
    Integer count;
    Integer incount;
    Double price;
    Double inprice;
    String shtrix;
    Integer Incnt;
    Double sena_d;
    Double sena_in_d;
    String shtrix_full;




    public ProductsDto() {
        this.nameShort="";
        this.name="";
        this.shtrix="";
        this.sena_d=0.0;
        this.sena_in_d=0.0;
    }

    public String getShtrix_full() {
        return shtrix_full;
    }

    public void setShtrix_full(String shtrix_full) {
        this.shtrix_full = shtrix_full;
    }

    public Double getSena_d() {
        return sena_d;
    }

    public void setSena_d(Double sena_d) {
        this.sena_d = sena_d;
    }

    public Double getSena_in_d() {
        return sena_in_d;
    }

    public void setSena_in_d(Double sena_in_d) {
        this.sena_in_d = sena_in_d;
    }

    public String getShtrix() {
        return shtrix;
    }

    public void setShtrix(String shtrix) {
        this.shtrix = shtrix;
    }

    public Integer getIncnt() {
        return Incnt;
    }

    public void setIncnt(Integer incnt) {
        Incnt = incnt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getIncount() {
        return incount;
    }

    public void setIncount(Integer incount) {
        this.incount = incount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getInprice() {
        return inprice;
    }

    public void setInprice(Double inprice) {
        this.inprice = inprice;
    }

    @Override
    public String toString() {
        return "ProductsDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", nameShort='" + nameShort + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", incount=" + incount +
                ", price=" + price +
                ", inprice=" + inprice +
                '}';
    }
}
