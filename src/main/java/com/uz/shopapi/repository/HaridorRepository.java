package com.uz.shopapi.repository;

import com.uz.shopapi.entity.Haridor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Queue;

public interface HaridorRepository extends JpaRepository<Haridor,Integer> {

    @Query(value = "SELECT  id,client_id,nom,adress,manzil,chat_id,phone_number FROM s_haridor WHERE phone_number=:phone_number",nativeQuery = true)
    Haridor findByPhone_number(@Param("phone_number") String phone_number);
}
