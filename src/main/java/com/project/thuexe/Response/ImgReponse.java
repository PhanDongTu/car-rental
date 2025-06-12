package com.project.thuexe.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.thuexe.models.Car;
import com.project.thuexe.models.CarImage;
import jakarta.persistence.JoinColumn;
import lombok.*;
import org.apache.catalina.connector.Response;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImgReponse extends BaseReponse {

    private Long imgId;



    private String urlAnh;







    public static List<ImgReponse> fromImg(List<CarImage> carsImg) {

        return carsImg.stream().map(carImage -> ImgReponse.builder()
                .imgId(carImage.getIdAnh())
                .urlAnh(carImage.getUrlAnh())


                .build()
        ).collect(Collectors.toList());
    }
}
