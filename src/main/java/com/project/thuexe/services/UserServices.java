package com.project.thuexe.services;

import com.project.thuexe.dtos.UserDTO;
import com.project.thuexe.exceoptions.DataNotFoundException;
import com.project.thuexe.models.Role;
import com.project.thuexe.models.User;
import com.project.thuexe.repositories.RoleRepository;
import com.project.thuexe.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServices implements IUserServices {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    @Override
    public User createUser(UserDTO userDTO) throws DataNotFoundException {
        String phoneNumber = userDTO.getSoDienThoai();
        if (userRepository.existsBySoDienThoai(phoneNumber)) {
         throw new DataIntegrityViolationException("User with phone number " + phoneNumber + " already exists");
        }
        User newUser = User.builder()
                .hoTen(userDTO.getHoTen())
                .soDienThoai(userDTO.getSoDienThoai())
                .matKhau(userDTO.getMatKhau())
                .cmnd(userDTO.getCmnd())
                .anhCmndSau(userDTO.getAnhCmndSau())
                .anhCmndTruoc(userDTO.getAnhCmndTruoc())
                .email(userDTO.getEmail())
                .anhBangLai(userDTO.getAnhBangLai())
                .bangLai(userDTO.getBangLai())
                .otp(userDTO.getSoDienThoai())


                .diaChi(userDTO.getDiaChi())

                .build();


            Role role = roleRepository.findById(userDTO.getIdRole()).orElseThrow(()-> new DataNotFoundException("Role with id " + userDTO.getIdRole() + " not found"));
            newUser.setRole(role);


        return userRepository.save(newUser);
    }

    @Override
    public String login(String username, String password) {
        return "";
    }
}
