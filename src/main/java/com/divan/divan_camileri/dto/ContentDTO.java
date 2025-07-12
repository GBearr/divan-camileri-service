package com.divan.divan_camileri.dto;

import com.divan.divan_camileri.constant.ContentType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContentDTO {

    private String name;
    private String description;
    private List<String> imagePaths;
    private ContentType type;
}
