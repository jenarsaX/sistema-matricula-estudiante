package LAL;

import DAO.ConexionSQL;
import MODELO.Docente;
import MODELO.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MainDC {

    private static void llenarGrafoDocentes(Connection connection, GrafosDC relaciones) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT codigo, dni, nombre, apellido, correo, estado, fecha FROM docentes")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String codigo = resultSet.getString("codigo");
                    String dni = resultSet.getString("dni");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String correo = resultSet.getString("correo");
                    String estado = resultSet.getString("estado");
                    Date fecha = resultSet.getDate("fecha");
                    Docente docente = new Docente(codigo, dni, nombre, apellido, correo, estado, (java.sql.Date) fecha);
                    relaciones.insertarDocente(docente);
                }
            }
        }
    }

    private static void llenarGrafoSecciones(Connection connection, GrafosDC relaciones) throws SQLException {
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
        GrafosDC relaciones = new GrafosDC(50, false);

        ConexionSQL conexionSQL = new ConexionSQL();
        try (Connection connection = conexionSQL.conexion()) {
            llenarGrafoDocentes(connection, relaciones);
            llenarGrafoSecciones(connection, relaciones);
            relaciones.establecerRelacion(0, 2);
            relaciones.establecerRelacion(1, 3);
            relaciones.imprimirtabla();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

