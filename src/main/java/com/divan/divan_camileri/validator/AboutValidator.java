package com.divan.divan_camileri.validator;

import com.divan.divan_camileri.dto.AboutDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class AboutValidator {

    public boolean isValid(AboutDTO dto){
        if (dto == null) return false;

        boolean hasName = StringUtils.hasText(dto.getName());
        boolean hasUrl = StringUtils.hasText(dto.getUrl());
        boolean hasImagePath = StringUtils.hasText(dto.getImagePath());

        return hasName && hasUrl && hasImagePath;

    }
}
