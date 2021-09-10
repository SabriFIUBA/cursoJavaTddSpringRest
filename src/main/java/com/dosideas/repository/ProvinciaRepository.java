package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    Optional<Provincia> findByNombre(String nombre);

    Provincia findByNombreEquals(String nombre);

    List<Provincia> findAllByNombreContaining(String nombrePart);
}
