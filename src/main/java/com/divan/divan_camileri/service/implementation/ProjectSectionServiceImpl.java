package com.divan.divan_camileri.service.implementation;

import com.divan.divan_camileri.dto.ProjectSectionDTO;
import com.divan.divan_camileri.entity.ProjectSectionP;
import com.divan.divan_camileri.repository.ProjectSectionRepository;
import com.divan.divan_camileri.service.ProjectSectionService;
import com.divan.divan_camileri.validator.ProjectSectionValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public final class ProjectSectionServiceImpl implements ProjectSectionService {

    private final ProjectSectionRepository projectSectionRepository;
    private final ProjectSectionValidator projectSectionValidator;
    private final ObjectMapper objectMapper;

    @Override
    public List<ProjectSectionP> findAll() {
        return projectSectionRepository.findAll();
    }

    @Override
    public ProjectSectionP findById(Long id) {
        return projectSectionRepository.findById(id)
                .orElseGet(() -> {
                    log.warn("Project section not found with id : {}",id);
                    return new ProjectSectionP();
                });
    }

    @Override
    public Boolean createProjectSection(ProjectSectionDTO projectSectionDTO) {
        if (!projectSectionValidator.isValid(projectSectionDTO)) return false;
        ProjectSectionP projectSection = objectMapper.convertValue(projectSectionDTO,ProjectSectionP.class);
        projectSectionRepository.save(projectSection);
        return true;
    }

    @Override
    public Boolean deleteProjectSection(Long id) {
        if (!projectSectionRepository.existsById(id)) return false;
        projectSectionRepository.deleteById(id);
        return true;
    }
}
