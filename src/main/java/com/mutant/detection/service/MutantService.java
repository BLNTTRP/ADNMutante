package com.mutant.detection.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutantService {

    private static final int SEQUENCE_LENGTH = 4;

    public boolean isMutant(List<String> dna) {
        int n = dna.size();
        char[][] matrix = new char[n][n];

        // build matrix from the input DNA sequences
        for (int i = 0; i < n; i++) {
            matrix[i] = dna.get(i).toCharArray();
        }

        int mutantSequences = 0;

        // check horizontally and vertically
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // horizontal check
                if (j + SEQUENCE_LENGTH <= n && hasConsecutive(matrix, i, j, 0, 1)) {
                    mutantSequences++;
                    if (mutantSequences > 1) return true;
                }
                // vertical check
                if (i + SEQUENCE_LENGTH <= n && hasConsecutive(matrix, i, j, 1, 0)) {
                    mutantSequences++;
                    if (mutantSequences > 1) return true;
                }
                // diagonal checks
                if (i + SEQUENCE_LENGTH <= n && j + SEQUENCE_LENGTH <= n && hasConsecutive(matrix, i, j, 1, 1)) {
                    mutantSequences++;
                    if (mutantSequences > 1) return true;
                }
                if (i + SEQUENCE_LENGTH <= n && j - SEQUENCE_LENGTH + 1 >= 0 && hasConsecutive(matrix, i, j, 1, -1)) {
                    mutantSequences++;
                    if (mutantSequences > 1) return true;
                }
            }
        }

        return false; // return false if less than two sequences found
    }

    // check for four consecutive identical characters
    private boolean hasConsecutive(char[][] matrix, int row, int col, int rowDir, int colDir) {
        char firstChar = matrix[row][col];
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (matrix[row + i * rowDir][col + i * colDir] != firstChar) {
                return false;
            }
        }
        return true;
    }
}
