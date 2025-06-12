package com.project.thuexe.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.thuexe.enums.PhuongThucNhanXe;
import com.project.thuexe.enums.TrangThaiDonThue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {

    @JsonProperty("id_xe")
    private Long id_xe;

    @JsonProperty("id_khachthue")
    private Long id_khachthue;

    @JsonProperty("id_khuyenmai")
    private Long id_khuyenmai;

    @JsonProperty("batdau_thue")
    private LocalDateTime batdau_thue;

    @JsonProperty("ketthuc_thue")
    private LocalDateTime ketthuc_thue;

    @JsonProperty("tongtien")
    private BigDecimal tongtien;

    @JsonProperty("phongthuc_nhanxe")
    private PhuongThucNhanXe phongthuc_nhanxe;


    @JsonProperty("phi_giaoxe")
    private BigDecimal phi_giaoxe;

    @JsonProperty("trangthai")
    private TrangThaiDonThue trangThaiDonThue;


    @JsonProperty("ngaygiao")
    private LocalDateTime ngaygiao;

    @JsonProperty("gia_tri_khuyenmai")
    private BigDecimal gia_tri_khuyenmai;

    @JsonProperty("tien_coc")
    private BigDecimal tien_coc;

    @JsonProperty("tien_giu_cho")
    private BigDecimal tien_giu_cho;

    @JsonProperty("thue_vat")
    private BigDecimal thue_vat;

    @JsonProperty("tong_cong")
    private BigDecimal tong_cong;

    @JsonProperty("dia_diem_nhan_xe")
    private String dia_diem_nhan_xe;

    @JsonProperty("dia_diem_giao_xe")
    private String dia_diem_giao_xe;
}
