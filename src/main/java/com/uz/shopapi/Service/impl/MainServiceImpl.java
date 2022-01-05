package com.uz.shopapi.Service.impl;
import com.uz.shopapi.Model.Request.RequestMainSlave;
import com.uz.shopapi.Model.entity.Main;
import com.uz.shopapi.Model.entity.SlaveMain;
import com.uz.shopapi.repository.MainRepository;
import com.uz.shopapi.repository.MainSlaveRepository;
import com.uz.shopapi.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import java.util.ArrayList;
import java.util.List;
@Service
public class MainServiceImpl implements MainService {
    @Autowired
    MainRepository mainRepository;
    @Autowired
    MainSlaveRepository mainSlaveRepository;
    @Override
    public Integer addMain(String serial) {
        Integer Id=0;
        Main main1=mainRepository.selectMain(serial);
        if (main1==null){
            Main main=new Main();
//        BeanUtils.copyProperties(mainDto, main);
            main.setSerial(serial);
            Id=mainRepository.save(main).getId();
        } else{
            Id=main1.getId();
        }

        SlaveMain mainslave1=mainSlaveRepository.selectMainSlave(Id);
        if (mainslave1==null){
            return Id;
        } else  {
            return -mainslave1.getId();
        }
    }
    @Override
    public Integer checkMainSerial(String serial, Integer check) {
       Main main = mainRepository.selectMain(serial);
       if (main ==null){
           if (check == 1){
               Main main1=new Main();
               main1.setSerial(serial);
              return mainRepository.save(main1).getId();
           }else {
               return 777;
           }
       }
       else {
           return main.getId();
       }
    }
    @Override
    public List<SlaveMain> getMainSlavesSlaveId(Integer slaveId) {
        List<SlaveMain> listMainSlave=mainSlaveRepository.findSlaveMainBySlaveId(slaveId);
        return  listMainSlave;
    }

    @Override
    public Integer addMainSlave(RequestMainSlave requestMainSlave) {


        Main main = mainRepository.selectMain(requestMainSlave.getSerial());

            SlaveMain slaveMain= mainSlaveRepository.findSlaveMainBySerial(main.getId());
            if(slaveMain==null){
                slaveMain=new SlaveMain();
                slaveMain.setDel_flag(1);
                slaveMain.setMain_id(main.getId());
                slaveMain.setSlave_id(requestMainSlave.getSlave_id());
                Integer lastMainSlave = mainSlaveRepository.save(slaveMain).getId();
                return lastMainSlave;
            }else{
                return -slaveMain.getId();
            }
        //}  return 99999;
    }
    @Override
    public Integer deleteMainSlave(Integer id) throws Exception {
        SlaveMain slaveMain=mainSlaveRepository.findById(id).get();
        if (slaveMain==null) throw new Exception();
        mainSlaveRepository.delete(slaveMain);
        return id;
    }
}
