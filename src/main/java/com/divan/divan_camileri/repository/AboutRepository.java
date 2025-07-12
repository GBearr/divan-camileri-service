package com.divan.divan_camileri.repository;

import com.divan.divan_camileri.entity.AboutP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<AboutP,Long> {
}
