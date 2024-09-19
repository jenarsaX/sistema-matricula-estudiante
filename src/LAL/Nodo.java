package LAL;

import MODELO.Docente;

public class Nodo {

    int dato;
    Nodo siguiente;
    Docente docente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    public Nodo(Docente dato){
        
    }
    
}


