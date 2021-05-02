package com.uz.shopapi.Service.impl;

import com.uz.shopapi.Model.dto.ProductDto;
import com.uz.shopapi.Model.dto.ProductsDto;
import com.uz.shopapi.Model.entity.Asos;
import com.uz.shopapi.Model.entity.AsosSlave;
import com.uz.shopapi.Model.entity.Client;
import com.uz.shopapi.Model.entity.Product;
import com.uz.shopapi.repository.AsosRepository;
import com.uz.shopapi.repository.AsosSlaveRepository;
import com.uz.shopapi.repository.ClientRepository;
import com.uz.shopapi.repository.ProductsRepository;
import com.uz.shopapi.Service.ProductsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceimpl implements ProductsService{
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AsosRepository asosRepository;
    @Autowired
    AsosSlaveRepository asosSlaveRepository;
    @Override
    public List<ProductsDto> getProducts(Integer type,Integer clientId){
        List<ProductsDto> list=new ArrayList<>();
        Client client=clientRepository.findClientById(clientId);
        if (client.getDollar().equals(1))
            type=7;
        /*
         * Chakana
         * Opt1
         * opt2
         *
         * */
        List<Object[]> objects;
        if(type==1)
            objects=productsRepository.selectChakanaProducts(clientId);
        else if(type==2)
            objects=productsRepository.selectOptom1Products(clientId);
        else if(type==3)
            objects=productsRepository.selectOptom2Products(clientId);
        else if (type==4)
            objects=productsRepository.selectOptom1PlasProducts(clientId);
        else if (type==5)
            objects=productsRepository.selectOptom2PlasProducts(clientId);
        else if (type==6)
            objects=productsRepository.selectBankSchetProducts(clientId);
        else if (type ==7 )
            objects=productsRepository.selectDolerProducts(clientId);
        else
            objects=productsRepository.selectChakanaProducts(clientId);

        for (int i=0;i < objects.size();i++){
            Object[] object=objects.get(i);
            ProductsDto productsDto=new ProductsDto();

            productsDto.setId((int)object[0]);

            productsDto.setProductId((int)object[1]);

            if(object[2]!=null)
                productsDto.setName((String)object[2]);
            else
                productsDto.setName("Номи йўқ");

            if(object[3]!=null)
                productsDto.setCount(((BigDecimal)object[3]).intValue());
            else
                productsDto.setCount(0);

            if(object[4]!=null)
                productsDto.setIncount(((BigDecimal)object[4]).intValue());
            else
                productsDto.setIncount(0);

            if(object[5]!=null)
                productsDto.setPrice( (Double) object[5] );
            else
                productsDto.setPrice(0.0);
            if(object[6]!=null)
                productsDto.setInprice( (Double)object[6] );
            else
                productsDto.setInprice(0.0);
            if(object[7]!=null)
                productsDto.setShtrix((String)object[7]);
            else
                productsDto.setShtrix("");
            if(object[8]!=null){
                productsDto.setIncnt((Integer) object[8]);
            }
            else{
                productsDto.setIncnt(1);
            }
            if(type==7) {
                if (object[9] != null) {
                    productsDto.setSena_d((Double) object[9]);
                } else {
                    productsDto.setSena_d(0.0);
                }
                if (object[10] != null) {
                    productsDto.setSena_in_d((Double) object[10]);
                } else {
                    productsDto.setSena_in_d(0.0);
                }
            }
            if (object[(object.length -1)]!=null)
                productsDto.setShtrix_full((String)object[(object.length -1)]);
            else
                productsDto.setShtrix_full("");

            list.add(productsDto);
        }
        return list;
    }

    @Override
    public Integer addProduct(ProductDto productDto) {
        Product product=new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setDel_flag(1);
        if (product.getKat()==null)
        {
            product.setKat(0);
        }
        Integer lastProductId=0;
        lastProductId = productsRepository.save(product).getId();
        AsosSlave asosSlave=new AsosSlave();
        asosSlave.setTovar_id(product.getId());
        if (product.getTkol()+product.getTkol_in()>0){
            Asos asos=asosRepository.findAsosByTur_oper(5);
            asosSlave.setAsos_id(asos.getId());
            asosSlave.setUser_id(product.getUser_id());
            asosSlave.setKol(product.getTkol());
            asosSlave.setKolIn(product.getTkol_in());
            asosSlave.setDel_flag(1);
            asosSlave.setKolOst(product.getTkol());
            asosSlave.setKolInOst(product.getTkol_in());
            asosSlave.setResept(0);
            asosSlave.setSubkod(0);
            asosSlave.setSumma_all_ost(0.0);
            asosSlave.setSumma_all(0.0);
            asosSlave.setSumma_in(0.0);
            asosSlave.setTuri(0);
            if (product.getSotish()>0){
                asosSlave.setSotish(product.getSotish());
            }else{

                asosSlave.setSotish(0.0);
            }
            lastProductId=asosSlaveRepository.save(asosSlave).getId();

        }

        return lastProductId;
    }

    @Override
    public List<ProductDto> getProductList(Integer clientId) {
        List<Product> productList=productsRepository.findByDel_flag(1);
//        List<ProductDto> producDtoList =new ArrayList<>();
//
//        for (int i = 0; i <= productList.size(); i++) {
//            ProductDto productDto=new ProductDto();
//            BeanUtils.copyProperties(producDtoList.get(i), productDto);
//            producDtoList.add(productDto);
//        }
        List<ProductDto> list=new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getClient_id()==clientId ) {
                if(productList.get(i).getDel_flag()==1){
                    ProductDto dto=new ProductDto();

                    BeanUtils.copyProperties(productList.get(i), dto);
                    list.add(dto);
                }
            }
        }
        return list ; //producDtoList;
    }

    @Override
    public void del(Integer id) {

        Product product=productsRepository.findById(id).get();
        product.setDel_flag(0);

    }

    @Override
    public Integer editproduct(ProductDto productDto) {
        Product product = productsRepository.findById(productDto.getId()).get();
        if (product !=null){
            BeanUtils.copyProperties(productDto, product);
            productsRepository.save(product);
        }
        return productDto.getId();
    }


    public void copyProperties(Product product,ProductDto productDto ){
        if (product.getId() != null){
            productDto.setId(product.getId());
        }
        else {
            productDto.setId(0);
        }
        if (product.getNom() != null){
            productDto.setNom(product.getNom());
        }
        else {
            productDto.setNom("");
        }
        if (product.getNom_ru() != null){
            productDto.setNom_ru(product.getNom_ru());
        }
        else {
            productDto.setNom_ru("");
        }
        if (product.getNom_sh() != null){
            productDto.setNom_sh(product.getNom_sh());

        }else{
            productDto.setNom_sh(product.getNom_sh());
        }
        if (product.getShtrix() != null){
            productDto.setShtrix(product.getShtrix());
        }
        else {
            productDto.setShtrix("");
        }
        if (product.getShtrix_in() != null){
            productDto.setShtrix_in(product.getShtrix_in());
        }
        else {
            productDto.setShtrix_in("");
        }

        if (product.getTz_id() != null){
            productDto.setTz_id(product.getTz_id());
        }
        else{
            productDto.setTz_id(1);
        }
        if (product.getKg() != null){
            productDto.setKg(product.getKg());
        }
        else {
            productDto.setKg(0);
        }
        if (product.getShtrix_full() != null){
            productDto.setShtrix_full(product.getShtrix_full());
        }
        if (product.getShtrix1() != null){
            productDto.setShtrix1(product.getShtrix1());
        }
        else {
            productDto.setShtrix1("");
        }
        if (product.getShtrix2() != null){
            productDto.setShtrix2(product.getShtrix2());
        }
        else {
            productDto.setShtrix2("");
        }
        if (product.getKat() != null){
            productDto.setKat(product.getKat());
        }
        else {
            productDto.setKat(0);
        }
        if (product.getBrend() != null){
            productDto.setBrend(product.getBrend());
        }
        else {
            productDto.setBrend(1);
        }
        if (product.getPapka() != null){
            productDto.setPapka(product.getPapka());
        }
        else {
            productDto.setPapka(0);
        }
        if (product.getQr() != null){
            productDto.setQr(product.getQr());
        }
        else {
            productDto.setQr("");
        }
        if (product.getShtrixkod() != null){
            productDto.setShtrixkod(product.getShtrixkod());
        }
        else {
            productDto.setShtrixkod(0);
        }
        if (product.getQrkod() != null){
            productDto.setQrkod(product.getQrkod());
        }
        else {
            productDto.setQrkod("");
        }
        if (product.getIzm_id() != null){
            productDto.setIzm_id(product.getIzm_id());
        }
        else {
            productDto.setIzm_id(product.getIzm_id());
        }
        if (product.getDel_flag() != null){
            productDto.setDel_flag(product.getDel_flag());
        }
        else {
            productDto.setDel_flag(product.getDel_flag());
        }
        if (product.getClient_id() != null){
            productDto.setClient_id(product.getClient_id());
        }
        else {
            productDto.setClient_id(0);
        }

        if (product.getSotish() != null){
            productDto.setSotish(product.getSotish());
        }
        else {
            productDto.setSotish(0.0);
        }
        if (product.getUlg1() != null){
            productDto.setUlg1(product.getUlg1());
        }
        else {
            productDto.setUlg1(0.0);
        }
        if (product.getUlg1_pl() != null){
            productDto.setUlg1_pl(product.getUlg1_pl());
        }
        else {
            productDto.setUlg1_pl(0.0);
        }
        if (product.getUlg2() != null) {
            productDto.setUlg2(product.getUlg2());
        }
        else {
            productDto.setUlg2(0.0);
        }
        if (product.getUlg2_pl() != null){
            productDto.setUlg2_pl(product.getUlg2_pl());
        }
        else {
            productDto.setUlg2_pl(0.0);
        }
        if (product.getBank() != null){
            productDto.setBank(product.getBank());
        }
        else {
            productDto.setBank(0.0);

        }
        if (product.getSena() != null){
            productDto.setSena(product.getSena());
        }
        else {
            productDto.setSena(0.0);
        }
        if (product.getSena_d() != null){
            productDto.setSena_d(product.getSena_d());
        }
        else {
            productDto.setSena_d(0.0);
        }
        if (product.getSena_in_d() != null){
            productDto.setSena_in_d(product.getSena_in_d());
        }
        else {
            productDto.setSena_in_d(0.0);
        }
        if (product.getKol_in() != null){
            productDto.setKol_in(product.getKol_in());
        }
        else {
            productDto.setKol_in(0);
        }
    }

}
