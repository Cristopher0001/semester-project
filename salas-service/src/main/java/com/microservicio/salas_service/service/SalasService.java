package com.microservicio.salas_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservicio.salas_service.model.Sala;
import com.microservicio.salas_service.repository.SalaRepository;

@Service
public class SalasService {

    private final SalaRepository salaRepository;
    private final WebClient webClient;

    @Value("${api.cine.exists}")
    private String cinePath;

    public SalasService(SalaRepository salaRepository, WebClient webClient) {

        this.salaRepository = salaRepository;
        this.webClient = webClient;
    }


    // GET ALL
    public List<Sala> findAll() {
        return salaRepository.findAll();
    }


    // GET BY ID
    public Sala findById(Long id) {

        return salaRepository.findById(id)
                .orElse(null);
    }


    // GET BY TIPO
    public List<Sala> findByTipo(String tipo) {

        return salaRepository.findByTipo(tipo);
    }


    // GET BY CINE
    public List<Sala> findByCine(Long cineId) {
        Boolean existeCine;

        try {
            existeCine = webClient.get()
                    .uri(String.format(cinePath, cineId))
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

        } catch (Exception e) {
            throw new RuntimeException("Error al validar cine");
        }

        if (Boolean.FALSE.equals(existeCine)) {
            throw new RuntimeException("Cine no encontrado");
        }
        return salaRepository.findByCineId(cineId);
    }


    // POST
    public Sala save(Sala sala) {
    Boolean existeCine;
    try {
        existeCine = webClient.get()
                .uri(String.format(cinePath, sala.getCineId()))
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    } catch (Exception e) {
        throw new RuntimeException(
                "Error al validar cine");
    }
    if (Boolean.FALSE.equals(existeCine)) {
        throw new RuntimeException(
                "Cine no encontrado");
    }
    return salaRepository.save(sala);
}


    // PUT
    public Sala update(Long id, Sala salaActualizada) {

        Sala salaExistente = findById(id);

        if (salaExistente != null) {
            salaExistente.setNombre(salaActualizada.getNombre());
            salaExistente.setCapacidad(salaActualizada.getCapacidad());
            salaExistente.setTipo(salaActualizada.getTipo());
            salaExistente.setCineId(salaActualizada.getCineId());
            return salaRepository.save(salaExistente);
        }
        return null;
    }


    // DELETE
    public void delete(Long id) {
        Sala sala = findById(id);
        if (sala != null) {
            salaRepository.delete(sala);
        }
    }

}