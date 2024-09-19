package MODELO;

public class RelacionAlumnoApoderado {

    private final Alumno alumno;
    private final Apoderado apoderado;

    public RelacionAlumnoApoderado(Alumno alumno, Apoderado apoderado) {
        this.alumno = alumno;
        this.apoderado = apoderado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }
}
