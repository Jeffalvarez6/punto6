import java.util.Iterator;

public class Deque extends Cola {

    // Agregar elemento al inicio[cite: 102]
    public void agregarPrimero(Object elem) {
        Nodo nuevo = new Nodo(elem);
        if (estaVacia()) {
            inicio = fin = nuevo;
        } else {
            nuevo.sgte = inicio;
            inicio = nuevo;
        }
        nDatos++;
    }

    // Eliminar el último elemento[cite: 102]
    public void eliminarUltimo() {
        if (estaVacia()) return;

        if (inicio == fin) {
            inicio = fin = null;
        } else {
            Nodo aux = inicio;
            while (aux.sgte != fin) {
                aux = aux.sgte;
            }
            aux.sgte = null;
            fin = aux;
        }
        nDatos--;
    }
    // Obtener el último elemento sin eliminarlo[cite: 102]
    public Object ultimoElemento() {
        if (estaVacia()) return null;
        return fin.elemento;
    }

    // Iterador desde el final hasta el inicio[cite: 102]
    public Iterator iteradorEnReversa() {
        return new Iterator() {
            private int posActual = nDatos;

            @Override
            public boolean hasNext() {
                return posActual > 0;
            }

            @Override
            public Object next() {
                if (!hasNext()) return null;
                Nodo aux = inicio;
                for (int i = 0; i < posActual - 1; i++) {
                    aux = aux.sgte;
                }
                posActual--;
                return aux.elemento;
            }
        };
    }
}