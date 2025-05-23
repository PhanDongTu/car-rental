package com.project.thuexe.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.project.thuexe.enums.TokenType;
@Entity
@Table(name = "tokens")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token")
    private Integer id;

    // Foreign key tới bảng nguoidung
    @ManyToOne()
    @JoinColumn(name = "id_nguoidung", nullable = false)
    private User nguoiDung;

    @Column(name = "token", length = 255, nullable = false)
    private String token;

    @Column(name = "refresh_token", length = 255)
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_type", columnDefinition = "ENUM('access', 'refresh', 'reset_password', 'verify_email')", nullable = false)
    private TokenType tokenType;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column(name = "is_revoked", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean revoked;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "device_info", length = 255)
    private String deviceInfo;

    @Column(name = "ip_address", length = 45)
    private String ipAddress;
}
