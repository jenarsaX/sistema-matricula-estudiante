    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAL;
import MODELO.Docente;
/**
 *
 * @author PC
 */
public class NodoDocente {
    private Docente valor;
    private NodoDocente siguiente;
    
    public NodoDocente(Docente valor){
        this.valor=valor;
        this.siguiente=null;
    }

    public Docente obtenerValoradoc() {
        return valor;
    }
    
    public void enlazarSiguiente(NodoDocente n){
        siguiente=n;
    }
    
    public NodoDocente obtenerSiguientedoc() {
        return siguiente;
    }
    
}
