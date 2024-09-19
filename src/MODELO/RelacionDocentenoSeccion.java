

package MODELO;

public class RelacionDocentenoSeccion {
    private final Docente docente;
    private final Seccion seccion;

    public RelacionDocentenoSeccion(Docente docente, Seccion seccion) {
        this.docente = docente;
        this.seccion = seccion;
    }

    public Docente getDocente() {
        return docente;
    }

    public Seccion getSeccion() {
        return seccion;
    }
}
