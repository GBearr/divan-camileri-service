package com.divan.divan_camileri.validator;

import com.divan.divan_camileri.dto.IntangibleHeritageDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class IntangibleHeritageValidator {

    public boolean isValid(IntangibleHeritageDTO dto){
        if (dto == null) return false;

        boolean hasName = StringUtils.hasText(dto.getName());
        boolean hasImagePaths = dto.getImagePaths() != null && !dto.getImagePaths().isEmpty();

        return hasName && hasImagePaths;
    }
}
