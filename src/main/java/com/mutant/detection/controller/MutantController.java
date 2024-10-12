package com.mutant.detection.controller;

import com.mutant.detection.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @PostMapping("/")
    public ResponseEntity<String> isMutant(@RequestBody String[] dna) {

        System.out.println("DNA received: " + String.join(",", dna));

        if (dna == null || dna.length == 0) {
            return new ResponseEntity<>("Invalid DNA data", HttpStatus.BAD_REQUEST); // 400 Bad Request
        }

        boolean isMutant = mutantService.isMutant(dna);

        if (isMutant) {
            return new ResponseEntity<>("Mutant detected!", HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>("Not a mutant.", HttpStatus.FORBIDDEN); // 403 Forbidden
        }
    }
}
