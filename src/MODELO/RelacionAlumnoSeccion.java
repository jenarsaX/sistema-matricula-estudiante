

package MODELO;

public class RelacionAlumnoSeccion {
    private final Alumno alumno;
    private final Seccion seccion;

    public RelacionAlumnoSeccion(Alumno alumno, Seccion seccion) {
        this.alumno = alumno;
        this.seccion = seccion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Seccion getSeccion() {
        return seccion;
    }
}
