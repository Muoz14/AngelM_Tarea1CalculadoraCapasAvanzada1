package servicio;

import dominio.NumerosOpArit;
import dominio.NumerosLog;
import dominio.NumerosTrigo;

public class ServiciodeCalculadora implements IServiciodeCalculadora {

    // ================= ARITMETICA =================
    @Override
    public double suma(NumerosOpArit datos) {
        double suma = 0;
        for (double n : datos.getNumeros()) {
            suma += n;
        }
        return suma;
    }

    @Override
    public double resta(NumerosOpArit datos) {
        double[] nums = datos.getNumeros();
        if (nums.length == 0) return 0;

        double resta = nums[0];
        for (int i = 1; i < nums.length; i++) {
            resta -= nums[i];
        }
        return resta;
    }

    @Override
    public double multiplicacion(NumerosOpArit datos) {
        double[] nums = datos.getNumeros();
        if (nums.length == 0) return 0;

        double multiplicar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            multiplicar *= nums[i];
        }
        return multiplicar;
    }

    @Override
    public double division(double a, double b) {
        if (b == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return 0;
        }
        return a / b;
    }

    // ================= LOGARITMOS =================
    @Override
    public double logNatural(NumerosLog datos) {
        if (datos.getNumero() <= 0) {
            System.out.println("Error: El logaritmo solo existe para números positivos.");
            return 0;
        }
        return Math.log(datos.getNumero());
    }

    @Override
    public double logBase10(NumerosLog datos) {
        if (datos.getNumero() <= 0) {
            System.out.println("Error: El logaritmo solo existe para números positivos.");
            return 0;
        }
        return Math.log10(datos.getNumero());
    }

    // ================= TRIGONOMETRIA =================
    @Override
    public double seno(NumerosTrigo datos) {
        return Math.sin(datos.getRadianes());
    }

    @Override
    public double coseno(NumerosTrigo datos) {
        return Math.cos(datos.getRadianes());
    }

    @Override
    public double tangente(NumerosTrigo datos) {
        return Math.tan(datos.getRadianes());
    }
}