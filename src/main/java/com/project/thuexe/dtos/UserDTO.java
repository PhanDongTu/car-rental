package com.project.thuexe.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @JsonProperty("hoten")
    @NotBlank(message = "vui dong nhap truong ho ten")
    private String hoTen;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mat_khau")
    @NotBlank(message = "mat khau khong duoc de trong")
    private String matKhau;

    @JsonProperty("sodienthoai")
    @NotBlank(message = "so dien thoai khong duoc de trong")
    private String soDienThoai;

    @JsonProperty("diachi")
    private String diaChi;

    @JsonProperty("id_role")
    @NotNull(message = "idRole khong duoc de trong")
    private Long idRole;

    @JsonProperty("cmnd")
    private String cmnd;

    @JsonProperty("anh_cmnd_truoc")
    private String anhCmndTruoc;

    @JsonProperty("anh_cmnd_sau")
    private String anhCmndSau;

    @JsonProperty("bang_lai")
    private String bangLai;

    @JsonProperty("anh_bang_lai")
    private String anhBangLai;

    @JsonProperty("xac_minh_cmnd")
    private String xacMinhCmnd;

    @JsonProperty("xac_minh_banglai")
    private String xacMinhBangLai;

    @JsonProperty("ngay_xacminh_cmnd")
    private LocalDateTime ngayXacMinhCmnd;

    @JsonProperty("ngay_xacminh_banglai")
    private LocalDateTime ngayXacMinhBangLai;

    @JsonProperty("khoa_tk")
    private Boolean khoaTk;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;



}
