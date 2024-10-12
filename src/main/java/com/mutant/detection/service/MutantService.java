package com.mutant.detection.service;

import org.springframework.stereotype.Service;

@Service
public class MutantService {

    // Metodo para detectar si el DNA pertenece a un mutante
    public boolean isMutant(String[] dna) {
        int n = dna.length;

        // Contador de secuencias mutantes encontradas
        int mutantSequences = 0;

        // Recorrer la matriz de ADN para buscar secuencias mutantes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hasHorizontalSequence(dna, i, j) || hasVerticalSequence(dna, i, j)
                        || hasDiagonalRightSequence(dna, i, j) || hasDiagonalLeftSequence(dna, i, j)) {
                    mutantSequences++;
                    if (mutantSequences > 1) {
                        return true;  // Más de una secuencia encontrada, es un mutante
                    }
                }
            }
        }
        return false;  // Si no se encontraron más de una secuencia, no es mutante
    }

    // Metodo para verificar secuencia horizontal
    private boolean hasHorizontalSequence(String[] dna, int row, int col) {
        if (col + 3 >= dna.length) return false;
        char base = dna[row].charAt(col);
        return base == dna[row].charAt(col + 1) && base == dna[row].charAt(col + 2) && base == dna[row].charAt(col + 3);
    }

    // Metodo para verificar secuencia vertical
    private boolean hasVerticalSequence(String[] dna, int row, int col) {
        if (row + 3 >= dna.length) return false;
        char base = dna[row].charAt(col);
        return base == dna[row + 1].charAt(col) && base == dna[row + 2].charAt(col) && base == dna[row + 3].charAt(col);
    }

    // Metodo para verificar secuencia diagonal hacia la derecha
    private boolean hasDiagonalRightSequence(String[] dna, int row, int col) {
        if (row + 3 >= dna.length || col + 3 >= dna.length) return false;
        char base = dna[row].charAt(col);
        return base == dna[row + 1].charAt(col + 1) && base == dna[row + 2].charAt(col + 2) && base == dna[row + 3].charAt(col + 3);
    }

    // Metodo para verificar secuencia diagonal hacia la izquierda
    private boolean hasDiagonalLeftSequence(String[] dna, int row, int col) {
        if (row + 3 >= dna.length || col - 3 < 0) return false;
        char base = dna[row].charAt(col);
        return base == dna[row + 1].charAt(col - 1) && base == dna[row + 2].charAt(col - 2) && base == dna[row + 3].charAt(col - 3);
    }
}
