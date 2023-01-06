package com.uz.shopapi.Model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "prot_sms")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String zapros, rezult;

    @Column(length = 150)
    private String platforma;

    @Column(length = 50)
    private String tel;

    @Column(nullable = false)
    private int flag = 0;

    private LocalDateTime sana = LocalDateTime.now();
}
