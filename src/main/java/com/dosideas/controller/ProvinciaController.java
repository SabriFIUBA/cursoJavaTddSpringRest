package com.dosideas.controller;

import com.dosideas.domain.Provincia;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Este es un controlador de presentación (que se define anotándolo con
 * @Controller). Se encarga de atender peticiones HTTP y devolver una vista para
 * que muestre HTML al cliente.
 *
 * La anotación @RequestMapping en un método indica que ese método se invoca
 * cuando se recibe una petición HTTP con esa dirección. El método en cuestión
 * devuelve un Sring, que representa la vista (página HTML).
 */
@Controller
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @RequestMapping("/provincias")
    public String provincias(Model model) {
        List<Provincia> provincias = provinciaService.buscarTodos();
        model.addAttribute("provincias", provincias);
        return "provincia";
    }

}
