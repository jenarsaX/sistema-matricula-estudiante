package MODELO;

import java.sql.Date;

public class Matricula {

    private final int idMatricula;
    private final String alumno;
    private final String seccion;
    private final String pagado;
    private final Date fecha;

    public Matricula(int idMatricula, String alumno, String seccion, String pagado, Date fecha) {
        this.idMatricula = idMatricula;
        this.alumno = alumno;
        this.seccion = seccion;
        this.pagado = pagado;
        this.fecha = fecha;
    }

    public int getIdMatricula() {return idMatricula;}
    public String getAlumno() {return alumno;}
    public String getSeccion() {return seccion;}
    public String getPagado() {return pagado;}
    public Date getFecha() {return fecha;}
    
     public String toString() {
        return "Matrícula [idMatricula=" + idMatricula +
                ", dniAlumno=" + alumno +
                ", idSeccion=" + seccion +
                ", pagado=" + pagado +
                ", fecha=" + fecha +
                "]";
    }
    
}