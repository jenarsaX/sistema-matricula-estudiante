
package LAL;

import MODELO.Alumno;
import MODELO.Seccion;


public interface GrafosAlumSec {
     void insertarAlumno(Alumno alumno);

    void insertarSeccion(Seccion seccion);

    void establecerRelacion(int indiceAlumno, int indiceSeccion);

    void eliminarAlumno(int indiceAlumno);

    void eliminarSeccion(int indiceSeccion);

    boolean existeRelacion(int indiceAlumno, int indiceSeccion);

    boolean esVacio();

    int gradoIn(int indiceSeccion);

    int gradoOut(int indiceAlumno);

    int incidencia(int indice);

    int tamaño();

    boolean esDirigido();

    void ponerMaxNodos(int n);

    void ponerDirigido(boolean d);
}
