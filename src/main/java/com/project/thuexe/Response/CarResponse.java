package com.project.thuexe.Response;

import com.project.thuexe.dtos.CarDTO;
import com.project.thuexe.enums.TrangThaiXe;
import com.project.thuexe.models.Car;
import com.project.thuexe.models.CarImage;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CarResponse extends BaseReponse {
    private Long id_xe;
    private String tenxe;
    private String hangxe;
    private String bienso;
    private String loaixe;
    private BigDecimal giathue_gio;
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
    private Long id_chuxe;
    private List<ImgReponse> list_img;

    public static CarResponse fromCar(Car car,List<ImgReponse> list_img){

        CarResponse carResponse = CarResponse.builder()
                .id_xe(car.getIdXe())
                .tenxe(car.getTenXe())
                .bienso(car.getBienSo())
                .hopso(car.getHopSo())
                .coc_xe(car.getCocXe())
                .dieu_khoan(car.getDieuKhoan())
                .giathue_gio(car.getGiaThueGio())
                .giathue_ngay(car.getGiaThueNgay())
                .mota(car.getMoTa())
                .hangxe(car.getHangXe())
                .gioi_thieu(car.getGioithieu())
                .diachi_nhanxe(car.getDiachinhanxe())
                .socho(car.getSoCho())
                .id_chuxe(car.getChuxe().getIdNguoiDung())
                .loaixe(car.getLoaiXe())
                .ho_tro_giaoxe(car.getHoTroGiaoxe())
                .chinh_sach_huy(car.getChinhSachHuy())
                .trangthai(car.getTrangThai())
                .nhienlieu(car.getNhienLieu())
                .namsanxuat(car.getNamSanXuat())
                .tien_ich(car.getTien_ich())
                .mo_ta_dai(car.getMoTaDai())
                .muc_tieu_hao_nhien_lieu(car.getMuc_tieu_hao_nhien_lieu())
                .list_img(list_img)



                .build();
        carResponse.setCreatedAt(car.getCreatedAt());
        carResponse.setUpdatedAt(car.getUpdatedAt());
        return carResponse;
    }

}
