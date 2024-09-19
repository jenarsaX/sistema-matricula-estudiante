package LAL;

import LAL.*;
import MODELO.Matricula;

public class HashTableMatricula {

    public int tamaño;
    public NodoMatricula[] tabla;

    public HashTableMatricula(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new NodoMatricula[tamaño];
    }

    public int hash(int codigo) {
        double A = 0.6180339887;
        double k = codigo * A;
        double partedecimal = k - Math.floor(k);
        return (int) (partedecimal * tamaño);
    }

    public Matricula buscar(int codigo) {
        int indice = hash(codigo);
        NodoMatricula nodo = tabla[indice];
        while (nodo != null) {
            if (nodo.obtenerValorma().getIdMatricula() == codigo) {
                return nodo.obtenerValorma();
            }
            nodo = nodo.obtenerSiguiente();
        }
        return null;
    }
    
    
    public void insertar(Matricula matricula){
        int indice = hash(matricula.getIdMatricula());
        NodoMatricula nodo = tabla[indice];
        NodoMatricula nuevoNodo = new NodoMatricula(matricula);
        if(nodo == null){
            tabla[indice] = nuevoNodo;
        }else{
            while (nodo.obtenerSiguiente()!= null){
                nodo = nodo.obtenerSiguiente();
            }
            nodo.enlazarSiguiente(nuevoNodo);
        }
    }
    
    
    

}
