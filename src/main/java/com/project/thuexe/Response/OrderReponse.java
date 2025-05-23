package com.project.thuexe.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.thuexe.enums.PhuongThucNhanXe;
import com.project.thuexe.enums.TrangThaiDonThue;
import com.project.thuexe.models.Car;
import com.project.thuexe.models.Promotion;
import com.project.thuexe.models.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderReponse  extends  BaseReponse {

    @JsonProperty("id_xe")
    private Long idXe;


    @JsonProperty("id_khachthue")
    private Long idKhachThue;


    @JsonProperty("id_khuyenmai")
    private Promotion idKhuyenMai;


    @JsonProperty("bat_dau_thue")
    private LocalDateTime batDauThue;


    @JsonProperty("ket_thuc_thue")
    private LocalDateTime ketThucThue;

    @JsonProperty("tongtien")
    private BigDecimal tongTien;


    @JsonProperty("phuongthuc_nhanxe")
    private PhuongThucNhanXe phuongThucNhanXe;


    @JsonProperty("diachi_giaoxe")
    private String diaChiGiaoXe;


    @JsonProperty("phi_giaoxe")
    private BigDecimal phiGiaoXe;


    @JsonProperty("trangthai")
    private TrangThaiDonThue trangThai;


    @JsonProperty("chuxe_xacnhan")
    private Boolean chuXeXacNhan;


    @JsonProperty("ngaygiao")
    private LocalDateTime ngayTao;


    @JsonProperty("gia_tri_khuyenmai")
    private BigDecimal giaTriKhuyenMai;


    @JsonProperty("tien_coc")
    private BigDecimal tienCoc;


    @JsonProperty("tien_giu_cho")
    private BigDecimal tienGiuCho;


    @JsonProperty("thue_vat")
    private BigDecimal thueVAT;

    @JsonProperty("tong_cong")
    private BigDecimal tongCong;


    @JsonProperty("dia_diem_nhan_xe")
    private String diaDiemNhanXe;


    @JsonProperty("dia_diem_giao_xe")
    private String diaDiemGiaoXe;

}
