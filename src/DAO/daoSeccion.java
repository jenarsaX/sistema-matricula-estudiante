package DAO;

import LAL.Filtros;
import LAL.ListaEnlazadaSeccion;
import LAL.NodoSeccion;
import MODELO.Seccion;
import javax.swing.JComboBox;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.Set;

public class daoSeccion implements Filtros {

    public void rellenarCombo(JComboBox combo, String nombreTablaBD, String columna) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        try {

            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM " + nombreTablaBD);
            resultado = consulta.executeQuery();
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

    public void rellenarComboFiltros(JComboBox combo, String nombreTablaBD, String columna) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM " + nombreTablaBD);
            resultado = consulta.executeQuery();
            Set<Object> valoresUnicos = new HashSet<>();
            while (resultado.next()) {
                valoresUnicos.add(resultado.getObject(columna));
            }
            combo.removeAllItems();
            combo.addItem("");
            for (Object valor : valoresUnicos) {
                combo.addItem(valor);
            }
            conexion.close();
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public DefaultTableModel consultar(JTable tabla) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        DefaultTableModel modelo = null;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM secciones");
            resultado = consulta.executeQuery();
            Object datos[] = new Object[6];
            modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            while (resultado.next()) {
                datos[0] = resultado.getString("idSeccion");
                datos[1] = resultado.getString("grado");
                datos[2] = resultado.getString("division");
                datos[3] = resultado.getString("tutor");
                datos[4] = resultado.getString("aula");
                datos[5] = resultado.getDate("fecha");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            conexion.close();
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return modelo;
    }

    public void actualizar(String tutor, String idSeccion) {
        Connection conexion;
        PreparedStatement consulta;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("UPDATE secciones set tutor=? WHERE idSeccion=?");
            consulta.setString(1, tutor);
            consulta.setString(2, idSeccion);
            consulta.executeUpdate();
            conexion.close();
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void borrar(String idSeccion) {
        Connection conexion;
        PreparedStatement consulta;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("DELETE FROM secciones WHERE idSeccion=?");
            consulta.setString(1, idSeccion);
            consulta.executeUpdate();
            conexion.close();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public void filtroAvanzado(JTable tabla, HashMap<String, String> hashMap) {
        try (Connection conexion = new ConexionSQL().conexion()) {
            if (conexion != null) {
                StringBuilder sql = new StringBuilder("SELECT idSeccion, grado, division, tutor, aula, fecha FROM secciones WHERE");
                for (String key : hashMap.keySet()) {
                    sql.append(" ").append(key).append(" LIKE ? AND");
                }
                sql.delete(sql.length() - 3, sql.length());
                try (PreparedStatement consulta = conexion.prepareStatement(sql.toString())) {
                    int cont = 0;
                    for (String key : hashMap.keySet()) {
                        cont++;
                        consulta.setObject(cont, hashMap.get(key) + "%");
                    }
                    try (ResultSet resultado = consulta.executeQuery()) {
                        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                        modelo.setRowCount(0);
                        while (resultado.next()) {
                            Object datos[] = new Object[6];
                            datos[0] = resultado.getString("idSeccion");
                            datos[1] = resultado.getString("grado");
                            datos[2] = resultado.getString("division");
                            datos[3] = resultado.getString("tutor");
                            datos[4] = resultado.getString("aula");
                            datos[5] = resultado.getDate("fecha");
                            modelo.addRow(datos);
                        }
                        tabla.setModel(modelo);
                    } catch (SQLException e) {
                        System.out.println("ERROR al ejecutar la consulta: " + e.getMessage());
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    System.out.println("ERROR al preparar la consulta: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.out.println("ERROR: La conexión a la base de datos es nula.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR al establecer la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    

    public void registrarSeccionesEnBaseDeDatos(ListaEnlazadaSeccion listaEnlazadaSeccion) {
        Connection conexion;
        PreparedStatement consulta;

        try {
            conexion = new ConexionSQL().conexion();

            for (NodoSeccion nodo = listaEnlazadaSeccion.getCabeza(); nodo != null; nodo = nodo.obtenerSiguiente()) {
                Seccion seccionActual = nodo.obtenerValora2();

                String querySeccion = "INSERT INTO secciones(idSeccion, grado, division, tutor, aula, fecha) VALUES (?, ?, ?, ?, ?, ?)";

                consulta = conexion.prepareStatement(querySeccion);
                consulta.setString(1, seccionActual.getIdSeccion());
                consulta.setString(2, seccionActual.getGrado());
                consulta.setString(3, seccionActual.getDivision());
                consulta.setString(4, seccionActual.getTutor());
                consulta.setString(5, seccionActual.getAula());
                consulta.setDate(6, seccionActual.getFecha());
                consulta.executeUpdate();
                consulta.close();
            }

            // Después de la inserción, vaciar la lista
            listaEnlazadaSeccion.estaVacia();

            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
