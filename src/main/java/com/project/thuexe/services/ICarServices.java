package com.project.thuexe.services;

import com.project.thuexe.Response.CarResponse;
import com.project.thuexe.dtos.CarDTO;
import com.project.thuexe.dtos.CarImageDTO;
import com.project.thuexe.exceoptions.DataNotFoundException;
import com.project.thuexe.models.Car;
import com.project.thuexe.models.CarImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICarServices {
   public Car createCar(CarDTO car) throws Exception;

    Car getCarById(long id) throws Exception;

    Page<CarResponse> getAllCars(PageRequest pagerequest);

    Car updateCar(long Carid, CarDTO carDTO) throws Exception;

    void deleteCar(long id);

    boolean existsCar(String name);

    CarImage createCarImage(Long carId, CarImageDTO carImageDTO) throws Exception;

}
