package LAL;

import DAO.ConexionSQL;
import MODELO.Alumno;
import MODELO.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainAs {

    private static void llenarGrafoAlumno(Connection connection, GrafosAs relaciones) throws SQLException {
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

    private static void llenarGrafoSecciones(Connection connection, GrafosAs relaciones) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT idSeccion, tutor, grado, aula, division FROM secciones")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String idSeccion = resultSet.getString("idSeccion");
                    String tutor = resultSet.getString("tutor");
                    String grado = resultSet.getString("grado");
                    String aula = resultSet.getString("aula");
                    String division = resultSet.getString("division");
                    Seccion seccion = new Seccion(idSeccion, tutor, grado, aula, division, null);
                    relaciones.insertarSeccion(seccion);
                }
            }
        }
    }

    public static void main(String[] args) {
        GrafosAs relaciones = new GrafosAs(50, false);

        ConexionSQL conexionSQL = new ConexionSQL();
        try (Connection connection = conexionSQL.conexion()) {
            llenarGrafoAlumno(connection, relaciones);
            llenarGrafoSecciones(connection, relaciones);
            relaciones.establecerRelacion(0, 2);
            relaciones.establecerRelacion(1, 3);
            relaciones.imprimirtabla();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

