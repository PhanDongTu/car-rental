package com.project.thuexe.repositories;

import com.project.thuexe.models.Car;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByIdXe(Long idXe);
}
