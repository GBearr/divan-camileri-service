package com.divan.divan_camileri.service.implementation;

import com.divan.divan_camileri.dto.AboutDTO;
import com.divan.divan_camileri.entity.AboutP;
import com.divan.divan_camileri.repository.AboutRepository;
import com.divan.divan_camileri.service.AboutService;
import com.divan.divan_camileri.validator.AboutValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public final class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;
    private final AboutValidator aboutValidator;
    private final ObjectMapper objectMapper;

    @Override
    public List<AboutP> findAll() {
        return aboutRepository.findAll();
    }

    @Override
    public AboutP findById(Long id) {
        return aboutRepository.findById(id)
                .orElseGet(() -> {
                    log.warn("About not found with id : {}",id);
                    return new AboutP();
                });
    }

    @Override
    public Boolean createAbout(AboutDTO aboutDTO) {
        if (!aboutValidator.isValid(aboutDTO)) return false;
        AboutP about = objectMapper.convertValue(aboutDTO,AboutP.class);
        aboutRepository.save(about);
        return true;
    }

    @Override
    public Boolean deleteAbout(Long id) {
        if (!aboutRepository.existsById(id)) return false;
        aboutRepository.deleteById(id);
        return true;
    }
}
