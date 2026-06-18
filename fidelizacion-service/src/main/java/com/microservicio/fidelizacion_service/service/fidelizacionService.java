package com.microservicio.fidelizacion_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.microservicio.fidelizacion_service.model.Fidelizacion;
import com.microservicio.fidelizacion_service.repository.FidelizacionRepository;

@Service
public class fidelizacionService {

    private static final Logger logger =
            LoggerFactory.getLogger(fidelizacionService.class);

    private final FidelizacionRepository fidelizacionRepository;

    public fidelizacionService(FidelizacionRepository fidelizacionRepository) {
        this.fidelizacionRepository = fidelizacionRepository;
    }

    public Fidelizacion save(Fidelizacion fidelizacion) {

        logger.info("Guardando fidelizacion para usuario {}",
                fidelizacion.getUsuarioId());

        Fidelizacion fidelizacionGuardada =
                fidelizacionRepository.save(fidelizacion);

        logger.info("Fidelizacion guardada con id={}",
                fidelizacionGuardada.getId());

        return fidelizacionGuardada;
    }

    public List<Fidelizacion> findAll() {

        logger.info("Listando todas las fidelizaciones");

        return fidelizacionRepository.findAll();
    }

    public Fidelizacion findById(Long id) {

        logger.info("Buscando fidelizacion id={}", id);

        return fidelizacionRepository.findById(id).orElse(null);
    }

    public Fidelizacion update(Long id,
            Fidelizacion fidelizacionActualizada) {

        logger.info("Actualizando fidelizacion id={}", id);

        Fidelizacion fidelizacion =
                fidelizacionRepository.findById(id).orElse(null);

        if (fidelizacion != null) {

            fidelizacion.setUsuarioId(
                    fidelizacionActualizada.getUsuarioId());

            fidelizacion.setPuntos(
                    fidelizacionActualizada.getPuntos());

            fidelizacion.setNivel(
                    fidelizacionActualizada.getNivel());

            logger.info("Fidelizacion actualizada id={}", id);

            return fidelizacionRepository.save(fidelizacion);
        }

        logger.warn("No se encontro fidelizacion id={}", id);

        return null;
    }

    public void delete(Long id) {

        logger.info("Eliminando fidelizacion id={}", id);

        fidelizacionRepository.deleteById(id);

        logger.info("Fidelizacion eliminada id={}", id);
    }

    public boolean existById(Long id) {

        logger.info("Verificando existencia de fidelizacion id={}", id);

        return fidelizacionRepository.existsById(id);
    }
}