package com.uz.shopapi.Service;

import com.uz.shopapi.Model.dto.AsosDto;

import java.util.List;

public interface AsosService {
    public AsosDto getAsos(AsosDto asosDto);
    public List<AsosDto> get(AsosDto asosDto);
    AsosDto put(AsosDto asosDto);
    void block(AsosDto asosDto);

    AsosDto editAsos(AsosDto asosDto);
//    public void save(AsosDto asosDto);
}
