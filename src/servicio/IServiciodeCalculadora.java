package servicio;

import dominio.NumerosOpArit;
import dominio.NumerosLog;
import dominio.NumerosTrigo;

public interface IServiciodeCalculadora {

    // Aritmetica
    double suma(NumerosOpArit datos);
    double resta(NumerosOpArit datos);
    double multiplicacion(NumerosOpArit datos);
    double division(double a, double b);

    // Logaritmos
    double logNatural(NumerosLog datos);
    double logBase10(NumerosLog datos);

    // Trigonometria
    double seno(NumerosTrigo datos);
    double coseno(NumerosTrigo datos);
    double tangente(NumerosTrigo datos);
    // double arcotangente(NumerosTrigo datos);
}