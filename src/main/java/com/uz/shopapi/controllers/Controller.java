package com.uz.shopapi.controllers;
//2

import com.uz.shopapi.Model.Request.RequestMainSlave;
import com.uz.shopapi.Model.dto.*;
//import com.uz.shopapi.Model.Response.ResponseOdMainSlave;
import com.uz.shopapi.Model.entity.AsosSlave;
import com.uz.shopapi.Model.entity.SlaveMain;
import com.uz.shopapi.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    KatService katService;

    @Autowired
    BrendService BrendService;

    @Autowired
    ZavodService ZavodService;

    @Autowired
    MainService mainService;


    @GetMapping(value = "/{clientid}/{type}/products")
    public List<ProductsDto> getProducts(@PathVariable("type") Integer type, @PathVariable("clientid") Integer clientid) {
        List<ProductsDto> list = productsService.getProducts(type, clientid);
        return list;
    }

    @PutMapping(path = "/editProduct")
    public ResponseEntity<Integer> editProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productsService.editproduct(productDto));
    }

    @GetMapping(value = "/kat")
    public ResponseEntity<List<KatDto>> getKat() {
        List<KatDto> katDtos = katService.get();
        return ResponseEntity.ok(katDtos);
    }

    @GetMapping(value = "/brend")
    public ResponseEntity<List<BrendDto>> getBrend() {
        List<BrendDto> brendDtos = BrendService.get();
        return ResponseEntity.ok(brendDtos);
    }

    @GetMapping(value = "/zavod")
    public ResponseEntity<List<ZavodDto>> getZavod() {
        List<ZavodDto> zavodDtos = ZavodService.get();
        return ResponseEntity.ok(zavodDtos);
    }

    @PostMapping(value = "addproduct")
    public ResponseEntity<Integer> addProduct(@RequestBody ProductDto productDto) {
        Integer result = productsService.addProduct(productDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "delproduct/{id}")
    public ResponseEntity<String> delProduct(@PathVariable("id") Integer id) {
        productsService.del(id);
        return ResponseEntity.ok("O'chirildi");
    }

    @GetMapping(value = "getproduct/{clientid}")
    public ResponseEntity<List<ProductDto>> getProductList(@PathVariable("clientid") Integer clientid) {
        List<ProductDto> list = productsService.getProductList(clientid);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/products/{asosid}")
    public ResponseEntity<List<ProductsDto>> getAddProducts(@PathVariable Integer asosid) {
        List<ProductsDto> list = asosSlaveService.listAddProducts(asosid);
        return ResponseEntity.ok(list);
    }


    @GetMapping(value = "/getKirimSlave/{asosid}")
    public ResponseEntity<List<SlaveDto>> getKirimSlave(@PathVariable Integer asosid) {
        List<SlaveDto> list = asosSlaveService.listGetKirimSlave(asosid);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "asoss")
    public ResponseEntity<List<AsosDto>> get(@RequestBody AsosDto asosDto) {
        List<AsosDto> list = asosService.get(asosDto);
        return ResponseEntity.ok(list);
    }

    @PutMapping(path = "/editasos")
    public ResponseEntity<AsosDto> editAsos(@RequestBody AsosDto asosDto) {
        return ResponseEntity.ok(asosService.editAsos(asosDto));
    }

    @PostMapping(value = "newasos")
    public ResponseEntity<AsosDto> put(@RequestBody AsosDto asosDto) {
        AsosDto asosDtos = asosService.put(asosDto);
        return ResponseEntity.ok(asosDtos);
    }

    @GetMapping(value = "/{clientid}/dillers")
    public ResponseEntity<List<DillerDto>> getDillers(@PathVariable Integer clientid) {
        List<DillerDto> dillerDtos = dillerService.get(clientid);
        return ResponseEntity.ok(dillerDtos);
    }

    @GetMapping(value = "/{clientid}/haridors")
    public ResponseEntity<List<HaridorDto>> getHaridor(@PathVariable Integer clientid) {
        List<HaridorDto> list = haridorService.getHaridor(clientid);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/asos")
    public ResponseEntity<AsosDto> getAsos(@RequestBody AsosDto asosDto) {
        AsosDto asos = asosService.getAsos(asosDto);
        return ResponseEntity.ok(asos);
    }

    @PostMapping(value = "/asosblock")
    public ResponseEntity<String> blockAsos(@RequestBody AsosDto asosDto) {
        asosService.block(asosDto);
        return ResponseEntity.ok("ochirdi");
    }

    @PostMapping(value = "/asosslave/{asosid}/{userid}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Integer> asosSlaveSave(@PathVariable Integer asosid, @PathVariable Integer userid, @RequestBody ProductsDto productsDto) {
        Integer result = asosSlaveService.addProducts(1, asosid, userid, productsDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/asosslave2/{asosid}/{userid}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Integer> asosSlaveSave2(@PathVariable Integer asosid, @PathVariable Integer userid, @RequestBody SlaveDto slaveDto) {
        Integer result = asosSlaveService.addProducts2(1, asosid, userid, slaveDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/asosslaveput/{asosid}/{userid}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Integer> asosSlavePut(@PathVariable Integer asosid, @PathVariable Integer userid, @RequestBody ProductsDto productsDto) {
        asosSlaveService.delProducts(2, asosid, productsDto.getProductId());
        Integer result = asosSlaveService.addProducts(2, asosid, userid, productsDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/delasosslave/{asosid}/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> asosSlaveDelete(@PathVariable Integer asosid, @PathVariable Integer id) {
        Boolean result = asosSlaveService.delProducts(0, asosid, id);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/saveinslave", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> saveinslave(@RequestBody SlaveDto slaveDto) {
        Boolean result = asosSlaveService.saveinslave(slaveDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/putasosslave", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> asosSlavePut(@RequestBody ProductsDto productsDto) {
        Boolean result = asosSlaveService.putProducts(productsDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> list = userService.getUsers();
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<UserDto> getUser(@RequestBody UserDto user) {
        UserDto userDto = userService.checkUser(user);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(path = "/addSerial/{serial}")
    public ResponseEntity<Integer> addSerial(@PathVariable String serial) {
        return ResponseEntity.ok(mainService.addMain(serial));
    }

    @PostMapping(path = "/checkSerialOfMain")
    public ResponseEntity<Integer> checkMainSerial(@RequestParam("serial") String serial, @RequestParam("check") Integer check) {
        return ResponseEntity.ok(mainService.checkMainSerial(serial, check));
    }

    @GetMapping(value = "/getAsosSlave/{tovarid}")
    public ResponseEntity<List<AsosSlave>> getAsosSlave(@PathVariable Integer tovarid) {
        List<AsosSlave> list = asosSlaveService.listGetAsosSlave(tovarid); //listAddProducts(asosid);
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/getMainSlave/{slaveId}")
    public ResponseEntity<List<SlaveMain>>getMainSlave(@PathVariable Integer slaveId) {
        List<SlaveMain> list = mainService.getMainSlavesSlaveId(slaveId);
        return ResponseEntity.ok(list);
     }

    @PostMapping(path = "/addMainSlave")
    public ResponseEntity<Integer> addMainSlave(@RequestBody RequestMainSlave requestMainSlave) {
        return ResponseEntity.ok(mainService.addMainSlave(requestMainSlave));
    }
    // mayli yana qoshdim
    @DeleteMapping(path = "/delMainSlave/{id}")
    public ResponseEntity<Integer> deleteMainSlave(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(mainService.deleteMainSlave(id));
    }
}
