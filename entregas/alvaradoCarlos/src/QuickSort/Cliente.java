import java.util.Scanner;

public class Cliente {
    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);
        boolean continuar = true;

        do {
            imprimirMenu();
            int[] datos = {5, 2, 8, 1, 9, 3};
            System.out.print("¿Opción?: ");

            switch (lector.nextInt()) {
                case 1 -> {
                    System.out.println("--- Ejecutando QuickSort Recursivo ---");
                    QuickSort.ordenar(datos, 0, datos.length - 1);
                }
                case 2 -> {
                    System.out.println("Saliendo...");
                    continuar = false;
                }
                default -> {
                    System.out.println("Opción no válida.");
                }
            }

            if (continuar) {
                System.out.println("\nPresione Enter para volver al menú...");
                lector.nextLine(); 
                lector.nextLine();
            }

        } while (continuar);

        lector.close();
    }

    public static void imprimirMenu() {
        System.out.println("\n--- Ordenación: Quick Sort ---");
        System.out.println("1: Versión Recursiva");
        System.out.println("2: Salir");
    }
}