package com.divan.divan_camileri.repository;

import com.divan.divan_camileri.entity.ContentP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<ContentP,Long> {
}
