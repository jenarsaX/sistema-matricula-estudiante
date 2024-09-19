
package LAL;

import LAL.ArbolMatricula;
import javax.swing.JOptionPane;

public class prueba {

    public static void main(String[] args) {
        ArbolMatricula a = new ArbolMatricula();
        a.insertarNodo(false, "¿El estudiante ha realizado el pago de la matrícula?");
        a.insertarNodo(true, "¿El pago está al día?");
        a.insertarNodo(false, "¿Tiene algún descuento?");
        a.insertarNodo(true, "¿Es beneficiario de alguna beca?");
        a.insertarNodo(false, "¿El estudiante cumple con los requisitos para la beca académica?");
        JOptionPane.showMessageDialog(null, "\n" + a.realizarMatricula());
    }
}
