package com.divan.divan_camileri.repository;

import com.divan.divan_camileri.entity.PublicationsP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<PublicationsP,Long> {
}
