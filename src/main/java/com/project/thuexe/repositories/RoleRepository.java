package com.project.thuexe.repositories;

import com.project.thuexe.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByIdRole(Long idRole);

}
