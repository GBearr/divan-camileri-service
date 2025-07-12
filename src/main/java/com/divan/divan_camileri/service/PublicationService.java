package com.divan.divan_camileri.service;

import com.divan.divan_camileri.dto.PublicaitonsDTO;
import com.divan.divan_camileri.entity.PublicationsP;

import java.util.List;

public interface PublicationService {

    List<PublicationsP> findAll();
    PublicationsP findById(Long id);
    Boolean createPublication(PublicaitonsDTO publicaitonsDTO);
    Boolean deletePublication(Long id);
}
