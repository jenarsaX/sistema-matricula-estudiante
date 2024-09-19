package DAO;

import LAL.GrafoAP;
import LAL.NodoAlum;
import MODELO.Alumno;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import LAL.ListaEnlazadaAlumno;
import LAL.Pilas;

public class daoAlumno {

    public void registrarAlumnosEnBaseDeDatos(ListaEnlazadaAlumno listaEnlazadaAlumno) {
        Connection conexion;
        PreparedStatement consulta;

        try {
            conexion = new ConexionSQL().conexion();

            for (NodoAlum nodo = listaEnlazadaAlumno.cabeza; nodo != null; nodo = nodo.obtenerSiguiente()) {
                Alumno alumnoActual = nodo.obtenerValoral();

                String queryAlumno = "INSERT INTO alumnos(codigo, dni, nombre, apellido, apoderado) VALUES (?, ?, ?, ?, ?)";

                consulta = conexion.prepareStatement(queryAlumno);
                consulta.setString(1, alumnoActual.getCodigo());
                consulta.setString(2, alumnoActual.getDni());
                consulta.setString(3, alumnoActual.getNombre());
                consulta.setString(4, alumnoActual.getApellido());
                consulta.setString(5, alumnoActual.getApoderado());
                consulta.executeUpdate();
                consulta.close();
            }

            // Después de la inserción, vaciar la lista
            listaEnlazadaAlumno.vaciarLista();

            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel consultar(JTable tabla) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        DefaultTableModel modelo = null;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM alumnos");
            resultado = consulta.executeQuery();
            Object datos[] = new Object[5];
            modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            while (resultado.next()) {
                datos[0] = resultado.getString("codigo");
                datos[1] = resultado.getString("dni");
                datos[2] = resultado.getString("nombre");
                datos[3] = resultado.getString("apellido");
                datos[4] = resultado.getString("apoderado");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return modelo;
    }

    public Alumno BuscarAlumno(String dni, ListaEnlazadaAlumno listaEnlazadaAlumno) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        Alumno alumnoEncontrado = null;
        try {
            conexion = new ConexionSQL().conexion();
            String query = "SELECT * FROM alumnos WHERE dni = ?";
            consulta = conexion.prepareStatement(query);
            consulta.setString(1, dni);
            resultado = consulta.executeQuery();
            while (resultado.next()) {
                String codigo = resultado.getString("codigo");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String apoderado = resultado.getString("apoderado");

                alumnoEncontrado = new Alumno(codigo, dni, nombre, apellido, apoderado);
            }
            resultado.close();
            consulta.close();
            conexion.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return alumnoEncontrado;
    }

    public boolean borrarAlumno(String dni, ListaEnlazadaAlumno listaEnlazadaAlumno, Pilas historialAlumnosEliminados) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        try {
            conexion = new ConexionSQL().conexion();
            Alumno alumnoEliminado = BuscarAlumno(dni, listaEnlazadaAlumno);
            String query = "DELETE FROM alumnos WHERE dni = ?";
            consulta = conexion.prepareStatement(query);
            consulta.setString(1, dni);
            int filasAfectadas = consulta.executeUpdate();
            consulta.close();
            if (filasAfectadas > 0) {
                historialAlumnosEliminados.push(alumnoEliminado);  // Aquí se agrega a la pila de alumnos eliminados
                listaEnlazadaAlumno.borrarAlumno(dni);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void recuperarAlumnoEliminado(ListaEnlazadaAlumno listaEnlazadaAlumno, Pilas historialAlumnosEliminados) {
        Connection conexion;
        PreparedStatement consultaInsertar;
        try {
            conexion = new ConexionSQL().conexion();
            Alumno alumnoRecuperado = historialAlumnosEliminados.peek();  // Obtener el último alumno eliminado
            if (alumnoRecuperado != null) {
                String query = "INSERT INTO alumnos(codigo, dni, nombre, apellido, apoderado) VALUES (?, ?, ?, ?, ?)";
                consultaInsertar = conexion.prepareStatement(query);
                consultaInsertar.setString(1, alumnoRecuperado.getCodigo());
                consultaInsertar.setString(2, alumnoRecuperado.getDni());
                consultaInsertar.setString(3, alumnoRecuperado.getNombre());
                consultaInsertar.setString(4, alumnoRecuperado.getApellido());
                consultaInsertar.setString(5, alumnoRecuperado.getApoderado());
                consultaInsertar.executeUpdate();
                consultaInsertar.close();
                historialAlumnosEliminados.pop();  // Aquí se elimina el alumno de la pila después de recuperarlo
                listaEnlazadaAlumno.añadirAlumno(alumnoRecuperado);
                conexion.close();
            } else {
                JOptionPane.showMessageDialog(null, "No hay alumnos eliminados en el historial.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificar(String codigo, String apoderado) {
        Connection conexion;
        PreparedStatement consulta;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("UPDATE alumnos set apoderado=? WHERE codigo=?");
            consulta.setString(1, apoderado);
            consulta.setString(2, codigo);
            consulta.executeUpdate();
            conexion.close();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("ERRRO: " + e.getMessage());
        }
    }

    public void rellenarCombo(JComboBox combo, String nombreTablaBD, String columna) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        try {

            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM " + nombreTablaBD);
            resultado = consulta.executeQuery();
            combo.removeAllItems();
            while (resultado.next()) {
                combo.addItem(resultado.getObject(columna));
            }
            conexion.close();
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

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

}
