package com.uz.shopapi.repository;


import com.uz.shopapi.entity.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<Main, Integer> {

    @Query(value = "SELECT * FROM main m WHERE m.serial=:serial", nativeQuery = true)
    Main selectMain(@Param("serial") String serial);

}
