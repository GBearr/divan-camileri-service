package com.divan.divan_camileri.service.implementation;

import com.divan.divan_camileri.dto.PublicaitonsDTO;
import com.divan.divan_camileri.entity.PublicationsP;
import com.divan.divan_camileri.repository.PublicationRepository;
import com.divan.divan_camileri.service.PublicationService;
import com.divan.divan_camileri.validator.PublicationValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public final class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;
    private final PublicationValidator publicationValidator;
    private final ObjectMapper objectMapper;

    @Override
    public List<PublicationsP> findAll() {
        return publicationRepository.findAll();
    }

    @Override
    public PublicationsP findById(Long id) {
        return publicationRepository.findById(id)
                .orElseGet(() -> {
                    log.warn("Publication not found with id : {}",id);
                    return new PublicationsP();
                });
    }

    @Override
    public Boolean createPublication(PublicaitonsDTO publicaitonsDTO) {
        if (!publicationValidator.isValid(publicaitonsDTO)) return false;
        PublicationsP publication = objectMapper.convertValue(publicaitonsDTO,PublicationsP.class);
        publicationRepository.save(publication);
        return true;
    }

    @Override
    public Boolean deletePublication(Long id) {
        if (!publicationRepository.existsById(id)) return false;
        publicationRepository.deleteById(id);
        return true;
    }
}
