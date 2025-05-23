package com.project.thuexe.repositories;

import com.project.thuexe.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
