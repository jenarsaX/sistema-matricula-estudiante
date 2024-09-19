
package LAL;
import MODELO.Apoderado;

public class ListaEnlazadaApoderado {
    
    public NodoApoderado cabeza;
    public NodoApoderado ultimonodo;
    public int size;
    
    public ListaEnlazadaApoderado(){
        cabeza=null;
        size=0;
    }
    
    public NodoApoderado getCabeza() {
        return cabeza;
    }

    
    public boolean estaVacia() {
    return cabeza == null;

    
}
    
    public void vaciarLista() {
    cabeza = null; // Establece la cabeza de la lista como nula para eliminar todos los nodos
    size = 0;      // Restablece el tamaño de la lista a cero
}
    
    public void añadirApoderado(Apoderado apoderado) {
    NodoApoderado nuevoNodo = new NodoApoderado(apoderado);

    if (cabeza == null) {
        // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
        cabeza = nuevoNodo;
    } else {
        // Si no está vacía, avanzamos hasta el último nodo y enlazamos el nuevo nodo allí
        NodoApoderado puntero = cabeza;
        while (puntero.obtenerSiguienteapo() != null) {
            puntero = puntero.obtenerSiguienteapo();
        }
        puntero.enlazarSiguienteapo(nuevoNodo);
    }
}


    public Apoderado BuscarApoderado(String dni) { // Cambiar el tipo de parámetro a String
        NodoApoderado puntero = cabeza;

        while (puntero != null) {
            Apoderado apoderado = puntero.obtenerValoraapo();
            if (apoderado.getDni().equals(dni)) { // Cambiar la comparación
                return apoderado;
            }
            puntero = puntero.obtenerSiguienteapo();
        }
        return null;
    }

    public boolean borrarApoderado(String dni) {
        if (cabeza == null) {
            return false; // Lista vacía, no se puede eliminar
        }

        if (cabeza.obtenerValoraapo().getDni().equals(dni)) {
            cabeza = cabeza.obtenerSiguienteapo();
            size--;
            return true; // Se eliminó el primer elemento
        }

        NodoApoderado punteroAnterior = cabeza;
        NodoApoderado punteroActual = cabeza.obtenerSiguienteapo();

        while (punteroActual != null) {
            Apoderado apoderado = punteroActual.obtenerValoraapo();
            if (apoderado.getDni().equals(dni)) {
                punteroAnterior.enlazarSiguienteapo(punteroActual.obtenerSiguienteapo());
                size--;
                return true; // Se eliminó un elemento
            }

            punteroAnterior = punteroActual;
            punteroActual = punteroActual.obtenerSiguienteapo();
        }

        return false; // No se encontró el elemento con el código dado
    }
    
}
