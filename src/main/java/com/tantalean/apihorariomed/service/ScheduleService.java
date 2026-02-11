package com.tantalean.apihorariomed.service;

import com.tantalean.apihorariomed.dto.*;
import com.tantalean.apihorariomed.exception.NotFoundException;
import com.tantalean.apihorariomed.model.Schedule;
import com.tantalean.apihorariomed.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository repository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public List<ScheduleResponse> listar() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public ScheduleResponse obtener(Integer id) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No encontrado"));
        return toResponse(schedule);
    }

    public ScheduleResponse crear(ScheduleRequest req) {
        Schedule schedule = new Schedule();
        aplicarRequest(schedule, req);
        return toResponse(repository.save(schedule));
    }

    public ScheduleResponse actualizar(Integer id, ScheduleRequest req) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No encontrado"));
        aplicarRequest(schedule, req);
        return toResponse(repository.save(schedule));
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id))
            throw new NotFoundException("No encontrado");
        repository.deleteById(id);
    }

    private void aplicarRequest(Schedule schedule, ScheduleRequest req) {
        schedule.setNombre(req.nombre);
        schedule.setDosis(req.dosis);
        schedule.setHora(LocalTime.parse(req.hora, formatter));
        schedule.setFrecuencia(req.frecuencia);
        schedule.setNotas(req.notas);
        schedule.setActivo(req.activo);
    }

    private ScheduleResponse toResponse(Schedule s) {
        ScheduleResponse r = new ScheduleResponse();
        r.id = s.getId();
        r.nombre = s.getNombre();
        r.dosis = s.getDosis();
        r.hora = s.getHora().format(formatter);
        r.frecuencia = s.getFrecuencia();
        r.notas = s.getNotas();
        r.activo = s.isActivo();
        return r;
    }
}
