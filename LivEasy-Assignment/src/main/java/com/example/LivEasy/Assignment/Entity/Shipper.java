package com.example.LivEasy.Assignment.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Shipper {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @CreationTimestamp
    Date date;

    String name;
    String email;
    String shipperId= String.valueOf(UUID.randomUUID());

    @OneToMany(mappedBy = "shipperId",cascade = CascadeType.ALL)
    List<PayLoad> payLoadList;
}
