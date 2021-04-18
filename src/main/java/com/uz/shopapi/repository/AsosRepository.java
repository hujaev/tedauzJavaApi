package com.uz.shopapi.repository;

import com.uz.shopapi.entity.Asos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import java.util.List;

public interface AsosRepository extends JpaRepository<Asos,Integer> {
    @Query(value = "SELECT id, client_id, user_id, h_id,xodim_id,sana,diler_id,tur_oper, summa, sotuv_turi,nomer,del_flag,kurs,sum_d,kol,dollar FROM asos WHERE sana=CURDATE() AND diler_id=:diler_id AND user_id=:user_id AND tur_oper=2 AND del_flag=1",nativeQuery = true)
    Asos selectAsos(@Param("user_id") Integer userId,@Param("diler_id") Integer dilerId);

    @Query(value = "SELECT id, client_id, user_id, h_id,xodim_id,sana,diler_id,tur_oper, summa, sotuv_turi,nomer,del_flag,kurs,sum_d,kol,dollar FROM asos WHERE  client_id=:client_id AND tur_oper=1 AND del_flag=1",nativeQuery = true)
    List<Asos> selectAsosGet(@Param("client_id") Integer clientId);

    @Query(value = "SELECT * FROM asos a WHERE a.tur_oper =:turoper", nativeQuery = true)
    Asos findAsosByTur_oper(Integer turoper);

}

