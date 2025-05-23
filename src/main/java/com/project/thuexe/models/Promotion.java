package com.project.thuexe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "khuyen_mai")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Promotion extends BaseEntity {
    @Id
    @Column(name = "id_khuyenmai")
    @JsonProperty("id_khuyenmai")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKhuyenMai;

    @Column(name = "ma_khuyenmai", length = 20)
    @JsonProperty("ma_khuyenmai")
    private String maKhuyenMai;

    @Column(name = "mo_ta", length = 255)
    @JsonProperty("mo_ta")
    private String moTa;

    @Column(name = "phan_tram_giam", precision = 5, scale = 2)
    @JsonProperty("phan_tram_giam")
    private BigDecimal phanTramGiam;

    @Column(name = "gia_tri_toi_da", precision = 12, scale = 2)
    @JsonProperty("gia_tri_toi_da")
    private BigDecimal giaTriToiDa;

    @Column(name = "ngay_bat_dau")
    @JsonProperty("ngay_bat_dau")
    private LocalDateTime ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    @JsonProperty("ngay_ket_thuc")
    private LocalDateTime ngayKetThuc;

    @Column(name = "trang_thai")
    @JsonProperty("trang_thai")
    private Boolean trangThai;

    @Column(name = "created_at")
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
