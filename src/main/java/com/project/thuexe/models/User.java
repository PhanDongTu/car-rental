package com.project.thuexe.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import com.project.thuexe.enums.TrangThaiXacMinh;
import java.time.LocalDateTime;

@Entity
@Table(name = "nguoidung")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nguoidung")
    @JsonProperty("id_nguoidung")
    private Long idNguoiDung;

    @Column(name = "hoten", length = 100)
    @JsonProperty("hoten")
    private String hoTen;

    @Column(name = "email", length = 100)
    @JsonProperty("email")
    private String email;

    @Column(name = "matkhau", length = 255)
    @JsonProperty("matkhau")
    private String matKhau;

    @Column(name = "sodienthoai", length = 20)
    @JsonProperty("sodienthoai")
    private String soDienThoai;

    @Column(name = "diachi", length = 255)
    @JsonProperty("diachi")
    private String diaChi;

    // Foreign key tới bảng roles
    @Column(name = "id_role", insertable = false, updatable = false)
    @JsonProperty("id_role")
    private Long idRole;

    @ManyToOne()
    @JoinColumn(name = "id_role")
    private Role role;

    @Column(name = "cmnd", length = 15)
    @JsonProperty("cmnd")
    private String cmnd;

    @Column(name = "anh_cmnd_truoc", length = 255)
    @JsonProperty("anh_cmnd_truoc")
    private String anhCmndTruoc;

    @Column(name = "anh_cmnd_sau", length = 255)
    @JsonProperty("anh_cmnd_sau")
    private String anhCmndSau;

    @Column(name = "bang_lai", length = 15)
    @JsonProperty("bang_lai")
    private String bangLai;

    @Column(name = "anh_bang_lai", length = 255)
    @JsonProperty("anh_bang_lai")
    private String anhBangLai;

    @Column(name = "xac_minh_cmnd")
    @Enumerated(EnumType.STRING)
    @JsonProperty("xac_minh_cmnd")
    private TrangThaiXacMinh xacMinhCmnd;

    @Column(name = "xac_minh_banglai")
    @Enumerated(EnumType.STRING)
    @JsonProperty("xac_minh_banglai")
    private TrangThaiXacMinh xacMinhBangLai;

    @Column(name = "ngay_xacminh_cmnd")
    @JsonProperty("ngay_xacminh_cmnd")
    private LocalDateTime ngayXacMinhCmnd;

    @Column(name = "otp", length = 6)
    @JsonProperty("otp")
    private String otp;

    @Column(name = "otp_expiry")
    @JsonProperty("otp_expiry")
    private LocalDateTime otpExpiry;

    @Column(name = "khoa_tk")
    @JsonProperty("khoa_tk")
    private Boolean khoaTk;

    @Column(name = "created_at")
    @JsonProperty("created_at")
    private LocalDateTime createdAt;



}
