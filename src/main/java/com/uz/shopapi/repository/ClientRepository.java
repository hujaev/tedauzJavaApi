package com.uz.shopapi.repository;

import com.uz.shopapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    Client findClientById(Integer id);

}
