package CONTROLADOR;

import COMPONET.Tabla;
import DAO.daoMatricula;
import LAL.ArbolMatricula;
import LAL.HashTableMatricula;
import MODELO.Matricula;
import MODELO.Proceso;
import VISTA.moduloMatricula;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorMatricula {

    private HashTableMatricula tablaMatricula = new HashTableMatricula(100);

    public ControladorMatricula(HashTableMatricula tablaMatricula) {
        this.tablaMatricula = tablaMatricula;
    }

    moduloMatricula m;
    daoMatricula dao;

    public ControladorMatricula(moduloMatricula m) {
        this.m = m;
        dao = new daoMatricula();
    }

    public void initDiseño() {
        limpiar();
    }

    public void limpiar() {
        consultar();
        filaSeleccionada = -1;
        m.txtMatricula.setText("MATRICULA #" + getIdActual());
        m.comboAlumno.setEnabled(true);
        m.comboPagado.setSelectedIndex(0);
        m.tablaMatricula.clearSelection();

    }

    private int getIdActual() {
        return dao.valorActualID();
    }

    public void consultar() {
        llenarHashTableBD();
        m.tablaMatricula.clearSelection();
        dao.rellenarCombo(m.comboAlumno, "alumnos", "codigo");
        dao.rellenarCombo(m.comboSeccion, "secciones", "idSeccion");
    }

    public void llenarHashTableBD() {
        dao.llenarHashTableBD(m.tablaMatricula, tablaMatricula);
    }

    public void setAlumno(String codigoAlumno) {
        try {
            String nombre = dao.getConsultarDato("alumnos", codigoAlumno, "codigo", "nombre").toString();
            String apellido = dao.getConsultarDato("alumnos", codigoAlumno, "codigo", "apellido").toString();
            String alumno = nombre + " " + apellido;
            m.txtAlumno.setText(alumno);
            setApoderado(codigoAlumno);
        } catch (NullPointerException e) {
        }
    }

    private void setApoderado(String codigoAlumno) {
        try {
            String codigoApoderado = dao.getConsultarDato("alumnos", codigoAlumno, "codigo", "apoderado").toString();
            String nombre = dao.getConsultarDato("padresfamilia", codigoApoderado, "dni", "nombre").toString();
            String apellido = dao.getConsultarDato("padresfamilia", codigoApoderado, "dni", "apellido").toString();
            String apoderado = nombre + " " + apellido;
            m.txtApoderado.setText(apoderado);
        } catch (NullPointerException e) {
        }
    }

    public void buscarMatricula() {
        try {
            String codigoBuscadoStr = m.alumno_txtDni.getText();
            if (codigoBuscadoStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor en el campo de búsqueda",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!esNumero(codigoBuscadoStr)) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo de búsqueda",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int idMatricula = Integer.parseInt(codigoBuscadoStr);
            Matricula matriculaEncontrada = tablaMatricula.buscar(idMatricula);
            if (matriculaEncontrada != null) {
                seleccionarFilaPorCodigo(idMatricula);
            } else {
                JOptionPane.showMessageDialog(null, "Matrícula no encontrada con ID: " + idMatricula,
                        "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo de búsqueda",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean esNumero(String str) {
        return str.matches("\\d+");
    }

    private void seleccionarFilaPorCodigo(int codigoBuscado) {
        // Busca la fila en la tabla que contiene el código buscado y la selecciona
        for (int rowIndex = 0; rowIndex < m.tablaMatricula.getRowCount(); rowIndex++) {
            int idEnTabla = (int) m.tablaMatricula.getValueAt(rowIndex, 0);
            if (idEnTabla == codigoBuscado) {
                m.tablaMatricula.setRowSelectionInterval(rowIndex, rowIndex);
                break;
            }
        }
    }

    public void setGradoNivel(String idSeccion) {
        try {
            String grado = dao.getConsultarDato("secciones", idSeccion, "idSeccion", "grado").toString();
            String identificarSecion = dao.getConsultarDato("secciones", idSeccion, "idSeccion", "division").toString();
            String identificarGrado = dao.getConsultarDato("grados", grado, "idGrado", "grado").toString();
            String identificarNivel = dao.getConsultarDato("grados", grado, "idGrado", "nivel").toString();
            m.txtGrado.setText(identificarGrado);
            m.txtNivel.setText(identificarNivel);
            m.txtSeccion.setText(identificarSecion);
        } catch (NullPointerException e) {
        }
    }

    public void modificar() {
        if (filaSeleccionada >= 0) {
            int msj = JOptionPane.YES_NO_OPTION;
            int confi = JOptionPane.showConfirmDialog(null, "Confirmar modificacion", "Confirmacion", msj);
            if (confi == 0) {
                String idMatricula = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "idMatricula").toString();
                String idSeccion = m.comboSeccion.getSelectedItem().toString();
                String pagado = m.comboPagado.getSelectedItem().toString();
                Date fecha = Proceso.obtenerFechaActual();
                dao.modificar(idMatricula, idSeccion, pagado, fecha);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void borrar() {
        if (filaSeleccionada >= 0) {
            int msj = JOptionPane.YES_NO_OPTION;
            int confi = JOptionPane.showConfirmDialog(null, "Confirmar eliminacion", "Confirmacion", msj);
            if (confi == 0) {
                String idMatricula = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "idMatricula").toString();
                dao.eliminar(idMatricula);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tablaMatriculaMouseClicked() {
        filaSeleccionada = m.tablaMatricula.getSelectedRow();
        String idMatricula = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "idMatricula").toString();
        String codigAlumno = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "Alumno").toString();
        String seccion = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "Seccion").toString();
        String pagado = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "pagado").toString();
        m.txtMatricula.setText("MATRICULA #" + idMatricula);
        m.comboAlumno.setSelectedItem(codigAlumno);
        m.comboSeccion.setSelectedItem(seccion);
        m.comboPagado.setSelectedItem(pagado);
        m.comboAlumno.setEnabled(false);
    }
    
    public void registrar() {

        try {

            ArbolMatricula arbolMatricula = new ArbolMatricula();

            // Hacer las preguntas del árbol
            arbolMatricula.realizarMatricula();

            // Mostrar mensaje de matrícula realizada
            JOptionPane.showMessageDialog(null, "Matrícula realizada",
                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);

            String dniAlumno = m.comboAlumno.getSelectedItem().toString();
            if (dao.alumnoExiste(dniAlumno)) {
                int msj = JOptionPane.YES_NO_OPTION;
                int confi = JOptionPane.showConfirmDialog(null, "Confirmar ingreso", "Confirmacion", msj);
                if (confi == 0) {
                    int idMatricula = getIdActual();
                    String idSeccion = m.comboSeccion.getSelectedItem().toString();
                    String pagado = m.comboPagado.getSelectedItem().toString();
                    Date fecha = Proceso.obtenerFechaActual();
                    Matricula matricula = new Matricula(idMatricula, dniAlumno, idSeccion, pagado, fecha);
                    dao.registrar(matricula);
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error Alumno existente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {

        }
    }
    int filaSeleccionada = -1;

}
