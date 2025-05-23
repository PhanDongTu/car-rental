package com.project.thuexe.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.thuexe.models.Car;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarImageDTO {


    // Foreign key tới bảng xe

    @JoinColumn(name = "id_xe")
    private Long carId;


    @JsonProperty("url_anh")
    private String urlAnh;


    @JsonProperty("anh_chinh")
    private Boolean anhChinh;


    @JsonProperty("ngaydang")
    private LocalDateTime ngayDang;
    private List<MultipartFile> files;
}
