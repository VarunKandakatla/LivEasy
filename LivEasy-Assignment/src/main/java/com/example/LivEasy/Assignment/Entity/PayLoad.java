package com.example.LivEasy.Assignment.Entity;

import com.example.LivEasy.Assignment.Enum.ProductType;
import com.example.LivEasy.Assignment.Enum.TruckType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class PayLoad {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String loadingPoint;
    String unloadingPoint;
    @Enumerated(EnumType.STRING)
    ProductType productType;

    @Enumerated(EnumType.STRING)
    TruckType truckType;

    int numberOfTrucks;

    int weight;

    String comment;
    @ManyToOne@JoinColumn
    Shipper shipperId;

    @UpdateTimestamp
    Date date;

}
