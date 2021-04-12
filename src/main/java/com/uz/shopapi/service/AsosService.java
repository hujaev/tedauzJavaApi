package com.uz.shopapi.service;

import com.uz.shopapi.dto.AsosDto;
import com.uz.shopapi.dto.ProductsDto;
import com.uz.shopapi.entity.Asos;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AsosService {
    public AsosDto getAsos(AsosDto asosDto);
    public List<AsosDto> get(AsosDto asosDto);
    AsosDto put(AsosDto asosDto);
    void block(AsosDto asosDto);
//    public void save(AsosDto asosDto);
}
