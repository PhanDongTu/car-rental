package com.project.thuexe.controller;


import com.project.thuexe.dtos.UserDTO;
import com.project.thuexe.dtos.UserLoginDTO;
import com.project.thuexe.repositories.UserRepository;
import com.project.thuexe.services.IUserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserServices userServices;
    @PostMapping("/register")
    public ResponseEntity<?> createUser(
            @Valid @RequestBody UserDTO userDTO,
                          BindingResult result){
        try {
            if (result.hasErrors()){

                List<String> errorsMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorsMessages);

            }
            userServices.createUser(userDTO);
            return ResponseEntity.ok().body("Dang ky thanh cong"+userDTO);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @Valid @RequestBody UserLoginDTO userLoginDTO){

        String token = userServices.login(userLoginDTO.getSoDienThoai(),userLoginDTO.getMatKhau());
       return ResponseEntity.ok().body("some token");

    }


}
