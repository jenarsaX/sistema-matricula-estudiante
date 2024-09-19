package DAO;

import MODELO.Docente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class daoDocente{

    public daoDocente() {

    }

    public void registrar(Docente docente) {
        try {
            Connection conexion;
            PreparedStatement consulta;
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("INSERT INTO docentes (codigo,dni,nombre,apellido,correo,estado,fecha) VALUES (?,?,?,?,?,?,?)");
            consulta.setString(1, docente.getCodigo());
            consulta.setString(2, docente.getDni());
            consulta.setString(3, docente.getNombre());
            consulta.setString(4, docente.getApellido());
            consulta.setString(5, docente.getCorreo());
            consulta.setString(6, docente.getEstado());
            consulta.setDate(7, docente.getFecha());
            consulta.executeUpdate();
            conexion.close();
            consulta.close();
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
            consulta = conexion.prepareStatement("SELECT * FROM docentes");
            resultado = consulta.executeQuery();
            Object datos[] = new Object[6];
            modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            int i = 0;
            while (resultado.next()) {
                i++;
                datos[0] = i;
                datos[1] = resultado.getString("codigo");
                datos[2] = resultado.getString("dni");
                datos[3] = resultado.getString("correo");
                datos[4] = resultado.getString("estado");
                datos[5] = resultado.getDate("fecha");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            conexion.close();
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("ERRROR: " + e.getMessage());
        }
        return modelo;
    }

    public Object getConsultarDato(String codigo, String nombreColumnaBD) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;

        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM docentes WHERE codigo=?");
            consulta.setString(1, codigo);
            resultado = consulta.executeQuery();
            if (resultado.next()) {
                return resultado.getString(nombreColumnaBD);
            }
            conexion.close();
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return null;
    }
    
    
    public List<Docente> obtenerListaDocentes() {
        List<Docente> listaDocentes = new ArrayList<>();

        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;

        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM docentes");
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                String codigo = resultado.getString("codigo");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String correo = resultado.getString("correo");
                String estado = resultado.getString("estado");
                Date fecha = resultado.getDate("fecha");

                Docente docente = new Docente(codigo, dni, nombre, apellido, correo, estado, fecha);
                listaDocentes.add(docente);
            }

            conexion.close();
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return listaDocentes;
    }



    public void editar(String codigo, String correo, String estado, Date fecha) {
        Connection conexion;
        PreparedStatement consulta;

        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("UPDATE docentes set correo=?, estado=?, fecha=? WHERE codigo=?");
            consulta.setString(1, correo);
            consulta.setString(2, estado);
            consulta.setDate(3, fecha);
            consulta.setString(4, codigo);
            consulta.executeUpdate();
            conexion.close();
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void eliminar(String codigo) {
        Connection conexion;
        PreparedStatement consulta;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("DELETE FROM docentes WHERE codigo=?");
            consulta.setString(1, codigo);
            consulta.executeUpdate();
            conexion.close();
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
