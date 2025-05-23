package com.project.thuexe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.thuexe.enums.TrangThaiXe;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "xe")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Car extends BaseEntity {
    @Id
    @Column(name = "id_xe")
    @JsonProperty("id_xe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idXe;

    // Foreign key tới bảng nguoidung
    @ManyToOne
    @JoinColumn(name = "id_chuxe")
    private User chuxe;

    @Column(name = "tenxe")
    @JsonProperty("tenxe")
    private String tenXe;

    @Column(name = "hangxe")
    @JsonProperty("hangxe")
    private String hangXe;

    @Column(name = "bienso")
    @JsonProperty("bienso")
    private String bienSo;

    @Column(name = "loaixe")
    @JsonProperty("loaixe")
    private String loaiXe;

    @Column(name = "giathue_gio")
    @JsonProperty("giathue_gio")
    private BigDecimal giaThueGio;

    @Column(name = "giathue_ngay")
    @JsonProperty("giathue_ngay")
    private BigDecimal giaThueNgay;

    @Column(name = "mota")
    @JsonProperty("mota")
    private String moTa;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangthai")
    @JsonProperty("trangthai")
    private TrangThaiXe trangThai;

    @Column(name = "socho")
    @JsonProperty("socho")
    private Integer soCho;

    @Column(name = "hopso")
    @JsonProperty("hopso")
    private String hopSo;

    @Column(name = "nhienlieu")
    @JsonProperty("nhienlieu")
    private String nhienLieu;

    @Column(name = "namsanxuat")
    @JsonProperty("namsanxuat")
    private Long namSanXuat;

    @Column(name = "phi_giaoxe")
    @JsonProperty("phi_giaoxe")
    private Integer phiGiaoXe;

    @Column(name = "khoangcach_giaoxe_toida")
    @JsonProperty("khoangcach_giaoxe_toida")
    private BigDecimal khoangCachGiaoXeToiDa;

    @Column(name = "gioi_thieu")
    @JsonProperty("gioi_thieu")
    private String gioithieu;

    @Column(name = "ho_tro_giaoxe")
    @JsonProperty("ho_tro_giaoxe")
    private Integer hoTroGiaoxe;


    @Column(name = "tien_ich")
    @JsonProperty("tien_ich")
    private String tien_ich;

    @Column(name = "mo_ta_dai")
    @JsonProperty("mo_ta_dai")
    private String moTaDai;

    @Column(name = "dieu_khoan")
    @JsonProperty("dieu_khoan")
    private String dieuKhoan;

    @Column(name = "muc_tieu_hao_nhien_lieu")
    @JsonProperty("muc_tieu_hao_nhien_lieu")
    private String muc_tieu_hao_nhien_lieu;

    @Column(name = "chinh_sach_huy")
    @JsonProperty("chinh_sach_huy")
    private String chinhSachHuy;

    @Column(name = "diachi_nhanxe")
    @JsonProperty("dia_chi_nhan_xe")
    private String diachinhanxe;

    @Column(name = "coc_xe")
    @JsonProperty("coc_xe")
    private BigDecimal cocXe;

    @Column(name = "created_at")
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

}
