package com.divan.divan_camileri.validator;

import com.divan.divan_camileri.dto.MosqueDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MosqueValidator {

    public boolean isValid(MosqueDTO dto) {
        if (dto == null) return false;

        boolean hasName = StringUtils.hasText(dto.getName());
        boolean hasLocalization = StringUtils.hasText(dto.getLocalization());
        boolean hasVillage = StringUtils.hasText(dto.getLocalization());

        return hasName && hasLocalization && hasVillage;
    }
}
