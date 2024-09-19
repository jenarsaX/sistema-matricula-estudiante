package DAO;

import COMPONET.Tabla;
import LAL.HashTableMatricula;
import LAL.NodoMatricula;
import MODELO.Matricula;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class daoMatricula implements DaoProceso {

    public void registrar(Matricula m) {
        Connection conexion;
        PreparedStatement consulta;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("INSERT INTO matricula(idMatricula,dniAlumno,idSeccion,pagado,fecha) VALUES (?,?,?,?,?)");
            consulta.setInt(1, m.getIdMatricula());
            consulta.setString(2, m.getAlumno());
            consulta.setString(3, m.getSeccion());
            consulta.setString(4, m.getPagado());
            consulta.setDate(5, m.getFecha());
            consulta.executeUpdate();
            conexion.close();
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "Error" + JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llenarHashTableBD(JTable tablaMatricula, HashTableMatricula tablaMatricula0) {
        ConexionSQL conexionSQL = new ConexionSQL();
        try (Connection connection = conexionSQL.conexion(); Statement statement = connection.createStatement()) {
            String consultaSQL = "SELECT * FROM matricula";
            try (ResultSet resultados = statement.executeQuery(consultaSQL)) {
                DefaultTableModel modelo = (DefaultTableModel) tablaMatricula.getModel();
                modelo.setRowCount(0);
                Object datos[] = new Object[5];
                while (resultados.next()) {
                    datos[0] = resultados.getInt("idMatricula");
                    datos[1] = resultados.getString("dniAlumno");
                    datos[2] = resultados.getString("idSeccion");
                    datos[3] = resultados.getString("pagado");
                    datos[4] = resultados.getDate("fecha");
                    modelo.addRow(datos);
                    int idMatricula = resultados.getInt("idMatricula");
                    String dniAlumno = resultados.getString("dniAlumno");
                    String idSeccion = resultados.getString("idSeccion");
                    String pagado = resultados.getString("pagado");
                    Date fecha = resultados.getDate("fecha");
                    Matricula matricula = new Matricula(idMatricula, dniAlumno, idSeccion, pagado, fecha);
                    tablaMatricula0.insertar(matricula); 
                }
                tablaMatricula.setModel(modelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DefaultTableModel mostrarMatriculas(JTable tabla, HashTableMatricula tablaMatricula) {
        String[] columnas = {"idMatricula", "Alumno", "Seccion", "Pagado", "fecha"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        if (tablaMatricula != null) {
            for (int i = 0; i < tablaMatricula.tamaño; i++) {
                NodoMatricula nodo = tablaMatricula.tabla[i];
                while (nodo != null) {
                    Matricula matricula = nodo.obtenerValorma();
                    modelo.addRow(new Object[]{matricula.getIdMatricula(), matricula.getAlumno(), matricula.getSeccion(), matricula.getPagado(), matricula.getFecha()});
                    nodo = nodo.obtenerSiguiente();
                }
            }
        } else {
            System.out.println("tablaMatricula is null");
        }

        tabla.setModel(modelo);
        return modelo;
    }

    public Object getConsultarDato(String tablaBD, String id, String columnaID, String nombreColumnaRetornar) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        Object valor = null;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM " + tablaBD + " WHERE " + columnaID + "=?");
            consulta.setString(1, id);
            resultado = consulta.executeQuery();
            if (resultado.next()) {
                valor = resultado.getObject(nombreColumnaRetornar);
            }
            conexion.close();
            consulta.close();
            resultado.close();
        } catch (SQLException e) {
//            System.out.println("ERROR: " + e.getMessage());
        }
        return valor;
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

    @Override
    public Object getConsultarDato(String codigo, String nombreColumnaBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int valorActualID() {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet res;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT MAX(idMatricula) FROM matricula;");
            res = consulta.executeQuery();
            if (res.next()) {
                int maxID = res.getInt(1);
                return maxID + 1; // Devuelve el próximo valor para usar como nuevo ID
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return 1; // Valor por defecto si hay algún problema o la tabla está vacía
    }

    public boolean alumnoExiste(String codigoAlumno) {
        Connection conexion;
        PreparedStatement consulta;
        ResultSet resultado;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM matricula WHERE dniAlumno=?");
            consulta.setString(1, codigoAlumno);
            resultado = consulta.executeQuery();
            if (!resultado.next()) {
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    public void modificar(String idMatricula, String idSeccion, String pagado, Date fecha) {
        Connection conexion;
        PreparedStatement consulta;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("UPDATE matricula set idSeccion=?, pagado=?, fecha=? WHERE idMatricula=?");
            consulta.setString(1, idSeccion);
            consulta.setString(2, pagado);
            consulta.setDate(3, fecha);
            consulta.setString(4, idMatricula);
            consulta.executeUpdate();
            conexion.close();
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "Error" + JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(String idMatricula) {
        Connection conexion;
        PreparedStatement consulta;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("DELETE FROM matricula WHERE idMatricula=?");
            consulta.setString(1, idMatricula);
            consulta.executeUpdate();
            conexion.close();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("ERRRO: " + e.getMessage());
        }
    }

}
