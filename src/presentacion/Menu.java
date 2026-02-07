package presentacion;

import dominio.*;
import servicio.*;

import java.util.Scanner;

public class Menu {

    // Variables globales para la clase Menu
    private static final Scanner entrada = new Scanner(System.in);

    // Declaramos la Interfaz, instanciamos la Implementacion
    private static final IServiciodeCalculadora calculadora = new ServiciodeCalculadora();
    private static final IServicioAuditoria auditoria = new ServicioAuditoriaArchivo();

    public static void main(String[] args) {

        var salir = false;

        auditoria.registrarAuditoria("INICIO", "El usuario inició el programa");

        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones();
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                entrada.nextLine(); // Limpiar buffer
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                    \n========= CALCULADORA CIENTÍFICA =========
                        1. Operaciones Aritméticas
                        2. Logaritmos
                        3. Trigonometría
                        4. Auditoría
                        0. Salir
                    """);
        System.out.print("Ingrese una opción: ");
    }

    private static boolean ejecutarOpciones() {
        int opcion = Integer.parseInt(entrada.nextLine());
        var salir = false;

        switch (opcion) {
            case 1 -> {
                auditoria.registrarAuditoria("SUBMENÚ", "Ingreso al submenu de operaciones Aritmeticas");
                menuAritmetica();
            }
            case 2 -> {
                auditoria.registrarAuditoria("SUBMENÚ", "Ingreso al submenu de Logaritmos");
                menuLogaritmos();
                pausarConsola();
            }
            case 3 -> {
                auditoria.registrarAuditoria("SUBMENÚ", "Ingreso al submenu de operaciones Trigonometricas");
                menuTrigonometria();
                pausarConsola();
            }
            case 4 -> {
                auditoria.registrarAuditoria("VISUALIZAR", "El usuario visualizó la Auditoría");
                auditoria.mostrarAuditoria();
                pausarConsola();
            }
            case 0 -> {
                System.out.println("\nPrograma finalizado...");
                auditoria.registrarAuditoria("SALIR", "El usuario cerró el programa");
                salir = true;
            }
            default -> {
                auditoria.registrarAuditoria("ERROR", "El usuario ingreso una opción inválida");
                System.out.println("\nOpción inválida.");
            }
        }
        return salir;
    }

    // SUBMENU ARITMETICA
    private static void menuAritmetica() {
        var salirSub = false;

        while (!salirSub) {
            System.out.println("""
                \n========= OPERACIONES ARITMETICAS =========
                    1. Suma
                    2. Resta
                    3. Multiplicación
                    4. División
                    0. Volver al menú principal
                """);
            System.out.print("Ingrese una opción: ");

            try {
                int opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 -> {
                        double[] nums = pedirNumerosArray();
                        NumerosOpArit datos = new NumerosOpArit(nums);
                        System.out.println("Resultado suma: " + calculadora.suma(datos));
                        auditoria.registrarAuditoria("SUMA", "El usuario sumó " + nums.length + " numeros que dio como resultado = " + calculadora.suma(datos));
                        pausarConsola();
                    }
                    case 2 -> {
                        double[] nums = pedirNumerosArray();
                        NumerosOpArit datos = new NumerosOpArit(nums);
                        System.out.println("Resultado resta: " + calculadora.resta(datos));
                        auditoria.registrarAuditoria("RESTA", "El usuario restó " + nums.length + " numeros que dio como resultado = " + calculadora.resta(datos));
                        pausarConsola();
                    }
                    case 3 -> {
                        double[] nums = pedirNumerosArray();
                        NumerosOpArit datos = new NumerosOpArit(nums);
                        System.out.println("Resultado multiplicacion: " + calculadora.multiplicacion(datos));
                        auditoria.registrarAuditoria("MULTIPLICACIÓN", "El usuario multiplicó " + nums.length + " numeros que dio como resultado = " + calculadora.multiplicacion(datos));
                        pausarConsola();
                    }
                    case 4 -> {
                        System.out.println("\nIngrese numerador:");
                        double a = Double.parseDouble(entrada.nextLine());
                        System.out.println("Ingrese denominador:");
                        double b = Double.parseDouble(entrada.nextLine());

                        System.out.println("Resultado división: " + calculadora.division(a, b));
                        auditoria.registrarAuditoria("DIVISIÓN", "El usuario dividió 2 numeros que dio como resultado = " + calculadora.division(a, b));
                        pausarConsola();
                    }
                    case 0 -> {
                        auditoria.registrarAuditoria("REGRESAR", "El usuario regresó al menú principal desde el submenú de Operaciones Aritmeticas");
                        pausarConsola();
                        salirSub = true;
                    }
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error en operación: " + e.getMessage());
            }
        }
    }

    // SUBMENU LOGARITMOS
    private static void menuLogaritmos() {
        try {
            System.out.print("\nIngrese un número: ");
            double n = Double.parseDouble(entrada.nextLine());
            NumerosLog num = new NumerosLog(n);

            System.out.println("Logaritmo natural: " + calculadora.logNatural(num));
            System.out.println("Logaritmo base 10: " + calculadora.logBase10(num));

            auditoria.registrarAuditoria("Log Natural", "El logaritmos natural de " + n + " dio como resultado = " + calculadora.logNatural(num));
            auditoria.registrarAuditoria("Log Base 10", "El logaritmos base 10 de " + n + " dio como resultado = " + calculadora.logBase10(num));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // SUBMENU TRIGONOMETRIA
    private static void menuTrigonometria() {

        var salirSub = false;

        try {
            while(!salirSub){

            System.out.println("""
                \n========= ECUACIONES TRIGONOMETRICAS =========
                    1. Seno
                    2. Coseno
                    3. Tangente
                    0. Volver al menú principal
                """);
            System.out.print("Ingrese una opción: ");
            int opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion){

                    case 1 -> {
                        System.out.print("\nIngrese el ángulo en grados: ");
                        double g = Double.parseDouble(entrada.nextLine());
                        NumerosTrigo angulo = new NumerosTrigo(g);

                        System.out.println("Seno: " + calculadora.seno(angulo));
                        auditoria.registrarAuditoria("SENO", "El usuario ingresó el ángulo de " + g + "° que dió como resultado = " + calculadora.seno(angulo));
                        pausarConsola();
                    }

                    case 2 -> {
                        System.out.print("\nIngrese el ángulo en grados: ");
                        double g = Double.parseDouble(entrada.nextLine());
                        NumerosTrigo angulo = new NumerosTrigo(g);

                        System.out.println("Coseno: " + calculadora.coseno(angulo));
                        auditoria.registrarAuditoria("COSENO", "El usuario ingresó el ángulo de " + g + "° que dió como resultado = " + calculadora.coseno(angulo));
                        pausarConsola();
                    }

                    case 3 -> {
                        System.out.print("\nIngrese el ángulo en grados: ");
                        double g = Double.parseDouble(entrada.nextLine());
                        NumerosTrigo angulo = new NumerosTrigo(g);

                        System.out.println("Tangente: " + calculadora.tangente(angulo));
                        auditoria.registrarAuditoria("TAGENTE", "El usuario ingresó el ángulo de " + g + "° que dió como resultado = " + calculadora.tangente(angulo));
                        pausarConsola();
                    }

                    case 0 -> {
                        auditoria.registrarAuditoria("REGRESAR", "El usuario regresó al menú principal desde el submenú de Trigonometria");
                        salirSub = true;
                    }

                    default -> System.out.println("Opción inválida.");

                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // METODOS AUXILIARES
    private static double[] pedirNumerosArray() {
        System.out.print("Ingrese la cantidad de numeros: ");
        int cant = Integer.parseInt(entrada.nextLine());
        double[] nums = new double[cant];

        for (int i = 0; i < cant; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            nums[i] = Double.parseDouble(entrada.nextLine());
        }
        return nums;
    }

    private static void pausarConsola() {
        System.out.println("\nPresione Enter para continuar...");
        entrada.nextLine();
    }
}