package com.example.LivEasy.Assignment.Service.Impl;

import com.example.LivEasy.Assignment.DTOs.RequestDTOs.PayLoadRequestDto;
import com.example.LivEasy.Assignment.DTOs.RequestDTOs.UpdatePayLoadRequestDto;
import com.example.LivEasy.Assignment.DTOs.ResponseDTOS.PayLoadResponseDtos;
import com.example.LivEasy.Assignment.Entity.PayLoad;
import com.example.LivEasy.Assignment.Entity.Shipper;
import com.example.LivEasy.Assignment.Exceptions.PayLoadNotFound;
import com.example.LivEasy.Assignment.Exceptions.ShipperNotFound;
import com.example.LivEasy.Assignment.Repository.PayLoadRepository;
import com.example.LivEasy.Assignment.Repository.ShipperRepository;
import com.example.LivEasy.Assignment.Service.PayLoadService;
import com.example.LivEasy.Assignment.Transformers.PayLoadTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayLoadImpl implements PayLoadService {
    @Autowired
    PayLoadRepository payLoadRepository;

    @Autowired
    ShipperRepository shipperRepository;

    @Override
    public String addLoad(PayLoadRequestDto payLoadRequestDto) throws ShipperNotFound {

//        Check whether shipperId is valid or not;
        Shipper shipper;

        try
        {
            shipper=shipperRepository.findByShipperId(payLoadRequestDto.getShipperId());
        }catch (Exception e)
        {
            throw new ShipperNotFound("Invalid Shipper Details");
        }

//        Creating Load

        PayLoad payLoad= PayLoadTransformer.PayLoadRequestDtoToPayLoad(payLoadRequestDto);

//        Setting payload to shipper
        payLoad.setShipperId(shipper);
        shipper.getPayLoadList().add(payLoad);

//        Saves both repos
        shipperRepository.save(shipper);

        return "loads details added successfully";

    }

    @Override
    public List<PayLoadResponseDtos> getLoadsOfaShipper(String shipperId) throws ShipperNotFound {

        //        Check whether shipperId is valid or not;
        Shipper shipper;

        try
        {
            shipper=shipperRepository.findByShipperId(shipperId);
        }catch (Exception e)
        {
            throw new ShipperNotFound("Invalid Shipper Details");
        }

        List<PayLoadResponseDtos> list=new ArrayList<>();

        for(PayLoad payLoad : shipper.getPayLoadList())
        {
            list.add(PayLoadTransformer.payLoadToPayLoadResponseDto(payLoad));
        }

        return list;

    }

    @Override
    public PayLoadResponseDtos getLoadById(int loadId) throws PayLoadNotFound {

//        Check whether the Id is right or not

        PayLoad payLoad;

        try
        {
            payLoad=payLoadRepository.findById(loadId).get();
        }catch (Exception e)
        {
            throw new PayLoadNotFound("Invalid LoadId! Try Again!!!");
        }

//        returning load details
        return PayLoadTransformer.payLoadToPayLoadResponseDto(payLoad);
    }

    @Override
    public PayLoadResponseDtos updateLoadById(int loadId, UpdatePayLoadRequestDto updatePayLoadRequestDto) throws PayLoadNotFound {

        //        Check whether the Id is right or not

        PayLoad payLoad;

        try
        {
            payLoad=payLoadRepository.findById(loadId).get();
        }catch (Exception e)
        {
            throw new PayLoadNotFound("Load Not Found!");
        }

//        Updating
        PayLoad updatedPayLoad=PayLoadTransformer.UpdatePayLoadDetails(payLoad,updatePayLoadRequestDto);

//        Saving to DataBase
        PayLoad savedPayLoad=payLoadRepository.save(updatedPayLoad);

        return PayLoadTransformer.payLoadToPayLoadResponseDto(savedPayLoad);

    }

    @Override
    public String deleteLoadById(int loadId) throws PayLoadNotFound {
        //        Check whether the Id is right or not

        PayLoad payLoad;
        try
        {
            payLoad=payLoadRepository.findById(loadId).get();
        }catch (Exception e)
        {
            throw new PayLoadNotFound("Invalid LoadId");
        }

        payLoadRepository.delete(payLoad);

        return "Successfully Deleted!";
    }

}
