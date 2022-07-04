package com.univas.JoseRodolfo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.univas.JoseRodolfo.Service.SalesmanService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class SalesmanController {

    @Autowired
    private SalesmanService service;
    private SalesmanRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SalesmanResponse> create(@RequestBody SalesmanRequest request){
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<SalesmanResponse>> getAll(){
    return ResponseEntity.ok(service.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Salesman> getMessageById(@PathVariable String id) {
        return ResponseEntity.ok(service.getFromId(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<SalesmanResponse> updateSalesman(@RequestBody SalesmanRequest request, @PathVariable String id){
        return ResponseEntity.ok(service.updateSalesman(request, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSalesman(@PathVariable String id){
        service.deleteSalesman(id);
    }

}
