package LAL;

import MODELO.Docente;

public class Pila {

    Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public void push(Docente docente) {
        Nodo nuevoNodo = new Nodo(docente);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public void pop() {
        if (tope != null) {         
            tope = tope.siguiente;
        } else {
            System.out.println("    La pila está vacía.");
        }
    }

    public Docente peek() {
        if (tope != null) {
            return tope.docente;
        } else {
            throw new IllegalStateException("La pila está vacía.");
        }
    }

    public boolean isEmpty() {
        return tope == null;
    }

}
