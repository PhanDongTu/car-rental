package com.project.thuexe.models;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "roles")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    @Column(name = "ten_role", length = 50)
    private String tenRole;

    @Column(name = "mo_ta", length = 255)
    private String moTa;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
