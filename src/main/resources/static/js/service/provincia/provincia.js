escuelita.service.provincia = (function () {

    var urlService = "/api/provincia/";

    function buscarPorId(idProvincia) {
        var urlServiceBuscarPorId = urlService + idProvincia;
        return $.get(urlServiceBuscarPorId);
    }

    /*function buscarPorNombreExacto(nombreProvincia) {
        var urlServiceBuscarPorNombreExacto = urlService + nombreProvincia;
        return $.get(urlServiceBuscarPorNombreExacto);
    }*/

    return {
        buscarPorId: buscarPorId,
        //buscarPorNombreExacto: buscarPorNombreExacto
    };

})();