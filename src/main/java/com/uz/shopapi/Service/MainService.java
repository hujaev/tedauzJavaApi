package com.uz.shopapi.Service;


import com.uz.shopapi.Model.Request.RequestMainSlave;
import com.uz.shopapi.Model.entity.SlaveMain;

import java.util.List;

public interface MainService {

    Integer addMain(String serial);
 
    Integer checkMainSerial(String serial, Integer check);

    //List<ResponseOdMainSlave> getMainSlaves(int slaveid);
    List<SlaveMain> getMainSlavesSlaveId(Integer slaveId);

    Integer addMainSlave(RequestMainSlave requestMainSlave);

    Integer deleteMainSlave(Integer id) throws Exception;
}
