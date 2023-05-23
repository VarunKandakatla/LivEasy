package com.example.LivEasy.Assignment.DTOs.RequestDTOs;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CreateShipper {

    String shipperName;
    String email;
}
