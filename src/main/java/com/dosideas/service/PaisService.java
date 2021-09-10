package com.dosideas.service;

import com.dosideas.domain.Pais;

import java.util.List;

/** Esta es la interfaz (contrato) de un componente de la capa de lógica de negocio.
 * Contiene las operaciones que la capa de lógica de negocio expone para operar
 * con instancias de Pais.
 */
public interface PaisService {

    Pais buscarPorId(Long id);

    List<Pais> buscarTodos();
}
