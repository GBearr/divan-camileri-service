package com.divan.divan_camileri.controller;

import com.divan.divan_camileri.dto.ContentDTO;
import com.divan.divan_camileri.entity.ContentP;
import com.divan.divan_camileri.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/all")
    public ResponseEntity<List<ContentP>> findAllContent(){
        return ResponseEntity.ok(contentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentP> findContentById(@PathVariable Long id){
        return ResponseEntity.ok(contentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createContent(@RequestBody ContentDTO contentDTO){
        return ResponseEntity.ok(contentService.createContent(contentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteContent(@PathVariable Long id){
        return ResponseEntity.ok(contentService.deleteContent(id));
    }

}
