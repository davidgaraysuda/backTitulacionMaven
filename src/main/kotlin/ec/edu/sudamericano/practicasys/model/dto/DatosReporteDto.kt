package ec.edu.sudamericano.practicasys.dto

import ec.edu.sudamericano.practicasys.model.ActivityDetailView


class DatosReporteDto {
    var nombreCompleto: String = ""
    var identificaciob: String = ""
    var nombreCarrera: String = ""
    var nombreInstirucionBeneficiaria: String = ""
    var numeroHoras: String = ""
    var inicioSemana: String = ""
    var finSemana: String = ""
    var nombreMesTexto: String = ""
    var anio: String = ""
    var detalleReporte: ArrayList<DetalleReporteDto> = ArrayList();
    var listActivities: List<ActivityDetailView> = ArrayList();
    var Actividades:ArrayList<actividadesDto> = ArrayList()


}