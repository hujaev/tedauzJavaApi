package com.uz.shopapi.controllers;

import com.uz.shopapi.Request.RequestMainSlave;
import com.uz.shopapi.Response.ResponseOdMainSlave;
import com.uz.shopapi.dto.*;
import com.uz.shopapi.entity.User;
import com.uz.shopapi.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@RestController
@RequestMapping( value="/application/json")
public class Controller {
    @Autowired
    ProductsService productsService;

    @Autowired
    AsosService asosService;

    @Autowired
    UserService userService;

    @Autowired
    AsosSlaveService asosSlaveService;

    @Autowired
    HaridorService haridorService;
    @Autowired
    DillerService dillerService;

    @Autowired
    MainService mainService;


    @GetMapping(value = "/{clientid}/{type}/products")
    public List<ProductsDto> getProducts(@PathVariable("type") Integer type,@PathVariable("clientid") Integer  clientid){
        List<ProductsDto> list=productsService.getProducts(type,clientid);

        return list;

    }


    @PostMapping(value = "addproduct")
    public ResponseEntity<Integer> addProduct(@RequestBody ProductDto productDto){
        Integer result=productsService.addProduct(productDto);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping(value = "delproduct/{id}")
    public ResponseEntity<String> delProduct(@PathVariable("id") Integer id){
        productsService.del(id);
        return ResponseEntity.ok("O'chirildi");
    }
    @GetMapping(value = "getproduct/{clientid}")
    public ResponseEntity<List<ProductDto>> getProductList(@PathVariable("clientid") Integer clientid){
        List<ProductDto> list=productsService.getProductList(clientid);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{asosid}/products")
    public ResponseEntity<List<ProductsDto>> getAddProducts(@PathVariable Integer asosid){
        List<ProductsDto> list=asosSlaveService.listAddProducts(asosid);
        return ResponseEntity.ok(list);
    }
    @PostMapping(value = "asoss")
    public ResponseEntity<List<AsosDto>> get(@RequestBody AsosDto asosDto){
        List<AsosDto> list=asosService.get(asosDto);
        return ResponseEntity.ok(list);
    }
    @PostMapping(value = "newasos")
    public ResponseEntity<AsosDto> put(@RequestBody AsosDto asosDto){
        AsosDto asosDtos=asosService.put(asosDto);
        return ResponseEntity.ok(asosDtos);
    }
    @GetMapping(value = "clientid={clientid}/dillers")
    public ResponseEntity<List<DillerDto>> getDillers(@PathVariable Integer  clientid){
        List<DillerDto> dillerDtos=dillerService.get(clientid);
        return ResponseEntity.ok(dillerDtos);
    }


    @GetMapping(value = "/clientid={clientid}/harodors")
    public ResponseEntity<List<HaridorDto>> getHaridor(@PathVariable Integer  clientid){
       List<HaridorDto> list=haridorService.getHaridor(clientid);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/asos")
    public ResponseEntity<AsosDto> getAsos(@RequestBody AsosDto asosDto){
        AsosDto asos=asosService.getAsos(asosDto);
        return ResponseEntity.ok(asos);
    }

    @PostMapping(value = "/asosblock")
    public ResponseEntity<String> blockAsos(@RequestBody AsosDto asosDto){
        asosService.block(asosDto);
        return ResponseEntity.ok("ochirdi");
    }


    @PostMapping(value="/asosslave/asosid={asosid}/userid={userid}",produces = "application/json;charset=UTF-8")
    public ResponseEntity<Integer> asosSlaveSave(@PathVariable Integer asosid, @PathVariable Integer userid,@RequestBody ProductsDto productsDto) {
        Integer result=asosSlaveService.addProducts(1,asosid,userid,productsDto);
        return  ResponseEntity.ok(result);
    }
    @PostMapping(value="/asosslave2/asosid={asosid}/userid={userid}",produces = "application/json;charset=UTF-8")
    public ResponseEntity<Integer> asosSlaveSave2(@PathVariable Integer asosid, @PathVariable Integer userid,@RequestBody ProductsDto productsDto) {
        Integer result=asosSlaveService.addProducts2(1,asosid,userid,productsDto);
        return  ResponseEntity.ok(result);
    }


    @PostMapping(value="/asosslaveput/asosid={asosid}/userid={userid}",produces = "application/json;charset=UTF-8")
    public ResponseEntity<Integer> asosSlavePut(@PathVariable Integer asosid, @PathVariable Integer userid,@RequestBody ProductsDto productsDto) {
        asosSlaveService.delProducts(2,asosid,productsDto.getProductId());
        Integer result=asosSlaveService.addProducts(2,asosid,userid,productsDto);
        return  ResponseEntity.ok(result);
    }

    @DeleteMapping(value="/delasosslave/asosid={asosid}/id={id}",produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> asosSlaveDelete(@PathVariable Integer asosid,@PathVariable Integer id) {
        Boolean result=asosSlaveService.delProducts(0,asosid,id);
        return  ResponseEntity.ok(result);
    }
    @PutMapping(value="/putasosslave",produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> asosSlavePut(@RequestBody ProductsDto productsDto) {
        Boolean result=asosSlaveService.putProducts(productsDto);
        return  ResponseEntity.ok(result);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> list=userService.getUsers();
        return ResponseEntity.ok(list);
    }
    @PostMapping(value = "/user")
    public ResponseEntity<UserDto> getUser(@RequestBody UserDto user){
        UserDto userDto=userService.checkUser(user);
        return  ResponseEntity.ok(userDto);
    }

    @PostMapping(path = "/addSerial/{serial}")
    public ResponseEntity<Integer> addSerial(@PathVariable String serial){
        return ResponseEntity.ok(mainService.addMain(serial));
    }

    @PostMapping(path = "/checkSerialOfMain")
    public ResponseEntity<Integer> checkMainSerial(@RequestParam("serial") String serial,@RequestParam("check") Integer check){
        return ResponseEntity.ok(mainService.checkMainSerial(serial, check));
    }

    @GetMapping(path = "/getMainSlave/{slaveid}")
    public ResponseEntity<List<ResponseOdMainSlave>> getMainSlave(@PathVariable int slaveid){
        return ResponseEntity.ok(mainService.getMainSlaves(slaveid));
    }
    @PostMapping(path = "/addMainSlave")
    public ResponseEntity<Integer> addMainSlave(@RequestBody RequestMainSlave requestMainSlave){
        return ResponseEntity.ok(mainService.addMainSlave(requestMainSlave));
    }




}
