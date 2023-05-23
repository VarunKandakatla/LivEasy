package com.example.LivEasy.Assignment.Service.Impl;

import com.example.LivEasy.Assignment.DTOs.RequestDTOs.CreateShipper;
import com.example.LivEasy.Assignment.DTOs.ResponseDTOS.ShipperResponseDto;
import com.example.LivEasy.Assignment.Entity.Shipper;
import com.example.LivEasy.Assignment.Repository.ShipperRepository;
import com.example.LivEasy.Assignment.Service.ShipperService;
import com.example.LivEasy.Assignment.Transformers.ShipperTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipperImpl implements ShipperService {

    @Autowired
    ShipperRepository shipperRepository;

    @Override
    public ShipperResponseDto addShipper(CreateShipper createShipper) {

//        Creating Shipper with given paramneters
        Shipper shipper= ShipperTransformer.createShippertoShipper(createShipper);

//        Save this Shipper
        Shipper savedShipper=shipperRepository.save(shipper);

//        Return shipper Id
        ShipperResponseDto shipperResponseDto= ShipperTransformer.shipperToShipperResponseDto(savedShipper);

        return shipperResponseDto;
    }
}
