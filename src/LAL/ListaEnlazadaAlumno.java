package LAL;

import MODELO.Alumno;

public class ListaEnlazadaAlumno {

    public NodoAlum cabeza;
    public NodoAlum ultimonodo;
    public int size;

    public ListaEnlazadaAlumno() {
        cabeza = null;
        size = 0;
    }

    public NodoAlum getCabeza() {
        return cabeza;
    }

    public boolean estaVacia() {
        return cabeza == null;

    }

    public void vaciarLista() {
        cabeza = null; // Establece la cabeza de la lista como nula para eliminar todos los nodos
        size = 0;      // Restablece el tamaño de la lista a cero
    }

    public void añadirAlumno(Alumno alumno) {
        NodoAlum nuevoNodo = new NodoAlum(alumno);

        if (cabeza == null) {
            // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
            cabeza = nuevoNodo;
        } else {
            // Si no está vacía, avanzamos hasta el último nodo y enlazamos el nuevo nodo allí
            NodoAlum puntero = cabeza;
            while (puntero.obtenerSiguiente() != null) {
                puntero = puntero.obtenerSiguiente();
            }
            puntero.enlazarSiguiente(nuevoNodo);
        }
    }

    public Alumno Buscar(String dni) {
        NodoAlum puntero = cabeza;

        while (puntero != null) {
            Alumno alumno = puntero.obtenerValoral();
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
            puntero = puntero.obtenerSiguiente();
        }
        return null;
    }

    public boolean borrarAlumno(String dni) {
        if (cabeza == null) {
            return false; // Lista vacía, no se puede eliminar
        }

        if (cabeza.obtenerValoral().getDni().equals(dni)) {
            cabeza = cabeza.obtenerSiguiente();
            size--;
            return true; // Se eliminó el primer elemento
        }

        NodoAlum punteroAnterior = cabeza;
        NodoAlum punteroActual = cabeza.obtenerSiguiente();

        while (punteroActual != null) {
            Alumno alumno = punteroActual.obtenerValoral();
            if (alumno.getDni().equals(dni)) {
                punteroAnterior.enlazarSiguiente(punteroActual.obtenerSiguiente());
                size--;
                return true; // Se eliminó un elemento
            }

            punteroAnterior = punteroActual;
            punteroActual = punteroActual.obtenerSiguiente();
        }

        return false; // No se encontró el elemento con el código dado
    }

    public Alumno obtenerAlumnoPorDni(String dni) {
        NodoAlum puntero = cabeza;

        while (puntero != null) {
            Alumno alumno = puntero.obtenerValoral();
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
            puntero = puntero.obtenerSiguiente();
        }

        return null; // No se encontró el alumno con el DNI dado
    }

}
