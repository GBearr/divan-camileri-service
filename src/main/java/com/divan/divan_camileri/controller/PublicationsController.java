package com.divan.divan_camileri.controller;

import com.divan.divan_camileri.dto.PublicaitonsDTO;
import com.divan.divan_camileri.entity.PublicationsP;
import com.divan.divan_camileri.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publication")
@RequiredArgsConstructor
public class PublicationsController {

    private final PublicationService publicationService;

    @GetMapping("/all")
    public ResponseEntity<List<PublicationsP>> findAll(){
        return ResponseEntity.ok(publicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationsP> findPublicationById(@PathVariable Long id){
        return ResponseEntity.ok(publicationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createPublication(@RequestBody PublicaitonsDTO publicaitonsDTO){
        return ResponseEntity.ok(publicationService.createPublication(publicaitonsDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePublication(@PathVariable Long id){
        return ResponseEntity.ok(publicationService.deletePublication(id));
    }
}
