package com.project.thuexe.services;

import com.project.thuexe.components.JwtTokenUtil;
import com.project.thuexe.dtos.UserDTO;
import com.project.thuexe.exceoptions.DataNotFoundException;
import com.project.thuexe.models.Role;
import com.project.thuexe.models.User;
import com.project.thuexe.repositories.RoleRepository;
import com.project.thuexe.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServices implements IUserServices {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    @Override
    public User createUser(UserDTO userDTO) throws Exception {
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
                .diaChi(userDTO.getDiaChi())
                .build();


            Role role = roleRepository.findByIdRole(userDTO.getIdRole())
                    .orElseThrow(() -> new DataNotFoundException("Khong tim ra id role"));

            newUser.setRole(role);
            String password = userDTO.getMatKhau();
            String encodedPassword = passwordEncoder.encode(password);
            newUser.setMatKhau(encodedPassword);

        return userRepository.save(newUser);
    }

    @Override
    public String login(String phoneNumber, String password) throws Exception{

        log.info("phone number: " + phoneNumber);
        log.info("password: " + password);
        Optional<User> optionalUser = userRepository.findBySoDienThoai(phoneNumber);
        if (optionalUser.isEmpty()) {

            throw new EntityNotFoundException("Invalid username or password");

        }

        User esistingUser = optionalUser.get();

        if (!passwordEncoder.matches(password, esistingUser.getMatKhau())) {
            throw new BadCredentialsException("Invalid password");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        phoneNumber
                        ,password
                        ,esistingUser.getAuthorities()
                );

        authenticationManager.authenticate(authenticationToken);

        return jwtTokenUtil.generateToken(esistingUser);

    }
    }

