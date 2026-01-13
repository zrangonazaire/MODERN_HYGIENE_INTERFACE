package com.bzdata.TataFneBackend.Funtionality;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bzdata.TataFneBackend.common.HttpResponse;

import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("functionality")
@RequiredArgsConstructor
@Tag(name = "functionality")
@Slf4j
public class FunctionalityController {

    private final FunctionalityService service;

    // ✅ Créer une fonctionnalité
    @PostMapping("/save")
    public ResponseEntity<HttpResponse> createFunctionality(@RequestBody FunctionalityDTO dto) {
        log.info("Creating functionality: {}", dto);
        FunctionalityDTO created = service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Functionality created successfully")
                        .statusCode(HttpStatus.CREATED.value())
                        .httpStatus(HttpStatus.CREATED)
                        .data(Map.of("functionality", created))
                        .build()
        );
    }

    // ✅ Mettre à jour une fonctionnalité
    @PutMapping("/{id}")
    public ResponseEntity<HttpResponse> updateFunctionality(
            @PathVariable int id,
            @RequestBody FunctionalityDTO dto
    ) {
        log.info("Updating functionality id {} with data {}", id, dto);
        FunctionalityDTO updated = service.update(id, dto);

        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Functionality updated successfully")
                        .statusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .data(Map.of("functionality", updated))
                        .build()
        );
    }

    // ✅ Supprimer une fonctionnalité
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse> deleteFunctionality(@PathVariable int id) {
        log.info("Deleting functionality with id {}", id);
        service.delete(id);

        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Functionality deleted successfully")
                        .statusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .build()
        );
    }

    // ✅ Récupérer une fonctionnalité par ID
    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> getFunctionalityById(@PathVariable int id) {
        log.info("Fetching functionality with id {}", id);
        FunctionalityDTO dto = service.getById(id);

        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Functionality retrieved successfully")
                        .statusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .data(Map.of("functionality", dto))
                        .build()
        );
    }

    // ✅ Récupérer toutes les fonctionnalités
    @GetMapping
    public ResponseEntity<HttpResponse> getAllFunctionalities() {
        log.info("Fetching all functionalities");
        List<FunctionalityDTO> list = service.getAll();

        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Functionalities retrieved successfully")
                        .statusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .data(Map.of("functionalities", list))
                        .build()
        );
    }
}
