package com.bzdata.TataFneBackend.rolefunctionality;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role-functionalities")
@Tag(name = "role-functionalities")
@RequiredArgsConstructor
public class RoleFunctionalityController {

    private final RoleFunctionalityService service;

    @PostMapping
    public ResponseEntity<RoleFunctionalityDTO> create(@RequestBody RoleFunctionalityDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleFunctionalityDTO> update(@PathVariable Integer id, @RequestBody RoleFunctionalityDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RoleFunctionalityDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleFunctionalityDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<RoleFunctionalityDTO>> getByRoleId(@PathVariable Integer roleId) {
        return ResponseEntity.ok(service.getByRoleId(roleId));
    }
}
