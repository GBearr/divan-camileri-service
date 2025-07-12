package com.divan.divan_camileri.service;

import com.divan.divan_camileri.dto.MosqueDTO;
import com.divan.divan_camileri.entity.MosqueP;

import java.util.List;

public interface MosqueService {

    List<MosqueP> findAll();
    MosqueP findById(Long id);
    Boolean createMosque(MosqueDTO mosqueDTO);
    Boolean deleteMosque(Long id);
}
