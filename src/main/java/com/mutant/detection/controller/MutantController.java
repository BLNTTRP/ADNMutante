package com.mutant.detection.controller;

import com.mutant.detection.dto.DNARequestDTO;
import com.mutant.detection.model.ADN;
import com.mutant.detection.repository.ADNRepository;
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

    @Autowired
    private ADNRepository adnRepository;

    public MutantController(MutantService mutantService, ADNRepository adnRepository) {
        this.mutantService = mutantService;
        this.adnRepository = adnRepository;
    }

    @PostMapping("/")
    public ResponseEntity<String> isMutant(@RequestBody DNARequestDTO dnaRequest) {

        // Convertir la lista a una única cadena de ADN
        String dnaString = String.join("", dnaRequest.getDna());

        // Verificar si ya existe en la base de datos
        if (adnRepository.existsByDnaSequence(dnaString)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("DNA already exists");
        }

        // Verificar si es mutante
        boolean isMutant = mutantService.isMutant(dnaRequest.getDna());

        // Guardar el ADN en la base de datos
        ADN adn = new ADN(dnaString, isMutant);
        adnRepository.save(adn);

        // Responder según el resultado
        return isMutant ? ResponseEntity.status(HttpStatus.OK).body("Mutant detected")
                        : ResponseEntity.status(HttpStatus.FORBIDDEN).body("Human detected");

    }
}
