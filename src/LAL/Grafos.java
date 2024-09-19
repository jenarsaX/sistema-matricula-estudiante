package LAL;

import java.util.HashMap;
import java.util.Map;

public class Grafos {
    private Map<String, Nodo> nodos;

    public Grafos() {
        this.nodos = new HashMap<>();
    }

    public void agregarNodo(String id) {
        nodos.put(id, new Nodo(id));
    }

    public void agregarRelacionAlumnoSeccion(String idAlumno, String idSeccion) {
        nodos.get(idAlumno).agregarVecino(nodos.get(idSeccion));
    }

    public void agregarRelacionDocenteSeccion(String idDocente, String idSeccion) {
        nodos.get(idDocente).agregarVecino(nodos.get(idSeccion));
    }

    public void imprimirMatrizAdyacencia() {
        int numNodos = nodos.size();
        int[][] matrizAdyacencia = new int[numNodos][numNodos];

        for (Nodo nodo : nodos.values()) {
            int indiceFila = Integer.parseInt(nodo.getId().substring(1)) - 1;

            for (Nodo vecino : nodo.getVecinos()) {
                int indiceColumna = Integer.parseInt(vecino.getId().substring(1)) - 1;
                matrizAdyacencia[indiceFila][indiceColumna] = 1;
            }
        }

        // Imprimir la matriz de adyacencia
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class Nodo {
        private String id;
        private Map<String, Nodo> vecinos;

        public Nodo(String id) {
            this.id = id;
            this.vecinos = new HashMap<>();
        }

        public String getId() {
            return id;
        }

        public void agregarVecino(Nodo vecino) {
            vecinos.put(vecino.getId(), vecino);
        }

        public Iterable<Nodo> getVecinos() {
            return vecinos.values();
        }
    }
}
