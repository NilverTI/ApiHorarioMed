package com.tantalean.apihorariomed.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ScheduleRequest {

    @NotBlank
    public String nombre;

    @NotBlank
    public String dosis;

    @NotBlank
    public String hora; // HH:mm

    @NotBlank
    public String frecuencia;

    public String notas;

    @NotNull
    public Boolean activo;
}
