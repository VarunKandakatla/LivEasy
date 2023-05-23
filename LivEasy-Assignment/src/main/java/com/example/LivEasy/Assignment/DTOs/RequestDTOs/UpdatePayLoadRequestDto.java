package com.example.LivEasy.Assignment.DTOs.RequestDTOs;

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
public class UpdatePayLoadRequestDto {

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
