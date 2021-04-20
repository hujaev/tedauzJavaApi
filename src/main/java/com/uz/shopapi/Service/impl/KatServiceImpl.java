package com.uz.shopapi.Service.impl;

import com.uz.shopapi.Model.dto.KatDto;
import com.uz.shopapi.Model.entity.Kat;
import com.uz.shopapi.repository.KatRepository;
import com.uz.shopapi.Service.KatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KatServiceImpl implements KatService {

    @Autowired
    KatRepository KatRepository;

    @Override
    public List<KatDto> get() {
        List<Kat> list=KatRepository.findAll();
        List<KatDto> answer=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
                KatDto KatDto =new KatDto() ;
                BeanUtils.copyProperties(list.get(i),KatDto);
                answer.add(KatDto);
        }
        return answer;
    }
}
