package com.divan.divan_camileri.repository;

import com.divan.divan_camileri.entity.MosqueP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MosqueRepository extends JpaRepository<MosqueP,Long> {


}
