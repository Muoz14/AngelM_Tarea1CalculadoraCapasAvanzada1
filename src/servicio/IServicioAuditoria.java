package servicio;

public interface IServicioAuditoria {

    void registrarAuditoria(String accion, String detalle);
    void mostrarAuditoria();

}
