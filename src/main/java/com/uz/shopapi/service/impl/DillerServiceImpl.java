package com.uz.shopapi.service.impl;

import com.uz.shopapi.dto.DillerDto;
import com.uz.shopapi.dto.HaridorDto;
import com.uz.shopapi.entity.Diller;
import com.uz.shopapi.entity.Haridor;
import com.uz.shopapi.repository.DillerRepository;
import com.uz.shopapi.repository.HaridorRepository;
import com.uz.shopapi.service.DillerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DillerServiceImpl implements DillerService {

    @Autowired
    DillerRepository dillerRepository;

    @Override
    public List<DillerDto> get(Integer clientid) {
        List<Diller> list=dillerRepository.findAll();
        List<DillerDto> answer=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getClient_id().equals(clientid)){
                DillerDto dillerDto =new DillerDto() ;
                BeanUtils.copyProperties(list.get(i),dillerDto);
                answer.add(dillerDto);
            }
        }
        return answer;
    }
}
