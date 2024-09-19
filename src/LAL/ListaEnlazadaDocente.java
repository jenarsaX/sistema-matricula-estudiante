/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAL;

import MODELO.Docente;

public class ListaEnlazadaDocente {
    public NodoDocente cabeza;
    public NodoDocente ultimonodo;
    public int size;
    
    public ListaEnlazadaDocente(){
        cabeza=null;
        size=0;
    }
    
    public NodoDocente getCabeza() {
        return cabeza;
    }

    
    public boolean estaVacia() {
    return cabeza == null;

    
}
    
    public void vaciarLista() {
    cabeza = null; // Establece la cabeza de la lista como nula para eliminar todos los nodos
    size = 0;      // Restablece el tamaño de la lista a cero
}
    
    public void añadirDocente(Docente docente) {
    NodoDocente nuevoNodo = new NodoDocente(docente);

    if (cabeza == null) {
        // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
        cabeza = nuevoNodo;
    } else {
        // Si no está vacía, avanzamos hasta el último nodo y enlazamos el nuevo nodo allí
        NodoDocente puntero = cabeza;
        while (puntero.obtenerSiguientedoc() != null) {
            puntero = puntero.obtenerSiguientedoc();
        }
        puntero.enlazarSiguiente(nuevoNodo);
    }
}


    public Docente Buscar(String dni) { // Cambiar el tipo de parámetro a String
        NodoDocente puntero = cabeza;

        while (puntero != null) {
            Docente docente = puntero.obtenerValoradoc();
            if (docente.getDni().equals(dni)) { // Cambiar la comparación
                return docente;
            }
            puntero = puntero.obtenerSiguientedoc();
        }
        return null;
    }

    public boolean borrarDocente(String dni) {
        if (cabeza == null) {
            return false; // Lista vacía, no se puede eliminar
        }

        if (cabeza.obtenerValoradoc().getDni().equals(dni)) {
            cabeza = cabeza.obtenerSiguientedoc();
            size--;
            return true; // Se eliminó el primer elemento
        }

        NodoDocente punteroAnterior = cabeza;
        NodoDocente punteroActual = cabeza.obtenerSiguientedoc();

        while (punteroActual != null) {
            Docente docente = punteroActual.obtenerValoradoc();
            if (docente.getDni().equals(dni)) {
                punteroAnterior.enlazarSiguiente(punteroActual.obtenerSiguientedoc());
                size--;
                return true; // Se eliminó un elemento
            }

            punteroAnterior = punteroActual;
            punteroActual = punteroActual.obtenerSiguientedoc();
        }

        return false; // No se encontró el elemento con el código dado
    }
  
}