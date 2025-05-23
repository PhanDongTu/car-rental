package com.project.thuexe.controller;

import com.project.thuexe.Response.OrderReponse;
import com.project.thuexe.dtos.CarDTO;
import com.project.thuexe.dtos.OrderDTO;
import com.project.thuexe.dtos.UserDTO;
import com.project.thuexe.models.Order;
import com.project.thuexe.services.ICarServices;
import com.project.thuexe.services.IOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final IOrderService orderService;
    @PostMapping("")
    public ResponseEntity<?> createOrder(
            @Valid @RequestBody OrderDTO orderDTO,
            BindingResult result){
        try {
            if (result.hasErrors()){

                List<String> errorsMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorsMessages);

            }

            Order neworder = orderService.createOrder(orderDTO);

            return ResponseEntity.ok().body(neworder);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
    @GetMapping("/{user_id}")
    public ResponseEntity<?> getOrders(@Valid @PathVariable("user_id") Long user_id) {
        return ResponseEntity.ok().body("Xe có ID: " + user_id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@Valid @PathVariable Long id,
                                          @Valid @RequestBody OrderDTO orderDTO
                                          ) {
        return ResponseEntity.ok().body("da cap nhat donthue : " + orderDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Đã xóa don thue ID: " + id);
    }
}
