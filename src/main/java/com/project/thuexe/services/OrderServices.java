package com.project.thuexe.services;

import com.project.thuexe.Response.OrderReponse;
import com.project.thuexe.dtos.OrderDTO;
import com.project.thuexe.enums.TrangThaiDonThue;
import com.project.thuexe.exceoptions.DataNotFoundException;
import com.project.thuexe.models.Car;
import com.project.thuexe.models.Order;
import com.project.thuexe.models.User;
import com.project.thuexe.repositories.CarRepository;
import com.project.thuexe.repositories.OrderRepository;
import com.project.thuexe.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service

public class OrderServices implements IOrderService{
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;


    @Override
    public Order createOrder(OrderDTO orderDTO) throws Exception {
        User user = userRepository.findByIdNguoiDung(orderDTO.getId_khachthue())
                .orElseThrow(() -> new DataNotFoundException("Khong tim ra id khach thue"));

        Car car = carRepository.findByIdXe(orderDTO.getId_xe())
                .orElseThrow(() -> new DataNotFoundException("Khong tim ra id xe thue"));

        // Tạo TypeMap nếu chưa tồn tại

        Order order = Order.builder()
                .idKhachThue(user)
                .idXe(car)
                .batDauThue(orderDTO.getBatdau_thue())
                .ketThucThue(orderDTO.getKetthuc_thue())
                .diaDiemNhanXe(orderDTO.getDia_diem_nhan_xe())
                .phiGiaoXe(orderDTO.getPhi_giaoxe())
                .phuongThucNhanXe(orderDTO.getPhongthuc_nhanxe())
                .trangThai(orderDTO.getTrangThaiDonThue())
                .tienCoc(orderDTO.getTien_coc())
                .tongCong(orderDTO.getTong_cong())
                .tienGiuCho(orderDTO.getTien_giu_cho())
                .tongTien(orderDTO.getTongtien())
                .diaDiemGiaoXe(orderDTO.getDia_diem_giao_xe())
                .giaTriKhuyenMai(orderDTO.getGia_tri_khuyenmai())
                .thueVAT(orderDTO.getThue_vat())
                .ngayGiao(orderDTO.getNgaygiao())
                .build();



        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(long OrderId,OrderDTO orderDTO) throws Exception {
        Order order = orderRepository.findByIdDonThue(OrderId)
                .orElseThrow(() -> new DataNotFoundException("Khong tim ra id don thue"));
        User existingUser = userRepository
                .findByIdNguoiDung(orderDTO.getId_khachthue()).orElseThrow(() -> new DataNotFoundException("Khong tim ra id don thue"));
        Car existingCar = carRepository.findByIdXe(orderDTO.getId_xe())
                .orElseThrow(() -> new DataNotFoundException("Khong tim ra id xe thue"));



        order.setIdKhachThue(existingUser);
        order.setIdXe(existingCar);
        order.setIdKhuyenMai(null);
        order.setBatDauThue(orderDTO.getBatdau_thue());
        order.setKetThucThue(orderDTO.getKetthuc_thue());
        order.setTrangThai(orderDTO.getTrangThaiDonThue());
        order.setTienCoc(orderDTO.getTien_coc());
        order.setTongCong(orderDTO.getTong_cong());
        order.setTienGiuCho(orderDTO.getTien_giu_cho());
        order.setTongTien(orderDTO.getTongtien());
        order.setDiaDiemNhanXe(orderDTO.getDia_diem_nhan_xe());
        order.setDiaDiemGiaoXe(orderDTO.getDia_diem_giao_xe());
        order.setPhiGiaoXe(orderDTO.getPhi_giaoxe());
        order.setNgayGiao(orderDTO.getNgaygiao());
        order.setPhuongThucNhanXe(orderDTO.getPhongthuc_nhanxe());






        return orderRepository.save(order);
    }

    @Override
    public Order getOrderId(long orderId) throws Exception {
        return orderRepository.findByIdDonThue(orderId).orElseThrow(() -> new DataNotFoundException("Khong tim ra id thue"));
    }

    @Override
    public void deleteOrder(long id) throws Exception{
        Optional<Order> optionalOrder = orderRepository.findByIdDonThue(id);
        optionalOrder.ifPresent(orderRepository::delete);


    }

    @Override
    public List<Order> findByUserId(long userId) throws Exception{
        User user = userRepository
                .findByIdNguoiDung(userId)
                .orElseThrow(() -> new DataNotFoundException("Khong tim ra id khach thue"));
        return orderRepository.findByIdKhachThue(user);
    }
}
