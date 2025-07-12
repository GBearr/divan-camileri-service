package com.divan.divan_camileri.service.implementation;

import com.divan.divan_camileri.dto.ContentDTO;
import com.divan.divan_camileri.entity.ContentP;
import com.divan.divan_camileri.repository.ContentRepository;
import com.divan.divan_camileri.service.ContentService;
import com.divan.divan_camileri.validator.ContentValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public final class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final ContentValidator contentValidator;
    private final ObjectMapper objectMapper;


    @Override
    public List<ContentP> findAll() {
        return contentRepository.findAll();
    }

    @Override
    public ContentP findById(Long id) {
        return contentRepository.findById(id)
                .orElseGet(() -> {
                    log.warn("Content not found with id : {}",id);
                    return new ContentP();
                });
    }

    @Override
    public Boolean createContent(ContentDTO contentDTO) {
        if (!contentValidator.isValid(contentDTO)) return false;
        ContentP content = objectMapper.convertValue(contentDTO,ContentP.class);
        contentRepository.save(content);
        return true;
    }

    @Override
    public Boolean deleteContent(Long id) {
        if (!contentRepository.existsById(id)) return false;
        contentRepository.deleteById(id);
        return true;
    }
}
