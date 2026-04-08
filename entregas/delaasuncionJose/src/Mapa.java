public class Mapa {
    private Nodo raiz;

    public void add(char c, int n) {
        if (raiz == null) {
            raiz = new Nodo(c, n);
            return;
        }

        Nodo nodoActual = raiz;
        while (nodoActual != null) {
            if (nodoActual.c == c) {
                nodoActual.n = n;
                return;
            }

            if (nodoActual.siguiente == null) {
                nodoActual.siguiente = new Nodo(c, n);
                return;
            }
            nodoActual = nodoActual.siguiente;
        }
    }

    public int find(char c) {
        Nodo nodoActual = raiz;
        while (nodoActual != null) {
            if (nodoActual.c == c) return nodoActual.n;
            nodoActual = nodoActual.siguiente;
        }
        return -1;
    }

    public void remove(char c) {
        if (raiz == null) return;

        if (raiz.c == c) {
            raiz = raiz.siguiente;
            return;
        }

        Nodo nodoActual = raiz;
        while (nodoActual.siguiente != null) {
            if (nodoActual.siguiente.c == c) {
                nodoActual.siguiente = nodoActual.siguiente.siguiente;
                return;
            }
            nodoActual = nodoActual.siguiente;
        }
    }
}