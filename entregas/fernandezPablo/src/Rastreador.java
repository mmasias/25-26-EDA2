public class Rastreador {
    private boolean activo = false;
    private int nivel = 0;

    public void activar() {
        this.activo = true;
    }

    public void profundizar() {
        nivel++;
    }

    public void retroceder() {
        if (nivel > 0) {
            nivel--;
        }
    }

    public void log(String mensaje) {
        if (!activo) return;
        
        StringBuilder margen = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            margen.append("  ");
        }
        System.out.println(margen.toString() + "-> " + mensaje);
    }
}