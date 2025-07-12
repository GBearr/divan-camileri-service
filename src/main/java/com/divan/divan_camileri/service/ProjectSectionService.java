package com.divan.divan_camileri.service;

import com.divan.divan_camileri.dto.ProjectSectionDTO;
import com.divan.divan_camileri.entity.ProjectSectionP;

import java.util.List;

public interface ProjectSectionService {

    List<ProjectSectionP> findAll();
    ProjectSectionP findById(Long id);
    Boolean createProjectSection(ProjectSectionDTO projectSectionDTO);
    Boolean deleteProjectSection(Long id);
}
