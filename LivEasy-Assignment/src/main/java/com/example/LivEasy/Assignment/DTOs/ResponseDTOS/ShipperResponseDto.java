package com.example.LivEasy.Assignment.DTOs.ResponseDTOS;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipperResponseDto {

    String Name;
    String shipperId;
}
