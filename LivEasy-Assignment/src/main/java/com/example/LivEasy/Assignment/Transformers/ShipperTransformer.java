package com.example.LivEasy.Assignment.Transformers;

import com.example.LivEasy.Assignment.DTOs.RequestDTOs.CreateShipper;
import com.example.LivEasy.Assignment.DTOs.ResponseDTOS.ShipperResponseDto;
import com.example.LivEasy.Assignment.Entity.Shipper;

import java.util.ArrayList;

public class ShipperTransformer {

    public static Shipper createShippertoShipper(CreateShipper createShipper)
    {
        Shipper shipper=new Shipper();
                shipper.setName(createShipper.getShipperName());
                shipper.setEmail(createShipper.getEmail());
                shipper.setPayLoadList(new ArrayList<>());

                return shipper;
    }

    public static ShipperResponseDto shipperToShipperResponseDto(Shipper shipper)
    {
        return ShipperResponseDto.builder()
                .Name(shipper.getName())
                .shipperId(shipper.getShipperId())
                .build();
    }
}
