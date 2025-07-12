package com.divan.divan_camileri.service.implementation;

import com.divan.divan_camileri.dto.MosqueDTO;
import com.divan.divan_camileri.entity.MosqueP;
import com.divan.divan_camileri.repository.MosqueRepository;
import com.divan.divan_camileri.service.MosqueService;
import com.divan.divan_camileri.validator.MosqueValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public final class MosqueServiceImpl implements MosqueService {

    private final MosqueRepository mosqueRepository;
    private final MosqueValidator mosqueValidator;
    private final ObjectMapper objectMapper;

    @Override
    public List<MosqueP> findAll() {
        return mosqueRepository.findAll();
    }

    @Override
    public MosqueP findById(Long id) {
        return mosqueRepository.findById(id)
                .orElseGet(() -> {
                log.warn("Mosque not found with id : {}",id);
                return new MosqueP();
        });
    }

    @Override
    public Boolean createMosque(MosqueDTO mosqueDTO) {
        if (!mosqueValidator.isValid(mosqueDTO)) return false;
        MosqueP mosque = objectMapper.convertValue(mosqueDTO,MosqueP.class);
        mosqueRepository.save(mosque);
        return true;
    }

    @Override
    public Boolean deleteMosque(Long id) {
        if (!mosqueRepository.existsById(id)) return false;
        mosqueRepository.deleteById(id);
        return true;
    }
}
