package com.divan.divan_camileri.controller;

import com.divan.divan_camileri.dto.IntangibleHeritageDTO;
import com.divan.divan_camileri.entity.IntangibleHeritageP;
import com.divan.divan_camileri.service.IntangibleHeritageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heritage")
@RequiredArgsConstructor
public class IntangibleHeritageController {

    private final IntangibleHeritageService intangibleHeritageService;

    @GetMapping("/all")
    public ResponseEntity<List<IntangibleHeritageP>> findAll(){
        return ResponseEntity.ok(intangibleHeritageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntangibleHeritageP> findIntangibleHeritageById(@PathVariable Long id){
        return ResponseEntity.ok(intangibleHeritageService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createIntangibleHeritage(@RequestBody IntangibleHeritageDTO intangibleHeritageDTO){
        return ResponseEntity.ok(intangibleHeritageService.createIntangibleHeritage(intangibleHeritageDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIntangibleHeritage(@PathVariable Long id){
        return ResponseEntity.ok(intangibleHeritageService.deleteIntangibleHeritage(id));
    }
}
