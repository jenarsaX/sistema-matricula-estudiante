package LAL;

import DAO.ConexionSQL;
import LAL.GrafoAP;
import LAL.GrafoAP;
import MODELO.Alumno;
import MODELO.Apoderado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    
    private static void llenarGrafoAlumnos(Connection connection, GrafoAP relaciones) throws SQLException {
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

    private static void llenarGrafoApoderados(Connection connection, GrafoAP relaciones) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT dni, nombre, apellido, telefono FROM padresfamilia")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String dni = resultSet.getString("dni");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String telefono = resultSet.getString("telefono");
                    Apoderado apoderado = new Apoderado(dni, nombre, apellido, telefono);
                    relaciones.insertarApoderado(apoderado);
                }
            }
        }
    }

    public static void main(String[] args) {
        GrafoAP relaciones = new GrafoAP(100, false);

        ConexionSQL conexionSQL = new ConexionSQL();
        try (Connection connection = conexionSQL.conexion()) {
            llenarGrafoAlumnos(connection, relaciones);
            llenarGrafoApoderados(connection, relaciones);
            relaciones.establecerRelacion(0, 2); 
            relaciones.establecerRelacion(1, 3); 
            relaciones.imprimirtabla();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
