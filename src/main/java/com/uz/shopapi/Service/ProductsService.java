package com.uz.shopapi.Service;

import com.uz.shopapi.Model.dto.ProductDto;
import com.uz.shopapi.Model.dto.ProductsDto;

import java.util.List;

public interface ProductsService {

    List<ProductsDto> getProducts(Integer type, Integer clientId);
    Integer addProduct(ProductDto productDto);
    List<ProductDto> getProductList(Integer clientId);
    void del(Integer id);

    Integer editproduct(ProductDto productDto);
}
