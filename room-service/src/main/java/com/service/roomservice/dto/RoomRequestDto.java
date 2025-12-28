package com.service.roomservice.dto;

import com.service.roomservice.entities.RoomType;
import com.service.roomservice.entities.StatusRoom;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
@Getter @Setter
public class RoomRequestDto {
    @NotNull(message = "Room number is required")
    private Integer number;

    @NotNull(message = "Room type is required")
    private RoomType type;


    private StatusRoom status;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer rating;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

}
