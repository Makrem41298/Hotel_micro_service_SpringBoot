package com.service.clientservice.services;


import com.service.clientservice.entities.Client;
import com.service.clientservice.repository.ClientRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter @Getter

public class ClientService implements IServiceClient {
    private ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    @Override
    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }
    @Override
    public Client addNewClient(Client client) {
        return clientRepository.save(client);
    }
    @Override
    public Client updateClient(Client room, Integer id) {
        room.setId(id);
        return clientRepository.save(room) ;
    }
    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }


}
