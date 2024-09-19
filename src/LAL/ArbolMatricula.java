package LAL;

import MODELO.Seccion;
import javax.swing.JOptionPane;

public class ArbolMatricula {

    NodoArbolMatricula raiz;

    public ArbolMatricula() {
        raiz = null;
    }

    public String realizarMatricula() {
        String resultado = preorden(raiz);
        return resultado;
    }

    private String preorden(NodoArbolMatricula nodo) {
        String cadena = new String();
        String respuesta = "";
        if (nodo != null) {
            if (nodo.derecha != null || nodo.izquierda != null) {
                respuesta = JOptionPane.showInputDialog(nodo.pregunta + "\nIngrese: si / no");
            }
            if ("no".equalsIgnoreCase(respuesta)) {
                cadena = preorden(nodo.derecha);
            } else if ("si".equalsIgnoreCase(respuesta)) {
                cadena = preorden(nodo.izquierda);
            } else {
                cadena = "Proceso de matrícula completado.";
            }
        } else {
            cadena = "";
        }
        return cadena;
    }

    void insertarNodo(boolean pagorealizado, String pregunta) {
        if (raiz == null) {
            raiz = new NodoArbolMatricula(pagorealizado, pregunta);
        } else {
            raiz.insertarElemento(pagorealizado, pregunta);
        }
    }
}
