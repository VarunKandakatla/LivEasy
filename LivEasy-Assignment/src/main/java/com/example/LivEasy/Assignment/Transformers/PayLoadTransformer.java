package com.example.LivEasy.Assignment.Transformers;

import com.example.LivEasy.Assignment.DTOs.RequestDTOs.PayLoadRequestDto;
import com.example.LivEasy.Assignment.DTOs.RequestDTOs.UpdatePayLoadRequestDto;
import com.example.LivEasy.Assignment.DTOs.ResponseDTOS.PayLoadResponseDtos;
import com.example.LivEasy.Assignment.Entity.PayLoad;

public class PayLoadTransformer {

    public static PayLoad PayLoadRequestDtoToPayLoad(PayLoadRequestDto payLoadRequestDto)
    {
        return PayLoad.builder()
                .loadingPoint(payLoadRequestDto.getLoadingPoint())
                .unloadingPoint(payLoadRequestDto.getUnloadingPoint())
                .comment(payLoadRequestDto.getComment())
                .truckType(payLoadRequestDto.getTruckType())
                .weight(payLoadRequestDto.getWeight())
                .numberOfTrucks(payLoadRequestDto.getNoOfTrucks())
                .productType(payLoadRequestDto.getProductType())
                .build();
    }

    public static PayLoadResponseDtos payLoadToPayLoadResponseDto(PayLoad payLoad)
    {
        return PayLoadResponseDtos.builder()
                .shipperId(payLoad.getShipperId().getShipperId())
                .loadingPoint(payLoad.getLoadingPoint())
                .unloadingPoint(payLoad.getUnloadingPoint())
                .noOfTrucks(payLoad.getNumberOfTrucks())
                .productType(payLoad.getProductType())
                .truckType(payLoad.getTruckType())
                .weight(payLoad.getWeight())
                .comment(payLoad.getComment())
                .build();
    }

    public static PayLoad UpdatePayLoadDetails(PayLoad payLoad, UpdatePayLoadRequestDto updatePayLoadRequestDto)
    {
        payLoad.setLoadingPoint(updatePayLoadRequestDto.getLoadingPoint());
        payLoad.setUnloadingPoint(updatePayLoadRequestDto.getUnloadingPoint());
        payLoad.setComment(updatePayLoadRequestDto.getComment());
        payLoad.setTruckType(updatePayLoadRequestDto.getTruckType());
        payLoad.setProductType(updatePayLoadRequestDto.getProductType());
        payLoad.setNumberOfTrucks(updatePayLoadRequestDto.getNoOfTrucks());
        payLoad.setWeight(updatePayLoadRequestDto.getWeight());

        return payLoad;
    }
}
