package com.tantalean.apihorariomed.controller;

import com.tantalean.apihorariomed.dto.ScheduleRequest;
import com.tantalean.apihorariomed.dto.ScheduleResponse;
import com.tantalean.apihorariomed.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@CrossOrigin
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @GetMapping
    public List<ScheduleResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ScheduleResponse obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @PostMapping
    public ResponseEntity<ScheduleResponse> crear(@Valid @RequestBody ScheduleRequest req) {
        return ResponseEntity.ok(service.crear(req));
    }

    @PutMapping("/{id}")
    public ScheduleResponse actualizar(@PathVariable Integer id,
                                        @Valid @RequestBody ScheduleRequest req) {
        return service.actualizar(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
