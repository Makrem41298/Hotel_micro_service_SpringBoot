package com.service.clientservice.services;


import com.service.clientservice.entities.Client;

import java.util.List;
import java.util.Optional;

public interface IServiceClient {


    public List<Client> getAllClients();
    public Optional<Client> getClientById(Integer id);
    public Client addNewClient(Client room);
    public Client updateClient(Client room, Integer id);
    public void deleteClient(Integer id);
}
