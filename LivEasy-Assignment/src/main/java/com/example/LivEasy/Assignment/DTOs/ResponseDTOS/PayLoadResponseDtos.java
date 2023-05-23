package com.example.LivEasy.Assignment.DTOs.ResponseDTOS;

import com.example.LivEasy.Assignment.Enum.ProductType;
import com.example.LivEasy.Assignment.Enum.TruckType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PayLoadResponseDtos
{
    String shipperId;
    String loadingPoint;
    String unloadingPoint;
    @Enumerated(EnumType.STRING)
    ProductType productType;
    @Enumerated(EnumType.STRING)
    TruckType truckType;
    int noOfTrucks;
    int weight;
    String comment;
}
