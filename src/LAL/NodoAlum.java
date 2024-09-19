package LAL;

import MODELO.Alumno;

public class NodoAlum {
    
    private Alumno valor;
    private NodoAlum siguiente;
    
    public NodoAlum(Alumno valor){
        this.valor=valor;
        this.siguiente=null;
    }

    public Alumno obtenerValoral() {
        return valor;
    }
    
    public void enlazarSiguiente(NodoAlum n){
        siguiente=n;
    }
    
    public NodoAlum obtenerSiguiente() {
        return siguiente;
    }
    
    
    
}