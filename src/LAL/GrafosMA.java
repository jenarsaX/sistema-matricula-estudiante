/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAL;

import MODELO.Alumno;
import MODELO.Matricula;


public class GrafosMA implements GrafosMatriAlum {
     private boolean dirigido;
    private int maxNodos;
    private int numVertices;
    private boolean matrizAdy[][];
    private Object[] nodos;

    public GrafosMA(int n, boolean d) {
        dirigido = d;
        maxNodos = n;
        numVertices = 0;
        matrizAdy = new boolean[n][n];
    }

    public Object obtenerNodo(int indice) {
        if (indice >= 0 && indice < nodos.length) {
            return nodos[indice];
        }
        return null;
    }
    @Override
    public void insertarAlumno(Alumno alumno) {
        int indiceExistente = buscarAlumno(alumno);
        if (indiceExistente == -1) {
            if (numVertices < maxNodos) {
                matrizAdy[numVertices][numVertices] = false; 
                numVertices++;
            } else {
                System.out.println("Error, se supera el número de nodos máximos");
            }
        } else {
            System.out.println("El alumno ya existe en el grafo");
        }
       }

@Override
    public void insertarMatricula(Matricula matricula) {
        int indiceExistente = buscarMatricula(matricula);
        if (indiceExistente == -1) {
            if (numVertices < maxNodos) {
                matrizAdy[numVertices][numVertices] = false; 
                numVertices++;
            } else {
                System.out.println("Error, se supera el número de nodos máximos");
            }
        } else {
            System.out.println("El alumno ya existe en el grafo");
        }
    }

    private int buscarAlumno(Alumno alumno) {
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdy[i][i] && alumno.getCodigo().equals(Integer.toString(i))) {
                return i; 
            }
        }
        return -1; 
    }

    

    private int buscarMatricula(Matricula matricula) {
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdy[i][i] && matricula.getIdMatricula() == i) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void establecerRelacion(int indiceAlumno, int indiceMatricula) {
        matrizAdy[indiceAlumno][indiceMatricula] = true;
        if (!dirigido) {
            matrizAdy[indiceMatricula][indiceAlumno] = true;
        }
    }

    @Override
    public void eliminarAlumno(int indiceAlumno) {
        if (indiceAlumno >= 0 && indiceAlumno < numVertices) {
            for (int i = indiceAlumno; i < numVertices - 1; i++) {
                for (int j = 0; j < numVertices; j++) {
                    matrizAdy[i][j] = matrizAdy[i + 1][j];
                }
            }
            for (int j = indiceAlumno; j < numVertices - 1; j++) {
                for (int i = 0; i < numVertices; i++) {
                    matrizAdy[i][j] = matrizAdy[i][j + 1];
                }
            }
            numVertices--;
        } else {
            System.out.println("Error, índice de alumno fuera de rango");
        }
    }

    @Override
    public void eliminarMatricula(int indiceMatricula) {
        if (indiceMatricula >= 0 && indiceMatricula < numVertices) {
            for (int i = indiceMatricula; i < numVertices - 1; i++) {
                for (int j = 0; j < numVertices; j++) {
                    matrizAdy[i][j] = matrizAdy[i + 1][j];
                }
            }
            for (int j = indiceMatricula; j < numVertices - 1; j++) {
                for (int i = 0; i < numVertices; i++) {
                    matrizAdy[i][j] = matrizAdy[i][j + 1];
                }
            }
            numVertices--;
        } else {
            System.out.println("Error, índice de apoderado fuera de rango");
        }
    }

    @Override
    public boolean existeRelacion(int indiceAlumno, int indiceMatricula) {
        if (indiceAlumno < 0 || indiceMatricula < 0 || indiceAlumno >= numVertices || indiceMatricula >= numVertices) {
            return false;
        }

        return matrizAdy[indiceAlumno][indiceMatricula];
    }

    @Override
    public boolean esVacio() {
        return numVertices == 0;
    }

    @Override
    public int gradoIn(int indiceApoderado) {
        int gIn = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdy[i][indiceApoderado]) {
                gIn++;
            }
        }
        return gIn;
    }

    @Override
    public int gradoOut(int indiceAlumno) {
        int gOut = 0;
        for (int j = 0; j < numVertices; j++) {
            if (matrizAdy[indiceAlumno][j]) {
                gOut++;
            }
        }
        return gOut;
    }

    @Override
    public int incidencia(int indice) {
        if (!dirigido) {
            return gradoIn(indice);
        } else {
            return gradoIn(indice) + gradoOut(indice);
        }
    }

    @Override
    public int tamaño() {
        int tm = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy[i][j]) {
                    tm++;
                }
            }
        }
        if (dirigido) {
            return tm;
        } else {
            return tm / 2;
        }
    }

    @Override
    public boolean esDirigido() {
        boolean dir = true;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy[i][j] != matrizAdy[j][i]) {
                    dir = false;
                }
            }
        }
        return dir;
    }

    @Override
    public void ponerMaxNodos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ponerDirigido(boolean d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void imprimirtabla() {
        System.out.println("La matriz contiene " + numVertices + " vertices:\n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy[i][j]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();  
        }
    }
}

