package com.sinaukoding.abdl.controller;

import com.sinaukoding.abdl.common.Response;
import com.sinaukoding.abdl.entity.dto.SupplierDTO;
import com.sinaukoding.abdl.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    SupplierService service;

    @PostMapping
    public Response saveSupplier(@RequestBody SupplierDTO param){
        return new Response(service.save(param), "Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatDataSupplier(), "Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id){
        SupplierDTO data = service.findSupplierById(id);
        return new Response(data, data == null ? "Data dengan id tersebut tidak ditemukan" : "Data berhasil ditampikan", HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-name")
    public Response findByName(@RequestParam(value = "name") String name){
        List<SupplierDTO> data = service.findSupplierByNama(name);
        return new Response(data, data != null ? "Data berhasil ditampilkan" : "Data tidak ditemukan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public Response updateData(@RequestBody SupplierDTO param, @PathVariable int id){
        return new Response(service.updateDataSupplier(param, id), "Data berhasil diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteData(@PathVariable int id){
        if (service.deleteDataSupplier(id)){
            return new Response("Data berhasil dihapus", HttpStatus.OK);
        } else {
            return new Response("Data gagal dihapus", HttpStatus.OK);
        }
    }
}
