package com.uz.shopapi.service;

import com.uz.shopapi.Request.RequestMainSlave;
import com.uz.shopapi.Response.ResponseOdMainSlave;
import com.uz.shopapi.dto.MainDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MainService {

    Integer addMain(String serial);

   Integer checkMainSerial(String serial, Integer check);

    List<ResponseOdMainSlave> getMainSlaves(int slaveid);

    Integer addMainSlave(RequestMainSlave requestMainSlave);
}
