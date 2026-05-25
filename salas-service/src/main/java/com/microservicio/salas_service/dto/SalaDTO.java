package com.microservicio.salas_service.dto;

import com.microservicio.salas_service.model.Sala;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaDTO {
    private Long id;
    private String nombre;
    private int capacidad;
    private String tipo;
    private Long cineId;



    public Sala toModel() {
        return new Sala(id, nombre, capacidad, tipo, cineId);
    }

    public static SalaDTO fromModel(Sala s) {
        if (s == null) return null;
        return new SalaDTO(s.getId(),s.getNombre(),s.getCapacidad(),s.getTipo(),s.getCineId());
    }
}




    