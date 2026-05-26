package com.example.peliculasservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.peliculasservice.dto.PeliculaDTO;
import com.example.peliculasservice.model.Pelicula;
import com.example.peliculasservice.service.PeliculaService;


@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }


    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> listarPeliculas() {
        List<Pelicula> peliculas = peliculaService.findAll();
        List<PeliculaDTO> dtos = peliculas.stream().map(PeliculaDTO::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> findById(@PathVariable Long id) {
        Pelicula pelicula = peliculaService.findById(id);

        if (pelicula == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pelicula);
    }


	@PostMapping
	public ResponseEntity<PeliculaDTO> crearCine(@RequestBody PeliculaDTO PeliculaDto) {
		Pelicula nuevo = peliculaService.save(PeliculaDto.toModel());
		return ResponseEntity.ok(PeliculaDTO.fromModel(nuevo));
	}


    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Long id, @RequestBody Pelicula Pelicula) {

        Pelicula pelicula = peliculaService.update(id, Pelicula);
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pelicula);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {

        Pelicula pelicula = peliculaService.findById(id);
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }
        peliculaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> existePelicula(@PathVariable Long id) {
        return ResponseEntity.ok(peliculaService.existById(id));
    }
}
