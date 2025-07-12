package com.divan.divan_camileri.controller;

import com.divan.divan_camileri.dto.AboutDTO;
import com.divan.divan_camileri.entity.AboutP;
import com.divan.divan_camileri.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @GetMapping("/all")
    public ResponseEntity<List<AboutP>> findAllAbout(){
        return ResponseEntity.ok(aboutService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutP> findAboutById(@PathVariable Long id){
        return ResponseEntity.ok(aboutService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createAbout(@RequestBody AboutDTO aboutDTO){
        return ResponseEntity.ok(aboutService.createAbout(aboutDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAbout(@PathVariable Long id){
        return ResponseEntity.ok(aboutService.deleteAbout(id));
    }
}
