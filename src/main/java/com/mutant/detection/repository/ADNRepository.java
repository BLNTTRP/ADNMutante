package com.mutant.detection.repository;

import com.mutant.detection.model.ADN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ADNRepository extends JpaRepository<ADN, String> {
    boolean existsByDnaSequence(String dnaSequence);
    long countByIsMutant(Boolean isMutant);
}
