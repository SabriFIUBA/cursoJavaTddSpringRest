//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dosideas.controller.rest;

import com.dosideas.domain.Pais;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.PaisNoEncontradoException;
import com.dosideas.exception.ProvinciaNoEncontradoException;
import com.dosideas.service.PaisService;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/api/provincia"})
public class ProvinciaRestController {
    @Autowired
    private ProvinciaService provinciaService;

    public ProvinciaRestController() {
    }

    @GetMapping({"/{id}"})
    public Provincia buscarPorId(@PathVariable Long id) throws ProvinciaNoEncontradoException {
        Provincia provincia = this.provinciaService.buscarPorId(id);
        if (provincia == null) {
            throw new ProvinciaNoEncontradoException("Provincia no encontrada");
        } else {
            return provincia;
        }
    }
    /*@GetMapping({"/{nombre}"})
    public Provincia buscarPorNombreExacto(@PathVariable String nombre) throws ProvinciaNoEncontradoException {
        Provincia provincia = this.provinciaService.buscarPorNombreExacto(nombre);
        if (provincia == null) {
            throw new ProvinciaNoEncontradoException("Provincia no encontrada");
        } else {
            return provincia;
        }
    }*/
}
