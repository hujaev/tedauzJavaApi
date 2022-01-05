package com.uz.shopapi.repository;

import com.uz.shopapi.Model.entity.Main;
import com.uz.shopapi.Model.entity.SlaveMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MainSlaveRepository extends JpaRepository<SlaveMain, Integer> {

    @Query(value = "SELECT * FROM slave_main s WHERE s.main_id=:mainId and s.del_flag=1", nativeQuery = true)
    SlaveMain findSlaveMainBySerial(Integer mainId);
    @Query(value = "SELECT s.*,m.serial FROM slave_main s,main m,asos_slave a WHERE s.slave_id=:slaveId and m.id=s.main_id and a.id=s.slave_id", nativeQuery = true)
    public List<SlaveMain> findSlaveMainBySlaveId(@Param("slaveId")  Integer slaveId);
    @Query(value = "SELECT * FROM slave_main s WHERE s.main_id=:Id and s.del_flag=1", nativeQuery = true)
    SlaveMain selectMainSlave(@Param("Id") Integer Id);
}
