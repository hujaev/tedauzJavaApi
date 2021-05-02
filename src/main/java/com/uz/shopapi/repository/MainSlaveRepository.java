package com.uz.shopapi.repository;

import com.uz.shopapi.Model.entity.SlaveMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MainSlaveRepository extends JpaRepository<SlaveMain, Integer> {

    @Query(value = "SELECT * FROM slave_main s WHERE s.main_id=:mainid and s.del_flag=1", nativeQuery = true)
    SlaveMain findSlaveMainBySerial(Integer mainid);

    @Query(value = "SELECT * FROM slave_main s WHERE s.main_id=:Id and s.del_flag=1", nativeQuery = true)
    SlaveMain selectMainSlave(@Param("Id") Integer Id);
}
