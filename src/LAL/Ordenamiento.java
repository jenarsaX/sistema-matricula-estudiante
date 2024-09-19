package LAL;

import MODELO.Matricula;

public class Ordenamiento {
/*
    private static Nodo inicio;

    // Métodos de ordenamiento para nodos
    public static Nodo bubbleSort(Nodo inicio) {
        if (inicio == null || inicio.siguiente == null) {
            return inicio;
        }

        boolean intercambio;
        do {
            intercambio = false;
            Nodo actual = inicio;
            Nodo anterior = null;

            while (actual.siguiente != null) {
                if (actual.dato > actual.siguiente.dato) {
                    intercambiarNodos(anterior, actual, actual.siguiente);
                    intercambio = true;
                }

                anterior = actual;
                actual = actual.siguiente;
            }
        } while (intercambio);

        return inicio;
    }

    public static void bubbleSort(Matricula[] matriculas) {
        int n = matriculas.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (matriculas[i].getIdMatricula().compareTo(matriculas[i + 1].getIdMatricula()) > 0) {
                    // Intercambiar las matriculas
                    Matricula temp = matriculas[i];
                    matriculas[i] = matriculas[i + 1];
                    matriculas[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void intercambiarNodos(Nodo anterior, Nodo a, Nodo b) {
        if (anterior != null) {
            anterior.siguiente = b;
        } else {
            inicio = b;
        }

        Nodo tmp = b.siguiente;
        b.siguiente = a;
        a.siguiente = tmp;
    }

    // Métodos de ordenamiento para pilas
    public static void bubbleSort(Pila pila) {
        if (pila.isEmpty() || pila.tope.siguiente == null) {
            return;
        }

        boolean intercambio;
        do {
            intercambio = false;
            Nodo actual = pila.tope;
            Nodo anterior = null;

            while (actual.siguiente != null) {
                if (actual.dato > actual.siguiente.dato) {
                    intercambiarNodos(anterior, actual, actual.siguiente);
                    intercambio = true;
                }

                anterior = actual;
                actual = actual.siguiente;
            }
        } while (intercambio);
    }

// Método de ordenamiento Quick Sort para nodos
    public static void quickSort(Matricula[] matriculas, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(matriculas, low, high);
            quickSort(matriculas, low, pivotIndex - 1);
            quickSort(matriculas, pivotIndex + 1, high);
        }
    }

    private static int partition(Matricula[] matriculas, int low, int high) {
        Matricula pivot = matriculas[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (matriculas[j].getIdMatricula().compareTo(pivot.getIdMatricula()) <= 0) {
                i++;
                Matricula temp = matriculas[i];
                matriculas[i] = matriculas[j];
                matriculas[j] = temp;
            }
        }
        Matricula temp = matriculas[i + 1];
        matriculas[i + 1] = matriculas[high];
        matriculas[high] = temp;
        return i + 1;
    }

    // Método de ordenamiento Merge Sort para nodos
    public static Nodo mergeSort(Nodo inicio) {
        if (inicio == null || inicio.siguiente == null) {
            return inicio;
        }

        Nodo mitad = encontrarMitad(inicio);
        Nodo mitadSiguiente = mitad.siguiente;
        mitad.siguiente = null;

        Nodo izquierda = mergeSort(inicio);
        Nodo derecha = mergeSort(mitadSiguiente);

        return combinarListas(izquierda, derecha);
    }

    private static Nodo encontrarMitad(Nodo inicio) {
        if (inicio == null) {
            return null;
        }

        Nodo rapido = inicio.siguiente;
        Nodo lento = inicio;

        while (rapido != null) {
            rapido = rapido.siguiente;
            if (rapido != null) {
                rapido = rapido.siguiente;
                lento = lento.siguiente;
            }
        }

        return lento;
    }

    private static Nodo combinarListas(Nodo izquierda, Nodo derecha) {
        Nodo resultado = null;

        if (izquierda == null) {
            return derecha;
        }
        if (derecha == null) {
            return izquierda;
        }

        if (izquierda.dato <= derecha.dato) {
            resultado = izquierda;
            resultado.siguiente = combinarListas(izquierda.siguiente, derecha);
        } else {
            resultado = derecha;
            resultado.siguiente = combinarListas(izquierda, derecha.siguiente);
        }

        return resultado;
    }
    */
}
