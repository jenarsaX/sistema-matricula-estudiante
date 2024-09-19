package LAL;

import MODELO.Alumno;

public class Pilas {

    private NodoAlum tope;

    public Pilas() {
        this.tope = null;
    }

    public void push(Alumno alumno) {
        NodoAlum nuevoNodo = new NodoAlum(alumno);
        nuevoNodo.enlazarSiguiente(tope);
        tope = nuevoNodo;
    }

    public void pop() {
        if (tope != null) {
            tope = tope.obtenerSiguiente();
        } else {
            System.out.println("La pila está vacía.");
        }
    }

    public Alumno peek() {
        if (tope != null) {
            return tope.obtenerValoral();
        } else {
            throw new IllegalStateException("La pila está vacía.");
        }
    }

    public boolean isEmpty() {
        return tope == null;
    }
    
    
    

    // Método para recuperar un dato de la pila
    public Alumno recuperarAlumno(String dni) {
        NodoAlum actual = tope;

        while (actual != null) {
            Alumno alumno = actual.obtenerValoral();

            // Comparar el DNI del alumno con el DNI proporcionado
            if (alumno.getDni().equals(dni)) {
                return alumno; // Devolver el alumno si se encuentra
            }
            actual = actual.obtenerSiguiente();
        }
        return null;
    }
}
