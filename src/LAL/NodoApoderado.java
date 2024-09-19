package LAL;
import MODELO.Apoderado;

public class NodoApoderado {
    
    private Apoderado valor;
    private NodoApoderado siguiente;
    
    public NodoApoderado(Apoderado valorapo){
        this.valor=valorapo;
        this.siguiente=null;
    }

    public Apoderado obtenerValoraapo() {
        return valor;
    }
    
    public void enlazarSiguienteapo(NodoApoderado n){
        siguiente=n;
    }
    
    public NodoApoderado obtenerSiguienteapo() {
        return siguiente;
    }
}
