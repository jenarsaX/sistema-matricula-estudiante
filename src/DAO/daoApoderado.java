package DAO;

import LAL.GrafoAP;
import LAL.ListaEnlazadaApoderado;
import LAL.NodoApoderado;
import MODELO.Apoderado;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class daoApoderado {

    public daoApoderado() {
    }

    public void registrarApoderadosEnBaseDeDatos(ListaEnlazadaApoderado listaEnlazadaApoderado) {
        Connection conexion;
        PreparedStatement consulta;

        try {
            conexion = new ConexionSQL().conexion();

            for (NodoApoderado nodo = listaEnlazadaApoderado.cabeza; nodo != null; nodo = nodo.obtenerSiguienteapo()) {
                Apoderado apoderadoactual = nodo.obtenerValoraapo();

                String queryApoderado = "INSERT INTO padresfamilia(dni, nombre, apellido, telefono) VALUES (?, ?, ?, ?)";

                consulta = conexion.prepareStatement(queryApoderado);
                consulta.setString(1, apoderadoactual.getDni());
                consulta.setString(2, apoderadoactual.getNombre());
                consulta.setString(3, apoderadoactual.getApellido());
                consulta.setString(4, apoderadoactual.getTelefono());
                consulta.executeUpdate();
                consulta.close();
            }

            // Después de la inserción, vaciar la lista
            listaEnlazadaApoderado.vaciarLista();

            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    
    
    public boolean borrarApoderado(String dni, ListaEnlazadaApoderado listaEnlazadaApoderado) {
        Connection conexion;
        PreparedStatement consulta;

        try {
            conexion = new ConexionSQL().conexion();

            String query = "DELETE FROM padresfamilia WHERE dni = ?";
            consulta = conexion.prepareStatement(query);
            consulta.setString(1, dni);
            int filasAfectadas = consulta.executeUpdate();
            consulta.close();

            if (filasAfectadas > 0) {
                // Eliminar el alumno de la lista enlazada
                listaEnlazadaApoderado.borrarApoderado(dni);
                return true;
            } else {
                return false; // No se encontró el elemento con el DNI dado en la base de datos
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public DefaultTableModel consultar(JTable tabla) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        DefaultTableModel modelo = null;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM padresfamilia");
            resultado = consulta.executeQuery();
            Object datos[] = new Object[4];
            modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            while (resultado.next()) {
                datos[0] = resultado.getString("dni");
                datos[1] = resultado.getString("nombre");
                datos[2] = resultado.getString("apellido");
                datos[3] = resultado.getString("telefono");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return modelo;
    }


}
