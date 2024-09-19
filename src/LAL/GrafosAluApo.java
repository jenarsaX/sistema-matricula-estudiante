package LAL;

import MODELO.Alumno;
import MODELO.Apoderado;

public interface GrafosAluApo {

    void insertarAlumno(Alumno alumno);

    void insertarApoderado(Apoderado apoderado);

    void establecerRelacion(int indiceAlumno, int indiceApoderado);

    void eliminarAlumno(int indiceAlumno);

    void eliminarApoderado(int indiceApoderado);

    boolean existeRelacion(int indiceAlumno, int indiceApoderado);

    boolean esVacio();

    int gradoIn(int indiceApoderado);

    int gradoOut(int indiceAlumno);

    int incidencia(int indice);

    int tamaño();

    boolean esDirigido();

    void ponerMaxNodos(int n);

    void ponerDirigido(boolean d);
}
