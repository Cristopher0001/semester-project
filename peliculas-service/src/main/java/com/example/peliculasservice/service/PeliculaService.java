package com.example.peliculasservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.peliculasservice.model.Pelicula;
import com.example.peliculasservice.repository.PeliculaRepository;


@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    public Pelicula findById(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula update(Long id, Pelicula updatedMovie) {

        Pelicula peli1 = peliculaRepository.findById(id).orElse(null);

        if (peli1 != null) {

            peli1.setTitulo(updatedMovie.getTitulo());
            peli1.setDescripcion(updatedMovie.getDescripcion());
            peli1.setDuracion(updatedMovie.getDuracion());
            peli1.setGenero(updatedMovie.getGenero());
            peli1.setClasificacion(updatedMovie.getClasificacion());

            return peliculaRepository.save(peli1);
        }
        return null;
    }

    public void delete(Long id) {
        peliculaRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return peliculaRepository.existsById(id);
    }
    
}
