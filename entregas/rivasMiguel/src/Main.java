import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int elementoABuscar;
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el número que desea buscar en la matriz: ");
        elementoABuscar = sc.nextInt();

        BeMo.buscarElemento(matriz, elementoABuscar);

        sc.close();
    }
}