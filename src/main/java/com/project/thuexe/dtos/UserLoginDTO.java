package com.project.thuexe.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {


    @JsonProperty("sodienthoai")
    @NotBlank(message = "Khong duoc de trong so dien thoai")
    private String soDienThoai;

    @JsonProperty("mat_khau")
    @NotBlank(message = "khong de trong mat khau")
    private String matKhau;



}
