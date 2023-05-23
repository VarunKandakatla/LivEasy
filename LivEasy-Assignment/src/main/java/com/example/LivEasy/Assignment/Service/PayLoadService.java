package com.example.LivEasy.Assignment.Service;
import java.util.List;
import com.example.LivEasy.Assignment.DTOs.RequestDTOs.PayLoadRequestDto;
import com.example.LivEasy.Assignment.DTOs.RequestDTOs.UpdatePayLoadRequestDto;
import com.example.LivEasy.Assignment.DTOs.ResponseDTOS.PayLoadResponseDtos;
import com.example.LivEasy.Assignment.Entity.PayLoad;
import com.example.LivEasy.Assignment.Exceptions.PayLoadNotFound;
import com.example.LivEasy.Assignment.Exceptions.ShipperNotFound;

public interface PayLoadService {
    String addLoad(PayLoadRequestDto payLoadRequestDto) throws ShipperNotFound;

    List<PayLoadResponseDtos> getLoadsOfaShipper(String shipperId) throws ShipperNotFound;


    PayLoadResponseDtos getLoadById(int loadId) throws PayLoadNotFound;

    PayLoadResponseDtos updateLoadById(int loadId, UpdatePayLoadRequestDto updatePayLoadRequestDto) throws PayLoadNotFound;

    String deleteLoadById(int loadId) throws PayLoadNotFound;
}
