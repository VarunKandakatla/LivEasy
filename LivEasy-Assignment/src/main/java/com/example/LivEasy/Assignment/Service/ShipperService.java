package com.example.LivEasy.Assignment.Service;

import com.example.LivEasy.Assignment.DTOs.RequestDTOs.CreateShipper;
import com.example.LivEasy.Assignment.DTOs.ResponseDTOS.ShipperResponseDto;

public interface ShipperService {
    ShipperResponseDto addShipper(CreateShipper createShipper);
}
