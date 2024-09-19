package CONTROLADOR;

import DAO.daoAlumno;
import LAL.ListaEnlazadaAlumno;
import LAL.Pilas;
import MODELO.Alumno;
import MODELO.Proceso;
import VISTA.moduloAlumnoApoderado;
import javax.swing.JOptionPane;

public class ControladorAlumno {

    private Pilas historialAlumnosEliminados;
    private ListaEnlazadaAlumno listaEnlazadaAlumno = new ListaEnlazadaAlumno();
    private daoAlumno miDaoAlumno;
    moduloAlumnoApoderado a;
    daoAlumno dao;

    public ControladorAlumno(moduloAlumnoApoderado a) {

        this.a = a;
        dao = new daoAlumno();
        miDaoAlumno = new daoAlumno();
        dao = new daoAlumno();
        this.historialAlumnosEliminados = new Pilas();
    }

    public void initDiseño() {
        limpiar();
        Proceso.transparentarTxtField(a.alumno_txtDni, a.alumno_txtNombre, a.alumno_txtApellido);
        dao.rellenarCombo(a.alumno_comboApoderado, "padresfamilia", "dni");
    }

    public void limpiar() {
        consultar();
        filaSeleccionada = -1;
        a.alumno_txtDni.setText("");
        a.alumno_txtNombre.setText("");
        a.alumno_txtApellido.setText("");
        a.alumno_txtDni.setEditable(true);
    }

    public void consultar() {
        dao.consultar(a.tablaAlumno);
    }

    public void buscarAlumno() {
        try {
            String dniBuscado = a.jtxtBuscar.getText();
            if (dniBuscado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor en el campo de búsqueda",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Alumno alumnoEncontrado = miDaoAlumno.BuscarAlumno(dniBuscado, listaEnlazadaAlumno);

            if (alumnoEncontrado != null) {
                a.alumno_txtNombre.setText(alumnoEncontrado.getNombre());
                a.alumno_txtApellido.setText(alumnoEncontrado.getApellido());
                a.alumno_comboApoderado.setSelectedItem(alumnoEncontrado.getApoderado());
            } else {
                JOptionPane.showMessageDialog(null, "Alumno no encontrado con DNI: " + dniBuscado,
                        "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error durante la búsqueda",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar() {
        if (filaSeleccionada >= 0) {
            int msj = JOptionPane.YES_NO_OPTION;
            int confir = JOptionPane.showConfirmDialog(null, "Confirmar eliminación", "Confirmación", msj);
            if (confir == 0) {
                String dni = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "dni").toString();

                // Eliminar el alumno y agregarlo al historial
                if (miDaoAlumno.borrarAlumno(dni, listaEnlazadaAlumno, historialAlumnosEliminados)) {
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el alumno", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void recuperar() {
        try {
            // Recuperar el último alumno desde la pila utilizando el método peek
            Alumno alumnoRecuperado = historialAlumnosEliminados.peek();

            if (alumnoRecuperado != null) {
                // Insertar el alumno recuperado en la base de datos y la lista enlazada
                miDaoAlumno.recuperarAlumnoEliminado(listaEnlazadaAlumno, historialAlumnosEliminados);
                consultar();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No hay alumnos eliminados en el historial.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error durante la recuperación",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void registrarAlu() {
        String dni = a.alumno_txtDni.getText();
        String nombre = a.alumno_txtNombre.getText();
        String apellido = a.alumno_txtApellido.getText();
        String apoderado = a.alumno_comboApoderado.getSelectedItem().toString();

        boolean comprobarVacios = Proceso.ComprobarTxtVacio(dni, nombre, apellido, apoderado);

        if (!comprobarVacios) {
            int msj = JOptionPane.YES_NO_OPTION;
            int confir = JOptionPane.showConfirmDialog(null, "Confirmar registro", "Confirmacion", msj);

            if (confir == 0) {
                String codigo = Proceso.generarCodigo('A', dni, apellido, Proceso.obtenerFechaActual());
                Alumno alumno = new Alumno(codigo, dni, nombre, apellido, apoderado);

                // Añadir alumno a la lista enlazada
                listaEnlazadaAlumno.añadirAlumno(alumno);
                limpiar();
                miDaoAlumno.registrarAlumnosEnBaseDeDatos(listaEnlazadaAlumno);
                consultar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos vacíos");
        }
    }

    public void modificar() {
        if (filaSeleccionada >= 0) {

            int msj = JOptionPane.YES_NO_OPTION;
            int confir = JOptionPane.showConfirmDialog(null, "Confirmar modificacion", "Confirmacion", msj);
            if (confir == 0) {
                String codigo = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "codigo").toString();
                String apoderado = a.alumno_comboApoderado.getSelectedItem().toString();
                dao.modificar(codigo, apoderado);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    int filaSeleccionada = -1;

    public void tablaAlumnoMouseClicked() {
        filaSeleccionada = a.tablaAlumno.getSelectedRow();
        String codigo = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "codigo").toString();
        String dni = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "dni").toString();
        String nombre = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "nombre").toString();
        String apellido = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "apellido").toString();
        String apoderado = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "apoderado").toString();

        a.alumno_txtDni.setText(dni);
        a.alumno_txtNombre.setText(nombre);
        a.alumno_txtApellido.setText(apellido);
        a.alumno_comboApoderado.setSelectedItem(apoderado);
        a.alumno_txtDni.setEditable(false);
    }
}
