package com.divan.divan_camileri.controller;

import com.divan.divan_camileri.dto.MosqueDTO;
import com.divan.divan_camileri.entity.MosqueP;
import com.divan.divan_camileri.service.MosqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mosque")
@RequiredArgsConstructor
public class MosqueController {

    private final MosqueService mosqueService;

    @GetMapping("/all")
    public ResponseEntity<List<MosqueP>> getAllMosques() {
        return ResponseEntity.ok(mosqueService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MosqueP> getMosqueById(@PathVariable Long id){
        return ResponseEntity.ok(mosqueService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createMosque(@RequestBody MosqueDTO mosqueDTO){
        return ResponseEntity.ok(mosqueService.createMosque(mosqueDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMosque(@PathVariable Long id){
        return ResponseEntity.ok(mosqueService.deleteMosque(id));
    }
}
