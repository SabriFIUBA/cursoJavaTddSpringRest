package com.dosideas.service;

import com.dosideas.domain.Provincia;

import java.util.List;

public interface ProvinciaService {
    Provincia buscarPorId(Long id);

    Provincia buscarPorNombreExacto(String nombre);

    List<Provincia> buscarTodos();

    List<Provincia> buscarPorNombreQueContenga(String nombrePart);


}
