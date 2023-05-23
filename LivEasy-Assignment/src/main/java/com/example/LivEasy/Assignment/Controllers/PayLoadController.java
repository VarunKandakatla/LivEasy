package com.example.LivEasy.Assignment.Controllers;

import com.example.LivEasy.Assignment.DTOs.RequestDTOs.PayLoadRequestDto;
import com.example.LivEasy.Assignment.DTOs.RequestDTOs.UpdatePayLoadRequestDto;
import com.example.LivEasy.Assignment.Exceptions.PayLoadNotFound;
import com.example.LivEasy.Assignment.Exceptions.ShipperNotFound;
import com.example.LivEasy.Assignment.Service.PayLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payload")
public class PayLoadController {

    @Autowired
    PayLoadService payLoadService;

    @PostMapping("/load")
    public ResponseEntity addLoad(@RequestBody PayLoadRequestDto payLoadRequestDto)
    {
        try
        {
            return new ResponseEntity<>(payLoadService.addLoad(payLoadRequestDto), HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/load")
    public ResponseEntity getLoadsOfaShipper(@RequestParam String shipperId)  {
        try
        {
            return new ResponseEntity<>(payLoadService.getLoadsOfaShipper(shipperId),HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/load/{loadId}")
    public ResponseEntity getLoadById(@PathVariable("loadId") int loadId){
        try
        {
            return new ResponseEntity<>(payLoadService.getLoadById(loadId),HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }

    @PutMapping("/load/{loadId}")
    public ResponseEntity updateLoadById(@PathVariable("loadId") int loadId,@RequestBody UpdatePayLoadRequestDto updatePayLoadRequestDto)
    {
        try
        {
            return new ResponseEntity<>(payLoadService.updateLoadById(loadId, updatePayLoadRequestDto),HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/load/{loadId}")
    public ResponseEntity deleteLoadById(@PathVariable("loadId") int loadId)
    {
        try
        {
            return new ResponseEntity<>(payLoadService.deleteLoadById(loadId),HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }
}
