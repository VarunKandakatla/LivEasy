package com.example.LivEasy.Assignment.Controllers;

import com.example.LivEasy.Assignment.DTOs.RequestDTOs.CreateShipper;
import com.example.LivEasy.Assignment.Service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipper")
public class ShipperController {

    @Autowired
    ShipperService shipperService;

    @PostMapping("/addShipper")
    public ResponseEntity addShipper(@RequestBody CreateShipper createShipper)
    {
        return new ResponseEntity<>(shipperService.addShipper(createShipper), HttpStatus.ACCEPTED);
    }
}
