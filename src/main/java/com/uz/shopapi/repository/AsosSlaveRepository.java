package com.uz.shopapi.repository;

import com.uz.shopapi.entity.Asos;
import com.uz.shopapi.entity.AsosSlave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import java.util.List;

public interface AsosSlaveRepository extends JpaRepository<AsosSlave,Integer> {
    @Query(value = "SELECT  id,tovar_id,asos_id,user_id, tovar_nom,kol,kol_in,kol_ost,kol_in_ost,summa,summa_in,summa_all,sotish,sotish_in,sena,sena_in FROM asos_slave WHERE kol_ost=:id",nativeQuery = true)
    public AsosSlave selectAsosSlaveByKolOst(@Param("id") Integer id);

    @Query(value = "SELECT  a.id,a.tovar_id,a.asos_id,a.user_id,a.tovar_nom,SUM(a.kol) AS kol,SUM(a.kol_in) AS kol_in,a.kol_ost,a.kol_in_ost,a.summa,a.summa_in,a.summa_all,a.sotish,a.sotish_in,a.sena,a.sena_in,a.turi,a.subkod,a.del_flag,a.summa_all_ost,a.zakaz_see,a.resept,a.izm_id,a.izm1 FROM asos_slave a WHERE a.asos_id=:asosid AND a.del_flag=1  GROUP BY a.tovar_id, a.sotish ORDER BY a.tovar_nom",nativeQuery = true)
    public List<AsosSlave> selectByAsosId(@Param("asosid") Integer asosId);

    @Query(value = "SELECT  a.id,a.tovar_id,a.asos_id,a.user_id,a.tovar_nom,SUM(a.kol) AS kol,SUM(a.kol_in) AS kol_in,a.kol_ost,a.kol_in_ost,a.summa,a.summa_in,a.summa_all,a.sotish,a.sotish_in,a.sena,a.sena_in,a.turi,a.subkod,a.del_flag,a.summa_all_ost,a.zakaz_see,a.resept,a.izm_id,a.izm1 FROM asos_slave a WHERE a.tovar_id=:tovarid AND a.del_flag=1  GROUP BY a.tovar_id, a.sotish ORDER BY a.tovar_nom",nativeQuery = true)
    public List<AsosSlave> selectBytovarId(@Param("tovarid") Integer tovarId);

    @Query(value = "SELECT  a.id,a.tovar_id,a.asos_id,a.user_id,a.tovar_nom,a.kol,a.kol_in,a.kol_ost,a.kol_in_ost,a.summa,a.summa_in,a.summa_all,a.sotish,a.sotish_in,a.sena,a.sena_in,a.turi,a.subkod,a.del_flag,a.summa_all_ost,a.zakaz_see,a.resept,a.izm_id,a.izm1 FROM asos_slave a,asos WHERE a.sotish=:sotish  AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.del_flag=1  AND a.tovar_id=:tovar_id AND (a.kol_ost>0 OR a.kol_in_ost>0)  ORDER BY a.tovar_nom",nativeQuery = true)
    public List<AsosSlave> selectChakanaProductsFull(@Param("sotish") Double price,@Param("tovar_id") Integer tovarId);


    @Query(value = "SELECT  a.id,a.tovar_id,a.asos_id,a.user_id,a.tovar_nom,a.kol,a.kol_in,a.kol_ost,a.kol_in_ost,a.summa,a.summa_in,a.summa_all,a.sotish,a.sotish_in,a.sena,a.sena_in,a.turi,a.subkod,a.del_flag,a.summa_all_ost,a.zakaz_see,a.resept,a.izm_id,a.izm1 FROM asos_slave a,asos WHERE a.opt1=:opt1  AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.del_flag=1 AND a.tovar_id=:tovar_id AND (a.kol_ost>0 OR a.kol_in_ost>0)  ORDER BY a.tovar_nom",nativeQuery = true)
    public List<AsosSlave> selectOptom1ProductsFull(@Param("opt1") Double price,@Param("tovar_id") Integer tovarId);

    @Query(value = "SELECT  a.id,a.tovar_id,a.asos_id,a.user_id,a.tovar_nom,a.kol,a.kol_in,a.kol_ost,a.kol_in_ost,a.summa,a.summa_in,a.summa_all,a.sotish,a.sotish_in,a.sena,a.sena_in,a.turi,a.subkod,a.del_flag,a.summa_all_ost,a.zakaz_see,a.resept,a.izm_id,a.izm1 FROM asos_slave a,asos WHERE a.opt2=:opt2  AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.del_flag=1  AND a.tovar_id=:tovar_id AND (a.kol_ost>0 OR a.kol_in_ost>0)  ORDER BY a.tovar_nom",nativeQuery = true)
    public List<AsosSlave> selectOptom2ProductsFull(@Param("opt2") Double price,@Param("tovar_id") Integer tovarId);

     @Query(value = "SELECT  a.id,a.tovar_id,a.asos_id,a.user_id,a.tovar_nom,a.kol,a.kol_in,a.kol_ost,a.kol_in_ost,a.summa,a.summa_in,a.summa_all,a.sotish,a.sotish_in,a.sena,a.sena_in,a.turi,a.subkod,a.del_flag,a.summa_all_ost,a.zakaz_see,a.resept,a.izm_id,a.izm1 FROM asos_slave a,asos WHERE  a.opt1_pl=:opt1_pl  AND  asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.del_flag=1  AND a.tovar_id=:tovar_id AND (a.kol_ost>0 OR a.kol_in_ost>0)  ORDER BY a.tovar_nom",nativeQuery = true)
     public List<AsosSlave> selectOptom1PlasProductsFull(@Param("opt1_pl") Double price,@Param("tovar_id") Integer tovarId);

     @Query(value = "SELECT  a.id,a.tovar_id,a.asos_id,a.user_id,a.tovar_nom,a.kol,a.kol_in,a.kol_ost,a.kol_in_ost,a.summa,a.summa_in,a.summa_all,a.sotish,a.sotish_in,a.sena,a.sena_in,a.turi,a.subkod,a.del_flag,a.summa_all_ost,a.zakaz_see,a.resept,a.izm_id,a.izm1 FROM asos_slave a,asos WHERE  a.opt2_pl=:opt2_pl  AND  asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.del_flag=1  AND a.tovar_id=:tovar_id AND (a.kol_ost>0 OR a.kol_in_ost>0)  ORDER BY a.tovar_nom",nativeQuery = true)
     public List<AsosSlave> selectOptom2PlasProductsFull(@Param("opt2_pl") Double price,@Param("tovar_id") Integer tovarId);

     @Query(value = "SELECT  a.id,a.tovar_id,a.asos_id,a.user_id,a.tovar_nom,a.kol,a.kol_in,a.kol_ost,a.kol_in_ost,a.summa,a.summa_in,a.summa_all,a.sotish,a.sotish_in,a.sena,a.sena_in,a.turi,a.subkod,a.del_flag,a.summa_all_ost,a.zakaz_see,a.resept,a.izm_id,a.izm1 FROM asos_slave a,asos WHERE  a.schet=:schet  AND  asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.del_flag=1 AND a.tovar_id=:tovar_id AND (a.kol_ost>0 OR a.kol_in_ost>0)  ORDER BY a.tovar_nom",nativeQuery = true)
     public List<AsosSlave> selectBankSchetProductsFull(@Param("schet") Double price,@Param("tovar_id") Integer tovarId);

     @Query(value = "SELECT * FROM asosSlave a WHERE a.asos_id = :asosid", nativeQuery = true)
    AsosSlave findAsosSlaveByAsos_id(Integer asosid);

     @Query(value = "SELECT * FROM asos_slave a WHERE a.tovar_id = :tavarid", nativeQuery = true)
     List<AsosSlave> findAsosSlavesByTavarId(Integer tavarid);




}
