package DAO;

import LAL.HashTableMatricula;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface DaoProceso {

    public abstract Object getConsultarDato(String codigo, String nombreColumnaBD);

    //public abstract DefaultTableModel consultar(JTable tabla);
    
    public abstract DefaultTableModel mostrarMatriculas(JTable tabla, HashTableMatricula tablaMatricula);
    

}
