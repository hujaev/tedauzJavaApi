package com.uz.shopapi.service;

import com.uz.shopapi.dto.AsosSlaveDto;
import com.uz.shopapi.dto.ProductsDto;
import com.uz.shopapi.entity.AsosSlave;

import java.util.List;

public interface AsosSlaveService {

    Integer addProducts(Integer delFlag,Integer asosId, Integer userId, ProductsDto productsDto);
    List<ProductsDto> listAddProducts(Integer asosid);
    Integer addProducts2(Integer delFlag,Integer asosId, Integer userId, ProductsDto productsDto);
    Boolean delProducts(Integer delFlag,Integer asosId,Integer id);

   Boolean putProducts(ProductsDto productsDto);

}
