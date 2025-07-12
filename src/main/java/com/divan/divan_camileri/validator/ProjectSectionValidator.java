package com.divan.divan_camileri.validator;

import com.divan.divan_camileri.dto.ProjectSectionDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ProjectSectionValidator {

    public boolean isValid(ProjectSectionDTO dto){
        if (dto == null) return false;

        boolean hasName = StringUtils.hasText(dto.getName());
        boolean hasDescription = StringUtils.hasText(dto.getDescription());
        boolean hasPath = StringUtils.hasText(dto.getPath());

        return hasName && hasDescription && hasPath;
    }
}
