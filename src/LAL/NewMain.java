package LAL;

import DAO.ConexionSQL;
import LAL.GrafosAs;
import MODELO.Alumno;
import MODELO.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class NewMain {
    
    private static void llenarGrafoAlumnos(Connection connection, GrafosAs relaciones) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT codigo, dni, nombre, apellido, apoderado FROM alumnos")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String codigo = resultSet.getString("codigo");
                    String dni = resultSet.getString("dni");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String apoderado = resultSet.getString("apoderado");
                    Alumno alumno = new Alumno(codigo, dni, nombre, apellido, apoderado);
                    relaciones.insertarAlumno(alumno);
                }
            }
        }
    }
    

    private static void llenarGrafoSeccion(Connection connection, GrafosAs relaciones) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT idSeccion, grado, division, tutor, aula, fecha FROM secciones")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String idSeccion = resultSet.getString("idSeccion");
                    String grado = resultSet.getString("grado");
                    String division = resultSet.getString("division");
                    String tutor = resultSet.getString("tutor");
                    String aula = resultSet.getString("aula");
                    Date fecha = resultSet.getDate("fecha");

                    Seccion seccion = new Seccion(idSeccion, grado, division, tutor, aula, (java.sql.Date) fecha);
                    relaciones.insertarSeccion(seccion);
                }
            }
        }
    }

    public static void main(String[] args) {
        GrafosAs relaciones = new GrafosAs(20, false); // Cambié GrafoAP a GrafosAs

        ConexionSQL conexionSQL = new ConexionSQL();
        try (Connection connection = conexionSQL.conexion()) {
            llenarGrafoAlumnos(connection, relaciones);
            llenarGrafoSeccion(connection, relaciones); // Agregué la función para llenar secciones
            relaciones.establecerRelacion(0, 2);
            relaciones.establecerRelacion(1, 3);
            relaciones.imprimirtabla();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}