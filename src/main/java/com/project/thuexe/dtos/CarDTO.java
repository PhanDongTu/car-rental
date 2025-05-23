package com.project.thuexe.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.thuexe.enums.TrangThaiXe;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {



    @NotBlank(message = "This is required")
    @Size(min = 3,max = 200,message = "Chi nhan tu 3 den 200 ky tu")
    private String tenxe;


    @Size(min = 3,max = 200,message = "Chi nhan tu 3 den 200 ky tu")
    private String hangxe;


    @Size(min = 8,max = 8,message = "bien so khong hop le")
    private String bienso;

    @Size(min = 3,max = 200,message = "Chi nhan tu 3 den 200 ky tu")
    private String loaixe;

     @Min(value = 0,message = "Gia thue khong hop le")
     @Max(value = 100000000,message = "Gia thue khong hop le")
     private BigDecimal giathue_gio;

    @JsonProperty("coc_xe")
    @DecimalMin(value = "0.0", inclusive = true, message = "Cọc xe không được âm")
    private BigDecimal coc_xe;

    private BigDecimal giathue_ngay;

    private String mota;

    private TrangThaiXe trangthai;

    private Integer socho;

    private String hopso;

    private String nhienlieu;

    private Long namsanxuat;

    private String diachi_nhanxe;

    private Integer ho_tro_giaoxe;

    private BigDecimal phi_giaoxe;

    private BigDecimal khoangcach_giaoxe_toida;

    private String gioi_thieu;

    private String tien_ich;

    private String dieu_khoan;

    private String muc_tieu_hao_nhien_lieu;

    private String mo_ta_dai;

    private String thoi_gian_giao_xe;

    private String chinh_sach_huy;

    @JsonProperty("id_chuxe")
    private Long id_chuxe;


}
