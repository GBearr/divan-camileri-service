package com.divan.divan_camileri.constant;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Image {

    @Column(name = "image_number", length = 150)
    private String number;

    @Column(name = "image_path", length = 255)
    private String path;
}