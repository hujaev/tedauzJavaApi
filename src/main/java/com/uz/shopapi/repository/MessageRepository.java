package com.uz.shopapi.repository;

import com.uz.shopapi.Model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByFlag(int flag);

}
