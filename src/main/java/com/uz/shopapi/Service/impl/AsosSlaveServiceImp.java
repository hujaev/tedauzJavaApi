package com.uz.shopapi.Service.impl;

import com.uz.shopapi.Model.dto.AsosSlaveDto;
import com.uz.shopapi.Model.dto.SlaveDto;
import com.uz.shopapi.Model.dto.ProductsDto;
import com.uz.shopapi.Model.entity.AsosSlave;
import com.uz.shopapi.repository.*;
import com.uz.shopapi.Service.AsosSlaveService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AsosSlaveServiceImp implements AsosSlaveService {
    @Autowired
    AsosRepository asosRepository;
    @Autowired
    AsosSlaveRepository asosSlaveRepository;

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Integer addProducts(Integer delFlag,Integer asosId, Integer userId, ProductsDto productsDto) {


        Integer type=asosRepository.findById(asosId ).get().getSotuv_turi();

        List<AsosSlave>list;
        if(type==1) {
            list = asosSlaveRepository.selectChakanaProductsFull(productsDto.getPrice(),  productsDto.getProductId());
        }
        else if(type==2) {
            list = asosSlaveRepository.selectOptom1ProductsFull(productsDto.getPrice(),  productsDto.getProductId());
        }
        else if(type==3) {
            list = asosSlaveRepository.selectOptom2ProductsFull(productsDto.getPrice(),  productsDto.getProductId());
        }
        else if(type==4) {
            list = asosSlaveRepository.selectOptom1PlasProductsFull(productsDto.getPrice(),  productsDto.getProductId());
        }
        else if(type==5){
            list=asosSlaveRepository.selectOptom2PlasProductsFull(productsDto.getPrice(),productsDto.getProductId());
        }
        else{
            list=asosSlaveRepository.selectBankSchetProductsFull(productsDto.getPrice(),productsDto.getProductId());
        }

        Boolean checkInt=false;
        Integer inCountAll = 0;
        Integer   countAll = 0;
        for (int i = 0; i <list.size() ; i++) {
            countAll += list.get(i).getKol_ost();
            inCountAll += list.get(i).getKol_in_ost();
        }

        if(countAll>productsDto.getCount() && productsDto.getIncount()==0){
            checkInt=true;
        }
        else if(countAll*productsDto.getIncnt() + inCountAll < productsDto.getCount()*productsDto.getIncnt() + productsDto.getIncount()){
            return (countAll*productsDto.getIncnt() + inCountAll) - (productsDto.getCount()*productsDto.getIncnt() + productsDto.getIncount());
        }
        else{
            checkInt=false;
        }

        Integer productsCount=productsDto.getCount();
        Integer productsInCount=productsDto.getIncount();

        Integer Kol = 0;
        Integer KolIn = 0;

        AsosSlave res = new AsosSlave();
        Integer row=productsDto.getCount()*productsDto.getIncnt()+productsDto.getIncount();

        List<AsosSlave> asosSlaveList=asosSlaveRepository.findAll();
        List<AsosSlave> slaves=new ArrayList<>();
        for (int i = 0; i <asosSlaveList.size() ; i++) {
            if(asosSlaveList.get(i).getAsos_id().equals(asosId) &&
                    asosSlaveList.get(i).getTovar_id().equals(productsDto.getProductId()) &&
                    asosSlaveList.get(i).getDel_flag().equals(2)){
                slaves.add(asosSlaveList.get(i));
            }
        }
        int cnt=0;

        for (int i = 0; i <list.size() ; i++) {
            AsosSlave asosSlave=list.get(i);




            Integer asosSlaveOst_in = asosSlave.getKol_in_ost();
            Integer asosSlaveOst = asosSlave.getKol_ost();



            AsosSlave asosSlaveInsert=new AsosSlave();

            if(delFlag.equals(2)){
                asosSlaveInsert.setDel_flag(1);
                asosSlaveInsert.setId(slaves.get(cnt++).getId());
            }

            Integer all= asosSlaveOst*productsDto.getIncnt() + asosSlaveOst_in;


            if(checkInt){

                if(productsCount==0){
                    break;
                }

                if(countAll>=productsCount && productsCount>0){

                    if(asosSlaveOst >= productsCount){
                        asosSlaveOst -= productsCount;
                        Kol=productsCount;
                        KolIn=0;
                        productsCount=0;
                    }
                    if (asosSlaveOst < productsCount && productsCount>0){
                        productsCount -= asosSlaveOst;
                        Kol=asosSlaveOst;
                        KolIn=0;
                        asosSlaveOst=0;
                    }
                }

            }
            else{
                if (row==0){
                    break;
                }

                if(all>=row && row>0){
                    all-=row;
                    asosSlaveOst=all / productsDto.getIncnt();
                    asosSlaveOst_in=all % productsDto.getIncnt();
                    Kol   =row / productsDto.getIncnt();
                    KolIn=row % productsDto.getIncnt();
                    row=0;
                }
                else{
                    row-=all;

                    asosSlaveOst=0;
                    asosSlaveOst_in=0;

                    Kol   =all / productsDto.getIncnt();
                    KolIn=all % productsDto.getIncnt();
                }
            }


            asosSlave.setKol_ost(asosSlaveOst);
            asosSlave.setKol_in_ost(asosSlaveOst_in);
            asosSlaveRepository.save(asosSlave);

            Double   summaIn =(Double)(KolIn * productsDto.getInprice()*1.0);
            Double     summa =(Double)(Kol * productsDto.getPrice()*1.0);
            Double  summaAll = summa + summaIn;


            asosSlaveInsert.setTovar_nom(productsDto.getName());
            asosSlaveInsert.setTovar_id(productsDto.getProductId());
            asosSlaveInsert.setAsos_id(asosId);

            asosSlaveInsert.setUser_id(userId);

            asosSlaveInsert.setKol(Kol);
            asosSlaveInsert.setKol_in(KolIn);

            asosSlaveInsert.setSumma(summa);
            asosSlaveInsert.setSumma_in(summaIn);
            asosSlaveInsert.setSumma_all(summaAll);
            asosSlaveInsert.setSotish((Double) (productsDto.getPrice()*1.0));
            asosSlaveInsert.setSotish_in((Double)(productsDto.getInprice()*1.0));
            asosSlaveInsert.setSena(asosSlave.getSena());
            asosSlaveInsert.setSena_in(asosSlave.getSena_in());
            asosSlaveInsert.setKol_ost(asosSlave.getId());

            asosSlaveInsert.setKol_in_ost(0);
            asosSlaveInsert.setTuri(0);
            asosSlaveInsert.setSubkod(0);
            asosSlaveInsert.setDel_flag(1);
            asosSlaveInsert.setSumma_all_ost(0.0);
            asosSlaveInsert.setZakaz_see(0.0);
            asosSlaveInsert.setResept(0);

            asosSlaveInsert.setIzm_id(asosSlave.getIzm_id());
            asosSlaveInsert.setIzm1(asosSlave.getIzm1());

            res=asosSlaveRepository.save(asosSlaveInsert);//888

        }
        return res.getId();
    }

    @Override
    public List<ProductsDto> listAddProducts(Integer asosid) {
        List<ProductsDto> list=new ArrayList<>();
        Integer type=asosRepository.findById(asosid).get().getSotuv_turi();
        List<AsosSlave> asosSlaveList=asosSlaveRepository.selectByAsosId(asosid);

        for (int i = 0; i < asosSlaveList.size(); i++) {

            ProductsDto productsDto=new ProductsDto();
            Integer incnt=productsRepository.findById(asosSlaveList.get(i).getTovar_id()).get().getKol_in();

            productsDto.setId(asosSlaveList.get(i).getId());
            productsDto.setProductId(asosSlaveList.get(i).getTovar_id());

            if (asosSlaveList.get(i).getTovar_nom() != null){
                productsDto.setName(asosSlaveList.get(i).getTovar_nom());
            }
            else{
                productsDto.setName("Номи йўқ");
            }
            if (asosSlaveList.get(i).getSotish() != null){
                productsDto.setPrice(asosSlaveList.get(i).getSotish());
            }
            else{
                productsDto.setPrice(0.0);
            }
            if (asosSlaveList.get(i).getSotish_in() != null){
                productsDto.setInprice(asosSlaveList.get(i).getSotish_in());
            }
            else{
                productsDto.setInprice(0.0);
            }
            if (asosSlaveList.get(i).getKol() != null){
                productsDto.setCount(asosSlaveList.get(i).getKol());
            }
            else{
                productsDto.setCount(0);
            }
            if (asosSlaveList.get(i).getKol_in() != null){
                productsDto.setIncount(asosSlaveList.get(i).getKol_in());
            }
            else {
                productsDto.setIncount(1);
            }
            productsDto.setIncnt(incnt);

            list.add(productsDto);
        }
        return list;
    }

    @Override
    public Integer getAsosSlave(Integer delFlag, Integer tovarId, AsosSlaveDto asosSlaveDto) {
        return null;
    }


    @Override
    public List<AsosSlave> listGetAsosSlave(Integer tovarId) {
        List<AsosSlave> listAsosSlave=asosSlaveRepository.findAsosSlavesByTovarId(tovarId);
        return listAsosSlave;
    }

    @Override
    public Integer listGetKirimSlave(Integer delFlag, Integer tovarId, AsosSlaveDto asosSlaveDto) {
        return null;
    }

    @Override
    public List<SlaveDto> listGetKirimSlave(Integer asosId) {
        List<AsosSlave> listAsosSlave=asosSlaveRepository.findAsosSlaveByAsos_id(asosId);
        List<SlaveDto> listAsosSlaveDto = new ArrayList<>();
        for (AsosSlave asosSlave : listAsosSlave) {
            SlaveDto asosSlaveDto=new SlaveDto();
            BeanUtils.copyProperties(asosSlave, asosSlaveDto);
            listAsosSlaveDto.add(asosSlaveDto);
        }
        return listAsosSlaveDto;
    }

    @Override
    public Integer addProducts2(Integer delFlag, Integer asosId, Integer userId, SlaveDto slaveDto) {
        //Product product=productsRepository.findById(productsDto.getProductId()).get();

        AsosSlave asosSlave=new AsosSlave();
        asosSlave.setTovar_nom(slaveDto.getTovar_nom());
        asosSlave.setTovar_id(slaveDto.getTovar_id());
        asosSlave.setDel_flag(1);
        asosSlave.setKol_ost(slaveDto.getKol());
        asosSlave.setKol_in_ost(slaveDto.getKol_in());
        asosSlave.setAsos_id(asosId);
        asosSlave.setKol(slaveDto.getKol());
        asosSlave.setKol_in(slaveDto.getKol_in());
        asosSlave.setSotish(slaveDto.getSotish());
        asosSlave.setSotish_in(slaveDto.getSotish_in());
        asosSlave.setUser_id(userId);
        asosSlave.setResept(1);
        asosSlave.setSena(slaveDto.getSena());
        asosSlave.setSena_in(slaveDto.getSena_in());
        asosSlave.setSubkod(1);
        asosSlave.setSumma_all_ost(0.00);
        //asosSlave.setSumma_all_ost(productsDto.getPrice()*productsDto.getCount()+
                //productsDto.getInprice()*productsDto.getIncount());
        asosSlave.setTuri(1);
        asosSlave.setZakaz_see(0.0);
        return asosSlaveRepository.save(asosSlave).getId().intValue();
    }

    @Override
    public Boolean delProducts(Integer delFlag,Integer asosId,Integer id) {
        List<AsosSlave> asosSlaveDelList=asosSlaveRepository.findAll();
        for (int i = 0; i < asosSlaveDelList.size(); i++) {
            if(asosSlaveDelList.get(i).getDel_flag().equals(1) && asosSlaveDelList.get(i).getTovar_id().equals(id) && asosSlaveDelList.get(i).getAsos_id().equals(asosId)){
                AsosSlave asosSlave=asosSlaveRepository.findById(asosSlaveDelList.get(i).getKol_ost()).get();
                Integer KolOst=asosSlave.getKol_ost()+asosSlaveDelList.get(i).getKol();
                Integer KolInOst=asosSlave.getKol_in_ost()+asosSlaveDelList.get(i).getKol_in();
                Integer incnt=productsRepository.findById(asosSlaveDelList.get(i).getTovar_id()).get().getKol_in();
                asosSlave.setKol_ost((KolOst*incnt+KolInOst) / incnt);
                asosSlave.setKol_in_ost((KolOst*incnt+KolInOst) % incnt);
                asosSlaveRepository.save(asosSlave);
                asosSlaveDelList.get(i).setDel_flag(delFlag);
                asosSlaveRepository.save(asosSlaveDelList.get(i));
            }
        }

        return true;
    }
    @Override
    public Boolean putProducts(ProductsDto productsDto) {
        AsosSlave asosSlavePut=asosSlaveRepository.findById(productsDto.getId()).get();
        AsosSlave asosSlave=asosSlaveRepository.findById(asosSlavePut.getKol_ost()).get();

        asosSlaveRepository.save(asosSlavePut);
        return true;
    }
    @Override
    public Boolean saveinslave(SlaveDto slaveDto) {
        AsosSlave asosSlavePut=asosSlaveRepository.findById(slaveDto.getId()).get();
        asosSlaveRepository.save(asosSlavePut);
        return true;
    }



}
