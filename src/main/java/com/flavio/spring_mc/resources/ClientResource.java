package com.flavio.spring_mc.resources;

import com.flavio.spring_mc.entities.models.Client;
import com.flavio.spring_mc.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/client")
public class ClientResource {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> find(@PathVariable Integer id) {
        Client obj = clientService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}