package com.sinaukoding.abdl.controller;

import com.sinaukoding.abdl.common.Response;
import com.sinaukoding.abdl.entity.dto.PembayaranDTO;
import com.sinaukoding.abdl.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pembayaran")
public class PembayaranController {
    @Autowired
    PembayaranService service;

    @PostMapping
    public Response savePembayaran(@RequestBody PembayaranDTO param){
        return new Response(service.save(param), "Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatDataPembayaran(), "Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id){
        PembayaranDTO data = service.findPembayaranById(id);
        return new Response(data, data == null ? "Pembayaran dengan id tersebut tidak ditemukan" : "Pembayaran berhasil ditampilkan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public Response updateData(@RequestBody PembayaranDTO param, @PathVariable int id){
        return new Response(service.updateDataPembayaran(param, id), "Data berhasil diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteData(@PathVariable int id){
        if (service.deleteDataPembayaran(id)){
            return new Response("Data pembayaran berhasil dihapus", HttpStatus.OK);
        } else {
            return new Response("Data pembayaran gagal dihapus", HttpStatus.OK);
        }
    }
}
