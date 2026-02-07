package servicio;

import dominio.NumerosLog;
import dominio.NumerosOpArit;
import dominio.NumerosTrigo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ServicioCalculadoraArchivo implements IServiciodeCalculadora{

    private final String NOMBRE_ARCHIVO = "calculadora.txt";

    public ServicioCalculadoraArchivo(){

        var archivo = new File(NOMBRE_ARCHIVO);

        try{
            if(archivo.exists()){
                System.out.println("EL ARCHIVO YA SE CREO, MAISTRO");
            }else{
                var salida = new PrintWriter(new FileWriter(archivo));
            }//finIf
        }catch (IOException e){
            System.out.println("Ocurrió un problema al escribir el archivo" + e.getMessage());
        }//FinTryCatch
    }//FinConstructor

    @Override
    public double suma(NumerosOpArit datos) {
        var archivo = new File(NOMBRE_ARCHIVO);

        return 0;
    }

    @Override
    public double resta(NumerosOpArit datos) {
        var archivo = new File(NOMBRE_ARCHIVO);
        return 0;
    }

    @Override
    public double multiplicacion(NumerosOpArit datos) {
        var archivo = new File(NOMBRE_ARCHIVO);
        return 0;
    }

    @Override
    public double division(double a, double b) {
        var archivo = new File(NOMBRE_ARCHIVO);
        return 0;
    }

    @Override
    public double logNatural(NumerosLog datos) {
        var archivo = new File(NOMBRE_ARCHIVO);
        return 0;
    }

    @Override
    public double logBase10(NumerosLog datos) {
        var archivo = new File(NOMBRE_ARCHIVO);
        return 0;
    }

    @Override
    public double seno(NumerosTrigo datos) {
        var archivo = new File(NOMBRE_ARCHIVO);
        return 0;
    }

    @Override
    public double coseno(NumerosTrigo datos) {
        var archivo = new File(NOMBRE_ARCHIVO);
        return 0;
    }

    @Override
    public double tangente(NumerosTrigo datos) {
        var archivo = new File(NOMBRE_ARCHIVO);
        return 0;
    }
}
