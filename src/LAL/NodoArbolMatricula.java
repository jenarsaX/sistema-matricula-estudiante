package LAL;

public class NodoArbolMatricula {

    private boolean pagoRealizado; // Cambié el autor por la variable booleana para representar si se ha realizado el pago
    String pregunta;
    NodoArbolMatricula izquierda = null;
    NodoArbolMatricula derecha = null;

    public NodoArbolMatricula(boolean pagoRealizado, String pregunta) {
        this.pagoRealizado = pagoRealizado;
        this.pregunta = pregunta;
        izquierda = null;
        derecha = null;
    }

    public void insertarElemento(boolean nuevoPagoRealizado, String nuevaPregunta) {
        if (!nuevoPagoRealizado) {
            if (izquierda == null) {
                izquierda = new NodoArbolMatricula(nuevoPagoRealizado, nuevaPregunta);
            } else {
                izquierda.insertarElemento(nuevoPagoRealizado, nuevaPregunta);
            }
        } else {
            if (derecha == null) {
                derecha = new NodoArbolMatricula(nuevoPagoRealizado, nuevaPregunta);
            } else {
                derecha.insertarElemento(nuevoPagoRealizado, nuevaPregunta);
            }
        }
    }

    public boolean decidirMatricula(boolean pagoRealizado) {
        if (!pagoRealizado) {
            if (izquierda != null) {
                return izquierda.decidirMatricula(pagoRealizado);
            }
        } else {
            if (derecha != null) {
                return derecha.decidirMatricula(pagoRealizado);
            }
        }
        return true;
    }
}
