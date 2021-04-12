package com.uz.shopapi.service;

import com.uz.shopapi.dto.HaridorDto;

import java.util.List;

public interface HaridorService {
    List<HaridorDto> getHaridor(Integer clientId);
}
