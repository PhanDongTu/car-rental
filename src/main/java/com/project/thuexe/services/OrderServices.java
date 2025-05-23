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
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Service

public class OrderServices implements IOrderService{
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private ModelMapper modelMapper;


    @Override
    public Order createOrder(OrderDTO orderDTO) throws Exception {
        User user = userRepository
                .findByIdNguoiDung(orderDTO.getId_khachthue())
                .orElseThrow(() -> new DataNotFoundException("Khong tim ra id khach thue"));
        Car car = carRepository.findByIdXe(orderDTO.getId_xe()).orElseThrow(() -> new DataNotFoundException("Khong tim ra id xe thue"));

        // Tạo TypeMap nếu chưa tồn tại

        Order order = Order.builder()
                .idKhachThue(user)
                .idXe(car)
                .batDauThue(orderDTO.getBatdau_thue())
                .ketThucThue(orderDTO.getKetthuc_thue())
                .chuXeXacNhan(orderDTO.isChuxe_xacnhan())
                .diaChiGiaoXe(orderDTO.getDia_diem_giao_xe())
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




                .build();



        return orderRepository.save(order);
    }

    @Override
    public OrderReponse updateOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderReponse getOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteOrder(OrderDTO orderDTO) {

    }

    @Override
    public List<OrderReponse> getAllOrders(OrderDTO orderDTO) {
        return List.of();
    }
}
