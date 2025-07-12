package com.divan.divan_camileri.controller;

import com.divan.divan_camileri.dto.ProjectSectionDTO;
import com.divan.divan_camileri.entity.ProjectSectionP;
import com.divan.divan_camileri.service.ProjectSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section")
@RequiredArgsConstructor
public class ProjectSectionController {

    private final ProjectSectionService projectSectionService;

    @GetMapping("/all")
    public ResponseEntity<List<ProjectSectionP>> findAll(){
        return ResponseEntity.ok(projectSectionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectSectionP> findProjectSectionById(@PathVariable Long id){
        return ResponseEntity.ok(projectSectionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createProjectSection(@RequestBody ProjectSectionDTO projectSectionDTO){
        return ResponseEntity.ok(projectSectionService.createProjectSection(projectSectionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProjectSection(@PathVariable Long id){
        return ResponseEntity.ok(projectSectionService.deleteProjectSection(id));
    }
}
