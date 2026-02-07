package servicio;

import dominio.Auditoria;

import java.util.ArrayList;
import java.util.List;

public class ServicioAuditoria implements IServicioAuditoria{

    // Lista en memoria para guardar lo que pasa en la sesión actual
    private final List<Auditoria> historial = new ArrayList<>();

    @Override
    public void registrarAuditoria(String accion, String detalle) {
        Auditoria log = new Auditoria(accion, detalle);
        historial.add(log);
    }

    @Override
    public void mostrarAuditoria() {
        System.out.println("\n========== REPORTE AUDITORÍA ==========");
        if(historial.isEmpty()){
            System.out.println("No hay movimientos registrados.");
        }else{
            historial.forEach(System.out::println);
        }
        System.out.println("===========================================");
    }
}
