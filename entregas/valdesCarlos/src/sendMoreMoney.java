public class sendMoreMoney {

    static final char[] LETRAS = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};

    public static void main(String[] args) {
        int[] asignacion = new int[8];      
        boolean[] usados = new boolean[10]; 

        System.out.println("Buscando solución...");
        
        if (buscarSolucion(0, asignacion, usados)) {
            System.out.println("¡Solución encontrada!");
            for (int i = 0; i < LETRAS.length; i++) {
                System.out.println(LETRAS[i] + " = " + asignacion[i]);
            }
        } else {
            System.out.println("No hay solución posible.");
        }
    }

    static boolean buscarSolucion(int indice, int[] asignacion, boolean[] usados) {
        
        
        if (indice == LETRAS.length) {
            return esSumaCorrecta(asignacion);
        }

        
        for (int digito = 0; digito <= 9; digito++) {
            
            if (usados[digito] == false) {
                
                boolean movimientoValido = true;
                if (digito == 0 && (indice == 0 || indice == 4)) {
                    movimientoValido = false;
                }

                if (movimientoValido == true) {
                    
                    asignacion[indice] = digito; 
                    usados[digito] = true;       

                    if (buscarSolucion(indice + 1, asignacion, usados)) {
                        return true; 
                    }

                    usados[digito] = false; 
                }
            }
        }

        return false;
    }

    static boolean esSumaCorrecta(int[] a) {
        int send  = a[0] * 1000  + a[1] * 100  + a[2] * 10  + a[3];
        int more  = a[4] * 1000  + a[5] * 100  + a[6] * 10  + a[1];
        int money = a[4] * 10000 + a[5] * 1000 + a[2] * 100 + a[1] * 10 + a[7];

        return (send + more) == money;
    }
}