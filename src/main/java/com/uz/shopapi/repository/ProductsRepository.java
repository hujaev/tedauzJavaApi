package com.uz.shopapi.repository;

import com.uz.shopapi.Model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT a.id,a.tovar_id,t.nom, SUM(a.kol_ost) AS kol_ost,SUM(a.kol_in_ost) AS kol_in_ost, a.sotish AS sot, a.sotish_in AS sot_in, shtrix,t.kol_in, a.sena_d,a.sena_in_d,shtrix_full FROM s_tovar t,asos_slave a,asos WHERE   a.del_flag=1 AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.tovar_id=t.id AND (a.kol_ost>0 OR a.kol_in_ost>0) AND asos.client_id =:client_id GROUP BY   a.tovar_id, a.sena_d ORDER BY t.nom",nativeQuery = true)
    public List<Object[]> selectDolerProducts(@Param("client_id") Integer clientId);

    @Query(value = "SELECT a.id,a.tovar_id,t.nom, SUM(a.kol_ost) AS kol_ost,SUM(a.kol_in_ost) AS kol_in_ost, a.sotish AS sot, a.sotish_in AS sot_in, shtrix,t.kol_in,shtrix_full FROM s_tovar t,asos_slave a,asos WHERE   a.del_flag=1 AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.tovar_id=t.id AND (a.kol_ost>0 OR a.kol_in_ost>0) AND asos.client_id =:client_id GROUP BY   a.tovar_id, sot ORDER BY t.nom",nativeQuery = true)
    public List<Object[]> selectChakanaProducts(@Param("client_id") Integer clientId);

    @Query(value = "SELECT a.id,a.tovar_id,t.nom,SUM(a.kol_ost) AS kol_ost ,SUM(a.kol_in_ost) AS kol_in_ost, a.opt1 AS sot,a.opt1_in AS sot_in,shtrix,t.kol_in,shtrix_full FROM s_tovar t,asos_slave a,asos WHERE   a.del_flag=1 AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.tovar_id=t.id AND (a.kol_ost>0 OR a.kol_in_ost>0) AND asos.client_id =:client_id GROUP BY a.tovar_id, sot ORDER BY t.nom",nativeQuery = true)
    public List<Object[]> selectOptom1Products(@Param("client_id") Integer clientId);

    @Query(value = "SELECT a.id,a.tovar_id,t.nom,SUM(a.kol_ost) AS kol_ost,SUM(a.kol_in_ost) AS kol_in_ost, a.opt2 AS sot,a.opt2_in AS sot_in,shtrix,t.kol_in,shtrix_full FROM s_tovar t,asos_slave a,asos WHERE   a.del_flag=1 AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.tovar_id=t.id AND (a.kol_ost>0 OR a.kol_in_ost>0) AND asos.client_id =:client_id GROUP BY a.tovar_id, sot ORDER BY t.nom",nativeQuery = true)
    public List<Object[]> selectOptom2Products(@Param("client_id") Integer clientId);

    @Query(value = "SELECT a.id,a.tovar_id,t.nom,SUM(a.kol_ost) AS kol_ost,SUM(a.kol_in_ost) AS kol_in_ost, a.opt1_pl AS sot,a.opt1_pl_in AS sot_in,shtrix,t.kol_in,shtrix_full FROM s_tovar t,asos_slave a,asos WHERE   a.del_flag=1 AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.tovar_id=t.id AND (a.kol_ost>0 OR a.kol_in_ost>0) AND asos.client_id =:client_id  GROUP BY a.tovar_id, sot ORDER BY t.nom",nativeQuery = true)
    public List<Object[]> selectOptom1PlasProducts(@Param("client_id") Integer clientId);

     @Query(value = "SELECT a.id,a.tovar_id,t.nom,SUM(a.kol_ost) AS kol_ost,SUM(a.kol_in_ost) AS kol_in_ost, a.opt2_pl AS sot,a.opt2_pl_in AS sot_in,shtrix,t.kol_in,shtrix_full FROM s_tovar t,asos_slave a,asos WHERE   a.del_flag=1 AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.tovar_id=t.id AND (a.kol_ost>0 OR a.kol_in_ost>0) AND asos.client_id =:client_id  GROUP BY a.tovar_id, sot ORDER BY t.nom",nativeQuery = true)
    public List<Object[]> selectOptom2PlasProducts(@Param("client_id") Integer clientId);

     @Query(value = "SELECT a.id,a.tovar_id,t.nom,SUM(a.kol_ost) AS kol_ost,SUM(a.kol_in_ost) AS kol_in_ost, a.schet AS sot,a.schet_in AS sot_in,shtrix,t.kol_in,shtrix_full FROM s_tovar t,asos_slave a,asos WHERE   a.del_flag=1 AND asos.tur_oper IN (1,3,5) AND a.asos_id=asos.id AND a.tovar_id=t.id AND (a.kol_ost>0 OR a.kol_in_ost>0) AND asos.client_id =:client_id  GROUP BY a.tovar_id, sot ORDER BY t.nom",nativeQuery = true)
     public List<Object[]> selectBankSchetProducts(@Param("client_id") Integer clientId);

     @Query(value = "SELECT * FROM s_tovar p WHERE p.del_flag = :delFlag", nativeQuery = true)
     List<Product> findByDel_flag(int delFlag);


     /******************************************************************************************************************************
      * ***************************************************************************************************************************/


}
