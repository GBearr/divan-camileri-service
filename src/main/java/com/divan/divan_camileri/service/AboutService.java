package com.divan.divan_camileri.service;

import com.divan.divan_camileri.dto.AboutDTO;
import com.divan.divan_camileri.entity.AboutP;

import java.util.List;

public interface AboutService {
    List<AboutP> findAll();
    AboutP findById(Long id);
    Boolean createAbout(AboutDTO aboutDTO);
    Boolean deleteAbout(Long id);
}
