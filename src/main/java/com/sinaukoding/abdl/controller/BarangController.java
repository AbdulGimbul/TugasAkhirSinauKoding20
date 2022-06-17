package com.sinaukoding.abdl.controller;

import com.sinaukoding.abdl.common.Response;
import com.sinaukoding.abdl.entity.dto.BarangDTO;
import com.sinaukoding.abdl.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/barang")
public class BarangController {
    @Autowired
    BarangService service;

    @PostMapping
    public Response saveBarang(@RequestBody BarangDTO param){
        return new Response(service.save(param), "Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatDataBarang(), "Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id){
        BarangDTO data = service.findBarangById(id);
        return new Response(data, data == null ? "Barang tidak ditemukan" : "Barang ditemukan", HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-name")
    public Response findByName(@RequestParam(value = "name") String name){
        List<BarangDTO> data = service.findBarangByNama(name);
        return new Response(data, data != null ? "Data berhasil ditampilkan" : "Data tidak ditemukan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public Response updateData(@RequestBody BarangDTO param, @PathVariable int id){
        return new Response(service.updateDataBarang(param, id), "Data berhasil diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteData(@PathVariable int id){
        if (service.deleteDataBarang(id)){
            return new Response("Data barang berhasil dihapus", HttpStatus.OK);
        } else {
            return new Response("Data barang gagal dihapus", HttpStatus.OK);
        }
    }

}
