

package LAL;

import MODELO.Matricula;

public class NodoMatricula {
    
    private Matricula valor;
    private NodoMatricula siguiente;
    
    public NodoMatricula (Matricula  valor){
        this.valor=valor;
        this.siguiente=null;
    }

    public Matricula  obtenerValorma() {
        return valor;
    }
    
    public void enlazarSiguiente(NodoMatricula n){
        siguiente=n;
    }
    
    public NodoMatricula  obtenerSiguiente() {
        return siguiente;
    }
}
