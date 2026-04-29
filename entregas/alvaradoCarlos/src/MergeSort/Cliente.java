import java.util.Scanner;

public class Cliente {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        do {

            imprimirMenu();
            int[] array = {5, 2, 8, 1, 9, 3};

            System.out.print("¿Opción?: ");

            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.println("--- Ejecutando Versión Iterativa ---");
                    MergeSort.ordenarIterativo(array);
                }
                case 2 -> {
                    System.out.println("--- Ejecutando Versión Recursiva ---");
                    MergeSort.ordenar(array, 0, array.length - 1);
                }
                case 3 -> {
                    System.out.println("Saliendo...");
                    continuar = false;
                }
                default -> System.out.println("Opción no válida.");
            }

            if (continuar) {
                System.out.println("\nPresione Enter para volver al menú...");
                sc.nextLine(); 
                sc.nextLine();
            }

        } while (continuar);

        sc.close();
    }

    public static void imprimirMenu() {
        System.out.println("\n--- Ordenación: Merge Sort ---");
        System.out.println("1: Versión Iterativa");
        System.out.println("2: Versión Recursiva");
        System.out.println("3: Salir");
    }
}