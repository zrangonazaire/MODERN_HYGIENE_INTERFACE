package com.bzdata.GestionCinema.gestionSocieteEntrepriseService;

import com.bzdata.GestionCinema.common.HttpResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/etablissements")
@Tag(name="etablissement")
public class EtablissementController {

    private final EtablissementService etablissementService;


    @PostMapping("/create")
    public ResponseEntity<HttpResponse> create(@Valid @RequestBody EtablissementRequestDTO etablissementRequestDTO) {
        log.info("We creating a new {}", etablissementRequestDTO);
        EtablissementResponseDTO saved = etablissementService.create(etablissementRequestDTO);
        log.info("We are created a new etbalissement{}", saved);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("etablissement created successfully")
                        .statusCode(OK.value())
                        .data(Map.of("etablissement", saved))
                        .build()
        );

    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpResponse> update(@PathVariable int id,@RequestBody EtablissementRequestDTO etablissementRequestDTO) {
        log.info("We are going to update the record of etablissement with the id {},and bodyrequest {}", id, etablissementRequestDTO);
        var newetabRecord=etablissementService.update(id, etablissementRequestDTO);
        log.info("We are creation with successfully the updated the record  {}",  newetabRecord);
       return ResponseEntity.ok().body(
         HttpResponse.builder().timeStamp(now().toString())
                 .message("etablissement updated successfully")
                 .statusCode(OK.value())
                 .data(Map.of("etablissement", newetabRecord))
                 .build()
       );
    }
    @GetMapping
    public ResponseEntity<HttpResponse> findAll() {
        List<EtablissementResponseDTO> all = etablissementService.getAll();
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Featching all the etablissements successfully")
                        .statusCode(OK.value())
                        .httpStatus(OK)
                        .data(Map.of("data",all))
                        .build()
        );
    }
    @GetMapping("/societe/{idSociete}")
    public ResponseEntity<HttpResponse> getAllEtablissementByIdSociete(@PathVariable int idSociete) {
        log.info("Fetching all etablissement  with id societe {}", idSociete);
        List<EtablissementResponseDTO> all = etablissementService.getAllEtablissementByIdSociete(idSociete);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Featching all the etablissements by etablissement successfully")
                        .statusCode(OK.value())
                        .httpStatus(OK)
                        .data(Map.of("data",all))
                        .build()
        );
    }

}
