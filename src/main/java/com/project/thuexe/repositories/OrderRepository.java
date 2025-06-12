package com.project.thuexe.repositories;

import com.project.thuexe.models.Car;
import com.project.thuexe.models.Order;
import com.project.thuexe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByIdDonThue(Long idDonThue);

    Optional<Order> findByIdXe(Car idXe);

    List<Order> findByIdKhachThue(User idKhachThue);

}
