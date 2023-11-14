package com.projetos.clientes.controller;


import com.projetos.clientes.dto.ClientDTO;
import com.projetos.clientes.entities.Client;
import com.projetos.clientes.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity <Page<ClientDTO>> findAll(Pageable pageable){
        Page<ClientDTO> page = service.findAll(pageable);
        return ResponseEntity.ok(page);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <ClientDTO> findById( @Valid @PathVariable Long id){
        ClientDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);

    }


}
