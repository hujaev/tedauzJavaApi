package com.uz.shopapi.service;

import com.uz.shopapi.dto.ProductDto;
import com.uz.shopapi.dto.ProductsDto;
import com.uz.shopapi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductsService {

    List<ProductsDto> getProducts(Integer type,Integer clientId);
    Integer addProduct(ProductDto productDto);
    List<ProductDto> getProductList(Integer clientId);
    void del(Integer id);
}
