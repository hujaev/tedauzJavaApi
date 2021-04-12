package com.uz.shopapi.repository;

import com.uz.shopapi.entity.SlaveMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MainSlaveRepository extends JpaRepository<SlaveMain, Integer> {

    @Query(value = "SELECT * FROM slave_main s WHERE s.main_id=:mainid and s.slave_id=:slaveid", nativeQuery = true)
    SlaveMain findSlaveMainBySerial(Integer mainid, Integer slaveid);
}
