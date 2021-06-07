package com.uz.shopapi.Service;

import com.uz.shopapi.Model.dto.AsosSlaveDto;
import com.uz.shopapi.Model.dto.SlaveDto;
import com.uz.shopapi.Model.dto.ProductsDto;
import com.uz.shopapi.Model.entity.AsosSlave;


import java.util.List;

public interface AsosSlaveService {

    Integer addProducts(Integer delFlag,Integer asosId, Integer userId, ProductsDto productsDto);
    List<ProductsDto> listAddProducts(Integer asosid);

    Integer getAsosSlave(Integer delFlag,Integer tovarId, AsosSlaveDto asosSlaveDto);
    List<AsosSlave> listGetAsosSlave(Integer tovarId);

    Integer listGetKirimSlave(Integer delFlag,Integer asosId, AsosSlaveDto asosSlaveDto);
    List<SlaveDto> listGetKirimSlave(Integer asosId);

    Integer addProducts2(Integer delFlag, Integer asosId, Integer userId, SlaveDto slaveDto);
    Boolean delProducts(Integer delFlag,Integer asosId,Integer id);

   Boolean putProducts(ProductsDto productsDto);
    Boolean saveinslave(SlaveDto slaveDto);

}
