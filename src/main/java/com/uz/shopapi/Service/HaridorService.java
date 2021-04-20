package com.uz.shopapi.Service;

import com.uz.shopapi.Model.dto.HaridorDto;

import java.util.List;

public interface HaridorService {
    List<HaridorDto> getHaridor(Integer clientId);
}
