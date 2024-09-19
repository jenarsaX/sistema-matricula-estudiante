/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LAL;

import DAO.ConexionSQL;
import MODELO.Alumno;
import MODELO.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author LAB-USR-LN6377-B0803
 */
public class mainMA {

    private static void llenarGrafoAlumnos(Connection connection, GrafosMA relaciones) throws SQLException {
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

    private static void llenarGrafoMatricula(Connection connection, GrafosMA relaciones) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT idMatricula, dniAlumno, idSeccion, pagado, fecha FROM matricula")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idMatricula = resultSet.getInt("idMatricula");
                    String dniAlumno = resultSet.getString("dniAlumno");
                    String idSeccion = resultSet.getString("idSeccion");
                    String pagado = resultSet.getString("pagado");
                    Date fecha = resultSet.getDate("fecha");
                    Matricula matricula = new Matricula(idMatricula, dniAlumno, idSeccion, pagado, (java.sql.Date) fecha);
                    relaciones.insertarMatricula(matricula);
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GrafosMA relaciones = new GrafosMA(20, false);

        ConexionSQL conexionSQL = new ConexionSQL();
        try (Connection connection = conexionSQL.conexion()) {
            llenarGrafoAlumnos(connection, relaciones);
            llenarGrafoMatricula(connection, relaciones);
            relaciones.establecerRelacion(0, 2);
            relaciones.establecerRelacion(1, 3);
            relaciones.imprimirtabla();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
