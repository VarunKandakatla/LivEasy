package com.example.LivEasy.Assignment.Repository;

import com.example.LivEasy.Assignment.Entity.PayLoad;
import com.example.LivEasy.Assignment.Entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper,Integer> {

    Shipper findByShipperId(String UUID);

}
