package LAL;

import MODELO.Seccion;

public class NodoSeccion {
    
    private Seccion valor;
    private NodoSeccion siguiente;
    
    public NodoSeccion(Seccion valor){
        this.valor=valor;
        this.siguiente=null;
    }

    public Seccion obtenerValora2() {
        return valor;
    }
    
    public void enlazarSiguiente(NodoSeccion s){
        siguiente=s;
    }
    
    public NodoSeccion obtenerSiguiente() {
        return siguiente;
    }

    
    
    
}