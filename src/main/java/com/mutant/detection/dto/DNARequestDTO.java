package com.mutant.detection.dto;

import java.util.List;

public class DNARequestDTO {

    private List<String> dna;

    public DNARequestDTO() {}

    // Getters y Setters
    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }
}
