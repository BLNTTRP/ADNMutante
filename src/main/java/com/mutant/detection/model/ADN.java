package com.mutant.detection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ADN {

    @Id
    private String dnaSequence;
    private boolean isMutant;

    public ADN() {}

    public ADN(String dnaSequence, boolean isMutant) {
        this.dnaSequence = dnaSequence;
        this.isMutant = isMutant;
    }

    // Getters y Setters
    public String getDnaSequence() {
        return dnaSequence;
    }

    public void setDnaSequence(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }
}
