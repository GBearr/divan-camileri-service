package com.divan.divan_camileri.service;

import com.divan.divan_camileri.dto.IntangibleHeritageDTO;
import com.divan.divan_camileri.entity.IntangibleHeritageP;

import java.util.List;

public interface IntangibleHeritageService {

    List<IntangibleHeritageP> findAll();
    IntangibleHeritageP findById(Long id);
    Boolean createIntangibleHeritage(IntangibleHeritageDTO intangibleHeritageDTO);
    Boolean deleteIntangibleHeritage(Long id);
}
