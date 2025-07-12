package com.divan.divan_camileri.repository;

import com.divan.divan_camileri.entity.ProjectSectionP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectSectionRepository extends JpaRepository<ProjectSectionP,Long> {
}
