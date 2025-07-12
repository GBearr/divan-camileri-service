package com.divan.divan_camileri.repository;

import com.divan.divan_camileri.entity.IntangibleHeritageP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntangibleHeritageRepository extends JpaRepository<IntangibleHeritageP,Long> {
}
