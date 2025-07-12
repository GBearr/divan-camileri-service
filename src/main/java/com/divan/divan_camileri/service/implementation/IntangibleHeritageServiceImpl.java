package com.divan.divan_camileri.service.implementation;

import com.divan.divan_camileri.dto.IntangibleHeritageDTO;
import com.divan.divan_camileri.entity.IntangibleHeritageP;
import com.divan.divan_camileri.repository.IntangibleHeritageRepository;
import com.divan.divan_camileri.service.IntangibleHeritageService;
import com.divan.divan_camileri.validator.IntangibleHeritageValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public final class IntangibleHeritageServiceImpl implements IntangibleHeritageService {

    private final IntangibleHeritageRepository intangibleHeritageRepository;
    private final IntangibleHeritageValidator intangibleHeritageValidator;
    private final ObjectMapper objectMapper;

    @Override
    public List<IntangibleHeritageP> findAll() {
        return intangibleHeritageRepository.findAll();
    }

    @Override
    public IntangibleHeritageP findById(Long id) {
        return intangibleHeritageRepository.findById(id)
                .orElseGet(() -> {
                    log.warn("Intangible heritage not found with id : {}",id);
                    return new IntangibleHeritageP();
                });
    }

    @Override
    public Boolean createIntangibleHeritage(IntangibleHeritageDTO intangibleHeritageDTO) {
        if (!intangibleHeritageValidator.isValid(intangibleHeritageDTO)) return false;
        IntangibleHeritageP intangibleHeritage = objectMapper
                .convertValue(intangibleHeritageDTO,IntangibleHeritageP.class);
        intangibleHeritageRepository.save(intangibleHeritage);
        return true;
    }

    @Override
    public Boolean deleteIntangibleHeritage(Long id) {
        if (!intangibleHeritageRepository.existsById(id)) return false;
        intangibleHeritageRepository.deleteById(id);
        return true;
    }
}
