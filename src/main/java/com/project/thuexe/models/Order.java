package com.project.thuexe.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import com.project.thuexe.enums.*;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "donthue")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity {
    @Id
    @Column(name = "id_donthue")
    @JsonProperty("id_donthue")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDonThue;

    @ManyToOne
    @JoinColumn(name = "id_xe")
    @JsonProperty("id_xe")
    private Car idXe;

    @ManyToOne
    @JoinColumn(name = "id_khachthue")
    @JsonProperty("id_khachthue")
    private User idKhachThue;

    @ManyToOne
    @JoinColumn(name = "id_khuyenmai")
    @JsonProperty("id_khuyenmai")
    private Promotion idKhuyenMai;

    @Column(name = "batdau_thue")
    @JsonProperty("batdau_thue")
    private LocalDateTime batDauThue;

    @Column(name = "ketthuc_thue")
    @JsonProperty("keithue_thue")
    private LocalDateTime ketThucThue;

    @Column(name = "tongtien")
    @JsonProperty("tongtien")
    private BigDecimal tongTien;

    @Enumerated(EnumType.STRING)
    @Column(name = "phuongthuc_nhanxe")
    @JsonProperty("phuongthuc_nhanxe")
    private PhuongThucNhanXe phuongThucNhanXe;


    @Column(name = "phi_giaoxe")
    @JsonProperty("phi_giaoxe")
    private BigDecimal phiGiaoXe;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangthai")
    @JsonProperty("trangthai")
    private TrangThaiDonThue trangThai;

    @Column(name = "ngaygiao")
    @JsonProperty("ngaygiao")
    private LocalDateTime ngayGiao;

    @Column(name = "gia_tri_khuyenmai")
    @JsonProperty("gia_tri_khuyenmai")
    private BigDecimal giaTriKhuyenMai;

    @Column(name = "tien_coc")
    @JsonProperty("tien_coc")
    private BigDecimal tienCoc;

    @Column(name = "tien_giu_cho")
    @JsonProperty("tien_giu_cho")
    private BigDecimal tienGiuCho;

    @Column(name = "thue_vat")
    @JsonProperty("thue_vat")
    private BigDecimal thueVAT;

    @Column(name = "tong_cong")
    @JsonProperty("tong_cong")
    private BigDecimal tongCong;

    @Column(name = "dia_diem_nhan_xe")
    @JsonProperty("dia_diem_nhan_xe")
    private String diaDiemNhanXe;

    @Column(name = "dia_diem_giao_xe")
    @JsonProperty("dia_diem_giao_xe")
    private String diaDiemGiaoXe;



}
