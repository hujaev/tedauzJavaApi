package com.uz.shopapi.Service.impl;

import com.uz.shopapi.Model.dto.BrendDto;
import com.uz.shopapi.Model.entity.Brend;
import com.uz.shopapi.repository.BrendRepository;
import com.uz.shopapi.Service.BrendService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrendServiceImpl implements BrendService {

    @Autowired
    BrendRepository BrendRepository;

    @Override
    public List<BrendDto> get() {
        List<Brend> list=BrendRepository.findAll();
        List<BrendDto> answer=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            BrendDto brendDto =new BrendDto() ;
                BeanUtils.copyProperties(list.get(i),brendDto);
                answer.add(brendDto);
        }
        return answer;
    }
}
