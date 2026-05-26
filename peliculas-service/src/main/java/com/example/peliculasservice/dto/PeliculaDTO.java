package com.example.peliculasservice.dto;

import com.example.peliculasservice.model.Pelicula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeliculaDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private int duracion;
    private String genero;
    private String clasificacion;



    public Pelicula toModel() {
        return new Pelicula(id,titulo,descripcion,duracion,genero,clasificacion);
    }

    public static PeliculaDTO fromModel(Pelicula p) {
        if (p == null) return null;
        return new PeliculaDTO(p.getId(),p.getTitulo(),p.getDescripcion(),p.getDuracion(),p.getGenero(),p.getClasificacion());
    }
}