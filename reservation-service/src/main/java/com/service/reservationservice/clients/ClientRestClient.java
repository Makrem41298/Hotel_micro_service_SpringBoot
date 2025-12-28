package com.service.reservationservice.clients;

import com.service.reservationservice.Model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping("/api/clients/{id}")
    Optional<Client> getClientById(@PathVariable int id);
}
