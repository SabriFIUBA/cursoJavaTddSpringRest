package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {
    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public Provincia buscarPorId(Long id) {
        return provinciaRepository.findById(id).orElse(null);//mismo hacer .get()
    }

    @Override
    public Provincia buscarPorNombreExacto(String nombre) {
        return provinciaRepository.findByNombre(nombre).orElse(null);
    }

    @Override
    public List<Provincia> buscarTodos() {
        return provinciaRepository.findAll();
    }

    @Override
    public List<Provincia> buscarPorNombreQueContenga(String nombrePart) {
        return provinciaRepository.findAllByNombreContaining(nombrePart);
    }
}
