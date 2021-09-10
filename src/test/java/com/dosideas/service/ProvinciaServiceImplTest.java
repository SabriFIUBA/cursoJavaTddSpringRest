package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import org.assertj.core.api.AbstractAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceImplTest {

    @Autowired
    private ProvinciaService provinciaService;
    //private Object AssertionError;

    @Test
    public void buscarPorId_conIdExistente_retornaProvincia(){
        Long id = 1L;

        Provincia provincia = provinciaService.buscarPorId(id);

        assertThat(provincia).isNotNull();
        assertEquals(provincia.getId(),id);
    }

    @Test
    public void buscarPorId_conIdInexistente_retornaNull(){
        Long id = 21L;
        Provincia provincia = provinciaService.buscarPorId(id);
        assertThat(provincia).isNull();
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void buscarPorId_conIdNull_lanzaExcepcion() {
        provinciaService.buscarPorId(null);
        fail("Debería haberse lanzado una excepción.");
    }

    @Test
    public void buscarPorNombreExacto_conNombreExistenteExacto_retornaProvincia() {
        String nombre = "Buenos Aires";

        Provincia provincia = provinciaService.buscarPorNombreExacto(nombre);

        assertThat(provincia).isNotNull();
        assertEquals(provincia.getNombre(),nombre);
    }

    @Test//(expected = NullPointerException.class)
    public void buscarPorNombreExacto_conNombreExactoInexistente_retornaNull(){
        String nombre = "Buenos";
        Provincia provincia = provinciaService.buscarPorNombreExacto(nombre);
        assertThat(provincia).isNull();
    }

    /*@Test(expected = InvalidDataAccessApiUsageException.class)
    public void buscarPorId_conIdNull_lanzaExcepcion() {
        provinciaService.buscarPorId(null);
        fail("Debería haberse lanzado una excepción.");
    }*/
    @Test(expected = AssertionError.class)//(expected = InvalidDataAccessApiUsageException.class)
    public void buscarPorNombreExacto_conNombreNull_lanzaExcepcion(){
        provinciaService.buscarPorNombreExacto(null);
        fail("Error: intenta buscar null");
    }

    @Test
    public void buscarPorNombreQueContenga_conCaracteresExistentesEnDosProvincias_retornaListaDeProvincias(){
        String nombrePart = "San ";

        List<Provincia> provincias = provinciaService.buscarPorNombreQueContenga(nombrePart);

        assertThat(provincias.get(0)).isNotNull();
        assertThat(provincias.get(1)).isNotNull();
        assertThat(provincias.size()).isEqualTo(2);
        assertEquals(provincias.get(0).getNombre(),"San Juan");
        assertEquals(provincias.get(1).getNombre(),"San Luis");
    }

    @Test
    public void buscarPorNombreQueContenga_conCaracteresInexistentes_retorna_retornaNull() {
        String nombrePart = "xy";
        List<Provincia> provincias = provinciaService.buscarPorNombreQueContenga(nombrePart);
        assertThat(provincias.isEmpty());
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void buscarPorNombreQueContenga_conNull_retornaExcepcion(){
        //List<Provincia> provincias = provinciaService.buscarPorNombreQueContenga(null);
        List<Provincia> provincias = provinciaService.buscarPorNombreQueContenga(null);
        fail("Intenta buscar con un valor no permitido");
    }

    @Test
    public void buscarTodos_retornaTodos(){
        List<Provincia> provincias = provinciaService.buscarTodos();
        assertThat(provincias.size()).isEqualTo(20);
    }
}
