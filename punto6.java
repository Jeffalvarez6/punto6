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