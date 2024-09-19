
package LAL;

import MODELO.Docente;
import MODELO.Seccion;


public interface GrafosDocSec {
     void insertarDocente(Docente docente);

    void insertarSeccion(Seccion docente);

    void establecerRelacion(int indiceDocente, int indiceSeccion);

    void eliminarDocente(int indiceDocente);

    void eliminarSeccion(int indiceSeccion);

    boolean existeRelacion(int indiceDocente, int indiceSeccion);

    boolean esVacio();

    int gradoIn(int indiceDocente);

    int gradoOut(int indiceDocente);

    int incidencia(int indice);

    int tamaño();

    boolean esDirigido();

    void ponerMaxNodos(int n);

    void ponerDirigido(boolean d);
}
