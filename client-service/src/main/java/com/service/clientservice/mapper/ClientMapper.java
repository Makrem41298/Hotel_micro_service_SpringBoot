package com.service.clientservice.mapper;

import com.service.clientservice.dto.ClientRequestDto;
import com.service.clientservice.entities.Client;


public class ClientMapper {
    public static Client toEntity(ClientRequestDto dto) {
        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setEmail(dto.getEmail());
        client.setPhone(dto.getPhone());
        // active defaults to true (entity default)
        return client;
    }
}
