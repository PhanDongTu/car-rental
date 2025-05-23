package com.project.thuexe.controller;

import com.project.thuexe.Response.CarResponse;
import com.project.thuexe.dtos.CarDTO;
import com.project.thuexe.dtos.CarImageDTO;
import com.project.thuexe.models.Car;
import com.project.thuexe.models.CarImage;
import com.project.thuexe.services.CarServices;
import com.project.thuexe.services.ICarServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {
    private final ICarServices carServices;


    @PostMapping(value = "")
    public ResponseEntity<?> createCar(
            @Valid @RequestBody CarDTO carDTO,
//
            BindingResult result) {
        try {
            if (result.hasErrors()){

                List<String> errorsMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorsMessages);

            }
            Car newCar = carServices.createCar(carDTO);


            return ResponseEntity.ok().body("Thêm xe thành công"+newCar);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(
            @PathVariable long id,
            @RequestBody CarDTO carDTO
    ){

        try {
            Car newCar = carServices.updateCar(id, carDTO);
            return ResponseEntity.ok().body("Đã cập nhật :"+ newCar);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @PostMapping(value = "uploads/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImage(
            @PathVariable("id") Long carId,
            @RequestParam("files") List<MultipartFile> files

            ){

        try {
            Car existingCar = carServices.getCarById(carId);

            files = files ==null ? new ArrayList<MultipartFile>() :files;
            List<CarImage> carImages = new ArrayList<>();
            for (MultipartFile file : files) {

                if (file.getSize() == 0) {
                    continue;
                }
                if (file.getSize() > 10* 1024 * 1024) {

                    return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
                            .body("Maximum allowed file size is 10MB");

                }
                String contentType = file.getContentType();
                if (contentType != null || !contentType.startsWith("image/")) {

                    ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                            .body("File must be an image");
                }

                String fileName = storeFile(file);

                CarImage carImage = carServices.createCarImage(existingCar.getIdXe(),
                        CarImageDTO.builder()
                                .urlAnh(fileName).build());
                carImages.add(carImage);

            }
            return ResponseEntity.ok().body(carImages);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    private String storeFile(MultipartFile file) throws IOException {
        // Làm sạch tên file gốc để tránh lỗi
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        // Thêm UUID vào trước tên file để đảm bảo duy nhất
        String uniqueFilename = UUID.randomUUID().toString() + "_" + filename;

        // Thư mục lưu trữ
        java.nio.file.Path uploadDir = Paths.get("uploads");

        // Nếu thư mục chưa tồn tại, tạo mới
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        // Tạo đường dẫn đầy đủ tới file
        java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFilename);

        // Sao chép nội dung file đến thư mục đích, ghi đè nếu đã tồn tại
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

        // Trả về tên file duy nhất đã lưu
        return uniqueFilename;
    }






    @GetMapping("")
    public ResponseEntity<List<CarResponse>> getAllCar(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {

        PageRequest pageRequest = PageRequest.of(page, limit, Sort.by("createdAt").descending());

        Page<CarResponse>carPage = carServices.getAllCars(pageRequest);

        int totalPages = carPage.getTotalPages();

        List<CarResponse> cars = carPage.getContent();

        return ResponseEntity.ok(cars);
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(
            @PathVariable("id") Long id) {


        try {
            Car exisingCar = carServices.getCarById(id);
            return ResponseEntity.ok(CarResponse.fromCar(exisingCar));
        }catch (Exception e){
            return ResponseEntity.ok().body("Xe có ID: " + id);
        }

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable long id) {
        try {
            carServices.deleteCar(id);
            return ResponseEntity.ok("Đã xoá xe " + id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Xoá thất bại có lổi xảy ra");
        }



    }
}
