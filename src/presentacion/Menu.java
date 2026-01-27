package presentacion;

import dominio.*;
import servicio.IServiciodeCalculadora;
import servicio.ServiciodeCalculadora;

import java.util.Scanner;

public class Menu {

    // Variables globales para la clase Menu
    private static final Scanner entrada = new Scanner(System.in);

    // Declaramos la Interfaz, instanciamos la Implementacion
    private static final IServiciodeCalculadora calculadora = new ServiciodeCalculadora();

    public static void main(String[] args) {

        var salir = false;

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
                    \n========= CALCULADORA CIENTIFICA =========
                        1. Operaciones Aritméticas
                        2. Logaritmos
                        3. Trigonometría
                        0. Salir
                    """);
        System.out.print("Ingrese una opción: ");
    }

    private static boolean ejecutarOpciones() {
        int opcion = Integer.parseInt(entrada.nextLine());
        var salir = false;

        switch (opcion) {
            case 1 -> menuAritmetica();
            case 2 -> {
                menuLogaritmos();
                pausarConsola();
            }
            case 3 -> {
                menuTrigonometria();
                pausarConsola();
            }
            case 0 -> {
                System.out.println("\nPrograma finalizado...");
                salir = true;
            }
            default -> System.out.println("\nOpción inválida.");
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
                        pausarConsola();
                    }
                    case 2 -> {
                        double[] nums = pedirNumerosArray();
                        NumerosOpArit datos = new NumerosOpArit(nums);
                        System.out.println("Resultado resta: " + calculadora.resta(datos));
                        pausarConsola();
                    }
                    case 3 -> {
                        double[] nums = pedirNumerosArray();
                        NumerosOpArit datos = new NumerosOpArit(nums);
                        System.out.println("Resultado multiplicacion: " + calculadora.multiplicacion(datos));
                        pausarConsola();
                    }
                    case 4 -> {
                        System.out.println("\nIngrese numerador:");
                        double a = Double.parseDouble(entrada.nextLine());
                        System.out.println("Ingrese denominador:");
                        double b = Double.parseDouble(entrada.nextLine());

                        System.out.println("Resultado división: " + calculadora.division(a, b));
                        pausarConsola();
                    }
                    case 0 -> salirSub = true;
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
                        pausarConsola();
                    }

                    case 2 -> {
                        System.out.print("\nIngrese el ángulo en grados: ");
                        double g = Double.parseDouble(entrada.nextLine());
                        NumerosTrigo angulo = new NumerosTrigo(g);

                        System.out.println("Coseno: " + calculadora.coseno(angulo));
                        pausarConsola();
                    }

                    case 3 -> {
                        System.out.print("\nIngrese el ángulo en grados: ");
                        double g = Double.parseDouble(entrada.nextLine());
                        NumerosTrigo angulo = new NumerosTrigo(g);

                        System.out.println("Tangente: " + calculadora.tangente(angulo));
                        pausarConsola();
                    }

                    case 0 -> salirSub = true;

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