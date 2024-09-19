package LAL;

import MODELO.Seccion;

public class ListaEnlazadaSeccion {

    public NodoSeccion cabeza;
    public NodoSeccion ultimonodo;
    public int size;

    public ListaEnlazadaSeccion() {
        cabeza = null;
        size = 0;
    }

    public NodoSeccion getCabeza() {
        return cabeza;
    }

    public boolean estaVacia() {
        return cabeza == null;

    }

    public void vaciarLista() {
        cabeza = null; // Establece la cabeza de la lista como nula para eliminar todos los nodos
        size = 0;      // Restablece el tamaño de la lista a cero
    }

    public void añadirSeccion(Seccion seccion) {
        NodoSeccion nuevoNodo = new NodoSeccion(seccion);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoSeccion puntero = cabeza;
            while (puntero.obtenerSiguiente() != null) {
                puntero = puntero.obtenerSiguiente();
            }
            puntero.enlazarSiguiente(nuevoNodo);
        }
        }
    
}
