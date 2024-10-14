package com.mutant.detection.controller;

import com.mutant.detection.repository.ADNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private ADNRepository adnRepository;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getStats() {
        long countMutants = adnRepository.countByIsMutant(true);
        long countHumans = adnRepository.countByIsMutant(false);
        double ratio = countHumans == 0 ? 0 : (double) countMutants / countHumans;

        Map<String, Object> stats = new HashMap<>();
        stats.put("count_mutant_dna", countMutants);
        stats.put("count_human_dna", countHumans);
        stats.put("ratio", ratio);

        return ResponseEntity.ok(stats);
    }
}
