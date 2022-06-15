package com.sinaukoding.abdl.controller;

import com.sinaukoding.abdl.common.Response;
import com.sinaukoding.abdl.entity.dto.PembeliDTO;
import com.sinaukoding.abdl.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pembeli")
public class PembeliController {
    @Autowired
    PembeliService service;

    @PostMapping
    public Response savePembeli(@RequestBody PembeliDTO param){
        return new Response(service.save(param), "Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatDataPembeli(), "Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id){
        PembeliDTO data = service.findPembeliById(id);
        return new Response(data, data == null ? "Data dengan id tersebut tidak ditemukan" : "Data berhasil ditampilkan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public Response updateData(@RequestBody PembeliDTO param, @PathVariable int id){
        return new Response(service.updateDataPembeli(param, id), "Data berhasil diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteData(@PathVariable int id){
        if (service.deleteDataPembeli(id)){
            return new Response("Data pembeli berhasil dihapus", HttpStatus.OK);
        } else {
            return new Response("Data gagal dihapus", HttpStatus.OK);
        }
    }
}
