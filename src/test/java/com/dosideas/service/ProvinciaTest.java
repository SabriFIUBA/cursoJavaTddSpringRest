package com.dosideas.service;

import com.dosideas.domain.Provincia;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProvinciaTest {

    @Test
    public void crearProvincia() {
        Long id = 1L;
        String nombre = "A";

        Provincia provincia = new Provincia();
        provincia.setId(id);
        provincia.setNombre(nombre);

        assertEquals(provincia.getId(), id);
        assertEquals(provincia.getNombre(), nombre);
    }


}
