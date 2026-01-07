package com.bzdata.GestionCinema.role;


import com.bzdata.GestionCinema.common.HttpResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import static java.time.LocalTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
@Tag(name = "roles")
@Slf4j
public class RoleController {

    private final RoleService service;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<HttpResponse> create(
            @RequestBody @Valid RoleDTO requestRoleDto
    ) throws MessagingException {
        log.info("We are going to create a new role {}", requestRoleDto.toString());
        var response=service.create(requestRoleDto);
        log.info("We are created a new user{}", response);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Role created successfully")
                        .statusCode(OK.value())
                        .data(Map.of("role", response))
                        .build()
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpResponse> updateRole(
            @PathVariable int id,
            @RequestBody @Valid RoleDTO requestRoleDto
    ) {
        log.info("We are going to update role with id {} using data {}", id, requestRoleDto);

        RoleDTO updatedRole = service.update(id, requestRoleDto);

        log.info("Role updated successfully: {}", updatedRole);

        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Role updated successfully")
                        .statusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .data(Map.of("role", updatedRole))
                        .build()
        );
    }
    @GetMapping
    public ResponseEntity<HttpResponse> getAllRoles() {
        log.info("Fetching all roles...");
        List<RoleDTO> roles = service.getAll();

        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Roles retrieved successfully")
                        .statusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .data(Map.of("roles", roles))
                        .build()
        );
    }

    // ✅ Récupérer un rôle par ID
    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> getRoleById(@PathVariable int id) {
        log.info("Fetching role with id {}", id);
        RoleDTO role = service.getById(id);

        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Role retrieved successfully")
                        .statusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .data(Map.of("role", role))
                        .build()
        );
    }

    // ✅ Supprimer un rôle
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse> deleteRole(@PathVariable int id) {
        log.info("Deleting role with id {}", id);
        service.delete(id);

        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message("Role deleted successfully")
                        .statusCode(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .build()
        );
    }
}
