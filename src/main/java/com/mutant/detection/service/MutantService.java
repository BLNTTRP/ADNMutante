package com.mutant.detection.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutantService {

    // Metodo para detectar si el DNA pertenece a un mutante
    public boolean isMutant(List<String> dna) {
        // Convierte la lista a array
        String[] dnaArray = dna.toArray(new String[dna.size()]);

        int n = dnaArray.length;

        // Contador de secuencias mutantes encontradas
        int mutantSequences = 0;

        // Recorrer la matriz de ADN para buscar secuencias mutantes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hasHorizontalSequence(dnaArray, i, j) || hasVerticalSequence(dnaArray, i, j)
                        || hasDiagonalRightSequence(dnaArray, i, j) || hasDiagonalLeftSequence(dnaArray, i, j)) {
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
    private boolean hasHorizontalSequence(String[] dnaArray, int row, int col) {
        if (col + 3 >= dnaArray.length) return false;
        char base = dnaArray[row].charAt(col);
        return base == dnaArray[row].charAt(col + 1) && base == dnaArray[row].charAt(col + 2) && base == dnaArray[row].charAt(col + 3);
    }

    // Metodo para verificar secuencia vertical
    private boolean hasVerticalSequence(String[] dnaArray, int row, int col) {
        if (row + 3 >= dnaArray.length) return false;
        char base = dnaArray[row].charAt(col);
        return base == dnaArray[row + 1].charAt(col) && base == dnaArray[row + 2].charAt(col) && base == dnaArray[row + 3].charAt(col);
    }

    // Metodo para verificar secuencia diagonal hacia la derecha
    private boolean hasDiagonalRightSequence(String[] dnaArray, int row, int col) {
        if (row + 3 >= dnaArray.length || col + 3 >= dnaArray.length) return false;
        char base = dnaArray[row].charAt(col);
        return base == dnaArray[row + 1].charAt(col + 1) && base == dnaArray[row + 2].charAt(col + 2) && base == dnaArray[row + 3].charAt(col + 3);
    }

    // Metodo para verificar secuencia diagonal hacia la izquierda
    private boolean hasDiagonalLeftSequence(String[] dnaArray, int row, int col) {
        if (row + 3 >= dnaArray.length || col - 3 < 0) return false;
        char base = dnaArray[row].charAt(col);
        return base == dnaArray[row + 1].charAt(col - 1) && base == dnaArray[row + 2].charAt(col - 2) && base == dnaArray[row + 3].charAt(col - 3);
    }
}
