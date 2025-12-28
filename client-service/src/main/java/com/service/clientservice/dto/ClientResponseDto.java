package com.service.clientservice.dto;

import com.service.clientservice.entities.Client;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDateTime createdAt;


    public ClientResponseDto(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
        this.createdAt = client.getCreatedAt();

    }
}
