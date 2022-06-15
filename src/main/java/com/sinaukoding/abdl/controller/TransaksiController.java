package com.sinaukoding.abdl.controller;

import com.sinaukoding.abdl.common.Response;
import com.sinaukoding.abdl.entity.dto.TransaksiDTO;
import com.sinaukoding.abdl.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TransaksiController {

    @Autowired
    TransaksiService service;

    @PostMapping
    public Response save(@RequestBody TransaksiDTO param){
        return new Response(service.save(param), "Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatDataTransaksi(), "Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id){
        TransaksiDTO data = service.findTransaksiById(id);
        return new Response(data, data != null ? "Data berhasil ditampilkan" : "Data dengan id tersebut tidak ditemukan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public Response updateData(@RequestBody TransaksiDTO param, @PathVariable int id){
        return new Response(service.updateDataTransaksi(param, id), "Data berhasil diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteData(@PathVariable int id){
        if (service.deleteDataTransaksi(id)){
            return new Response("Data berhasil dihapus", HttpStatus.OK);
        } else {
            return new Response("Data gagal dihapus", HttpStatus.OK);
        }
    }
}
