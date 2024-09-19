/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAL;

import java.util.Arrays;

/**
 *
 * @author LAB-USR-LN6377-B0803
 */
public class Grafoss {
   private int maxNodos;
    private int numVertices;
    private MiArrayList<Integer>[] listaAdy;

    public Grafoss(int maxNodos) {
        this.maxNodos = maxNodos;
        this.numVertices = 0;
        this.listaAdy = new MiArrayList[maxNodos];

        for (int i = 0; i < maxNodos; i++) {
            listaAdy[i] = new MiArrayList<>();
        }
    }

    public void agregarArista(int origen, int destino) {
        listaAdy[origen].add(destino);
        listaAdy[destino].add(origen);
    }

    public void imprimirGrafo() {
        System.out.println("Tamaño máximo del grafo: " + maxNodos + "\n");
        System.out.println("El grafo contiene " + numVertices + " vertices: \n");

        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vértice " + i + ": ");
            escribir(listaAdy[i]);
            System.out.println();
        }
    }

    private void escribir(MiArrayList<Integer> adyacencia) {
       
    }

    private static class MiArrayList<T> {
        private static final int CAPACIDAD_INICIAL = 10;
        private Object[] elementos;
        private int tamaño;

        public MiArrayList() {
            this.elementos = new Object[CAPACIDAD_INICIAL];
            this.tamaño = 0;
        }

        public int size() {
            return tamaño;
        }

        public void add(T elemento) {
            if (tamaño == elementos.length) {
                aumentarCapacidad();
            }
            elementos[tamaño++] = elemento;
        }

        public T get(int indice) {
            if (indice < 0 || indice >= tamaño) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }
            return (T) elementos[indice];
        }

        private void aumentarCapacidad() {
            int nuevaCapacidad = elementos.length * 2;
            elementos = Arrays.copyOf(elementos, nuevaCapacidad);
        }

    }
}
