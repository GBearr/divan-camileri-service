package com.divan.divan_camileri.validator;

import com.divan.divan_camileri.dto.ContentDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ContentValidator {

    public boolean isValid(ContentDTO dto) {
        if (dto == null) return false;

        boolean hasName = StringUtils.hasText(dto.getName());
        boolean hasDescription = StringUtils.hasText(dto.getDescription());
        boolean hasType = dto.getType() != null;
        boolean hasImagePaths = dto.getImagePaths() != null && !dto.getImagePaths().isEmpty();

        return hasName && hasDescription && hasType && hasImagePaths;
    }
}