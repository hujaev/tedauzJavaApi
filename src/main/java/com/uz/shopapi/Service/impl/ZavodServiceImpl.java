package com.uz.shopapi.Service.impl;

import com.uz.shopapi.Model.dto.ZavodDto;
import com.uz.shopapi.Model.entity.Zavod;
import com.uz.shopapi.repository.ZavodRepository;
import com.uz.shopapi.Service.ZavodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZavodServiceImpl implements ZavodService {

    @Autowired
    ZavodRepository ZavodRepository;

    @Override
    public List<ZavodDto> get() {
        List<Zavod> list=ZavodRepository.findAll();
        List<ZavodDto> answer=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            ZavodDto ZavodDto =new ZavodDto() ;
                BeanUtils.copyProperties(list.get(i),ZavodDto);
                answer.add(ZavodDto);
        }
        return answer;
    }
}
