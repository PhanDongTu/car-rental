package com.project.thuexe.repositories;

import com.project.thuexe.exceoptions.DataNotFoundException;
import com.project.thuexe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
          boolean existsBySoDienThoai(String soDienThoai);
          Optional<User> findByIdNguoiDung(Long idNguoiDung) throws Exception;
          Optional<User> findBySoDienThoai(String phoneNumber);
}
