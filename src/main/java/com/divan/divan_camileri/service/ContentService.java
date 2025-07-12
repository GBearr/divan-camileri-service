package com.divan.divan_camileri.service;

import com.divan.divan_camileri.dto.ContentDTO;
import com.divan.divan_camileri.entity.ContentP;

import java.util.List;

public interface ContentService {

    List<ContentP> findAll();
    ContentP findById(Long id);
    Boolean createContent(ContentDTO contentDTO);
    Boolean deleteContent(Long id);

}
