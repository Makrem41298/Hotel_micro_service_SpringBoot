package com.service.clientservice.controllers;


import com.service.clientservice.dto.ClientRequestDto;
import com.service.clientservice.dto.ClientResponseDto;
import com.service.clientservice.entities.Client;
import com.service.clientservice.mapper.ClientMapper;
import com.service.clientservice.services.IServiceClient;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final IServiceClient serviceClient;

    public ClientController(IServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }
    @GetMapping
    public ResponseEntity<List<Client>> getAllRooms() {
        return ResponseEntity.ok(serviceClient.getAllClients());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getRoomById(@PathVariable Integer id) {
        Optional<Client> client= serviceClient.getClientById(id);
        if(client.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return serviceClient.getClientById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ClientResponseDto>createRoom(@Valid @RequestBody ClientRequestDto dto ) {
        Client client = ClientMapper.toEntity(dto);
        Client newClient= serviceClient.addNewClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClientResponseDto(newClient));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Client>  updateRoom(@PathVariable Integer id, @RequestBody Client client) {
        Optional<Client> existClient = serviceClient.getClientById(id);
        if(existClient.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.OK).body(serviceClient.updateClient(client,id)) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Integer id) {
        Optional<Client> client= serviceClient.getClientById(id);
        if(client.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        serviceClient.deleteClient(id);
        return ResponseEntity.noContent().build();
    }


}
