escuelita.ui.provincia = (function () {

    var $bodyTablaProvincia = $("#bodyTablaProvincia");
    var $spanIdProvinciaEncontrado = $("#idProvinciaEncontrado");
    //var $spanNombreProvinciaEncontrado = $("#nombreProvinciaEncontrado")
    var $divMensajeNoEncontrado = $("#mensajeNoEncontrado");

    function inicializar() {
        buscar(1);
        bindearEventosABotones();
    }

    function buscar(idProvincia) {
        escuelita.service.provincia.buscarPorId(idProvincia)
            .done(mostrar)
            .fail(mostrarMensajeNoEncontrado);
    }

    /*function buscarPorNombreExacto(nombreProvincia){
        escuelita.service.provincia.buscarPorNombreExacto(nombreProvincia)
            .done(mostrar)
            .fail(mostrarMensajeNoEncontrado());
    }*/

    function mostrar(provincia) {
        $bodyTablaProvincia.html("<tr><td>" + provincia.id + "</td><td>" + provincia.nombre + "</td></tr>");
        $spanIdProvinciaEncontrado.text(provincia.id);
    }

    function bindearEventosABotones() {
        $("#botonBuscarProvinciaPorId").on("click", function () {
            //$("#nombreProvinciaABuscar").attr("value","");
            $("#mensajeNoEncontrado").addClass("hide");
            var idProvinciaABuscar = $("#idProvinciaABuscar").val();
            buscar(idProvinciaABuscar);
        });
        /*$("#botonBuscarProvinciaPorNombreExacto").on("click", function () {
            $("#mensajeNoEncontrado").addClass("hide");
            var nombreExactoProvinciaABuscar = $("#nombreExactoProvinciaABuscar").val();
            buscarPorNombreExacto(nombreExactoProvinciaABuscar);
        });*/
    }

    function mostrarMensajeNoEncontrado() {
        $bodyTablaProvincia.text("");
        $spanIdProvinciaEncontrado.text("");
        $divMensajeNoEncontrado.removeClass("hide");
    }

    return {
        inicializar: inicializar,
        buscar: buscar
        //buscarPorNombreExacto: buscarPorNombreExacto,
    };

})();

$(document).ready(function () {
    escuelita.ui.provincia.inicializar();
});