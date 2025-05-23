package com.project.thuexe.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "anhxe")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anh")
    @JsonProperty("id_anh")
    private Long idAnh;

    // Foreign key tới bảng xe
    @ManyToOne()
    @JoinColumn(name = "id_xe")
    private Car car;

    @Column(name = "url_anh", length = 255)
    @JsonProperty("url_anh")
    private String urlAnh;

    @Column(name = "anh_chinh")
    @JsonProperty("anh_chinh")
    private Boolean anhChinh;

    @Column(name = "ngaydang")
    @JsonProperty("ngaydang")
    private LocalDateTime ngayDang;




}
