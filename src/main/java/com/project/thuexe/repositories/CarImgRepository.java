package com.project.thuexe.repositories;

import com.project.thuexe.models.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarImgRepository extends JpaRepository<CarImage,Integer> {
    List<CarImage> findByCarIdXe(Long carIdXe);

}