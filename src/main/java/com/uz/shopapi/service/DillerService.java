package com.uz.shopapi.service;

import com.uz.shopapi.dto.DillerDto;
import com.uz.shopapi.dto.HaridorDto;

import java.util.List;

public interface DillerService {
    List<DillerDto> get(Integer clientid);
}
