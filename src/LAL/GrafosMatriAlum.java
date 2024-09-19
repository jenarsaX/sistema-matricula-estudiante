package LAL;

import MODELO.Alumno;
import MODELO.Matricula;

public interface GrafosMatriAlum {

    void insertarAlumno(Alumno alumno);

    void insertarMatricula(Matricula matricula);

    void establecerRelacion(int indiceAlumno, int indiceMatricula);

    void eliminarAlumno(int indiceAlumno);

    void eliminarMatricula(int indiceMatricula);

    boolean existeRelacion(int indiceAlumno, int indiceMatricula);

    boolean esVacio();

    int gradoIn(int indiceMatricula);

    int gradoOut(int indiceAlumno);

    int incidencia(int indice);

    int tamaño();

    boolean esDirigido();

    void ponerMaxNodos(int n);

    void ponerDirigido(boolean d);
}