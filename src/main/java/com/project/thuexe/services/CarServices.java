package com.project.thuexe.services;

import com.project.thuexe.Response.CarResponse;
import com.project.thuexe.Response.ImgReponse;
import com.project.thuexe.dtos.CarDTO;
import com.project.thuexe.dtos.CarImageDTO;
import com.project.thuexe.exceoptions.DataNotFoundException;
import com.project.thuexe.exceoptions.InvalidParamException;
import com.project.thuexe.models.Car;
import com.project.thuexe.models.CarImage;
import com.project.thuexe.models.User;
import com.project.thuexe.repositories.CarImgRepository;
import com.project.thuexe.repositories.CarRepository;
import com.project.thuexe.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CarServices implements ICarServices {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final CarImgRepository carImgRepository;
    @Override
    public Car createCar(CarDTO carDTO) throws Exception {

        User existringUser =
        userRepository.findByIdNguoiDung(carDTO.getId_chuxe())
                .orElseThrow(()->new DataNotFoundException("Khong tim ra id chu xe :"+carDTO.getId_chuxe()));
        Car newCar = Car.builder()
                .chuxe(existringUser)
                .tenXe(carDTO.getTenxe())
                .bienSo(carDTO.getBienso())
                .hangXe(carDTO.getHangxe())
                .loaiXe(carDTO.getLoaixe())
                .giaThueGio(carDTO.getGiathue_gio() != null ? carDTO.getGiathue_gio() : null)
                .giaThueNgay(carDTO.getGiathue_ngay() != null ? carDTO.getGiathue_ngay() : null)
                .moTa(carDTO.getMota())
                .trangThai(carDTO.getTrangthai())
                .soCho(carDTO.getSocho())
                .hopSo(carDTO.getHopso())
                .nhienLieu(carDTO.getNhienlieu())
                .namSanXuat(carDTO.getNamsanxuat() != null ? carDTO.getNamsanxuat().longValue() : null)
                .phiGiaoXe(carDTO.getPhi_giaoxe() != null ? carDTO.getPhi_giaoxe().intValue() : null)
                .khoangCachGiaoXeToiDa(carDTO.getKhoangcach_giaoxe_toida() != null ? carDTO.getKhoangcach_giaoxe_toida() : null)
                .moTaDai(carDTO.getMo_ta_dai())
                .dieuKhoan(carDTO.getDieu_khoan())
                .muc_tieu_hao_nhien_lieu(carDTO.getMuc_tieu_hao_nhien_lieu())
                .tien_ich(carDTO.getTien_ich())
                .cocXe(carDTO.getCoc_xe())
                .createdAt(LocalDateTime.now())
                .diachinhanxe(carDTO.getDiachi_nhanxe())
                .gioithieu(carDTO.getGioi_thieu())
                .hoTroGiaoxe(carDTO.getHo_tro_giaoxe())
                .chinhSachHuy(carDTO.getChinh_sach_huy())

                .build();

        return carRepository.save(newCar);
    }
    @Override
    public Car updateCar(long CarId, CarDTO carDTO) throws Exception

    {
        Car existingCar = getCarById(CarId);

        if (existingCar != null){
            User existringUser =
                    userRepository.findByIdNguoiDung(carDTO.getId_chuxe())
                            .orElseThrow(()->new DataNotFoundException("Khong tim ra id chu xe :"+carDTO.getId_chuxe()));
            existingCar.setChuxe(existringUser);
            existingCar.setTenXe(carDTO.getTenxe());
            existingCar.setBienSo(carDTO.getBienso());
            existingCar.setHangXe(carDTO.getHangxe());
            existingCar.setLoaiXe(carDTO.getLoaixe());
            existingCar.setGiaThueGio(carDTO.getGiathue_gio());
            existingCar.setGiaThueNgay(carDTO.getGiathue_ngay());
            existingCar.setMoTa(carDTO.getMota());
            existingCar.setTrangThai(carDTO.getTrangthai());
            existingCar.setSoCho(carDTO.getSocho());
            existingCar.setHopSo(carDTO.getHopso());
            existingCar.setNhienLieu(carDTO.getNhienlieu());
            existingCar.setNamSanXuat(carDTO.getNamsanxuat());
            existingCar.setPhiGiaoXe(carDTO.getPhi_giaoxe().intValue());
            existingCar.setKhoangCachGiaoXeToiDa(carDTO.getKhoangcach_giaoxe_toida());
            existingCar.setGioithieu(carDTO.getGioi_thieu());
            existingCar.setMoTaDai(carDTO.getMo_ta_dai());
            existingCar.setDieuKhoan(carDTO.getDieu_khoan());
            existingCar.setChinhSachHuy(carDTO.getChinh_sach_huy());
            existingCar.setCocXe(carDTO.getCoc_xe());
            existingCar.setTien_ich(carDTO.getTien_ich());

            return carRepository.save(existingCar);


        }
        return null;
    }


    @Override
    public Car getCarById(long carId) throws Exception {
        return carRepository.findByIdXe(carId)
                .orElseThrow(()-> new DataNotFoundException("Khong tim thay car co id"+carId));
    }

    @Override
    public Page<CarResponse> getAllCars(PageRequest pageRequest) {
        return carRepository.findAll(pageRequest).map(car -> {
            List<CarImage> images = carImgRepository.findByCarIdXe(car.getIdXe());
            List<ImgReponse> imgReponses = ImgReponse.fromImg(images);
            return CarResponse.fromCar(car, imgReponses);
        });


    }


    @Override
    public void deleteCar(long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        optionalCar.ifPresent(carRepository::delete);

    }

    @Override
    public boolean existsCar(String name) {
        return false;
    }
    @Override
    public CarImage createCarImage(Long carId, CarImageDTO carImageDTO) throws Exception {
        Car existringCar = carRepository.findByIdXe(carId)
                        .orElseThrow(()->
                                new DataNotFoundException("Khong tim ra id xe :"+carImageDTO.getCarId()));

        CarImage newCarImage = CarImage.builder()
                .car(existringCar).urlAnh(carImageDTO.getUrlAnh())
                .ngayDang(carImageDTO.getNgayDang())
                .anhChinh(carImageDTO.getAnhChinh())
                .build();
        int size = carImgRepository.findByCarIdXe(carId).size();
        if (size > 5) {
            throw new InvalidParamException("Khong duoc truyen qua 5 file");
        }


       return carImgRepository.save(newCarImage);
    }

    @Override
    public List<CarImage> getCarImage(long imageId) throws Exception {
        return carImgRepository.findByCarIdXe(imageId);
    }
}
