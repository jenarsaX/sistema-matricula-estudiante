package LAL;

import MODELO.Matricula;

public class Recursividad {

    // Método recursivo para procesar una lista de matrículas
    public static void procesarMatriculas(Matricula[] matriculas, int index) {
        // Caso base: Si el índice es igual o mayor que la longitud de la lista, terminamos la recursión.
        if (index >= matriculas.length) {
            return;
        }

        // Realizar alguna acción en la matrícula actual
        Matricula matriculaActual = matriculas[index];
        System.out.println("ID de Matrícula: " + matriculaActual.getIdMatricula());
        // Realiza cualquier otra acción que desees con la matrícula aquí

        // Llamar recursivamente al método para procesar la siguiente matrícula
        procesarMatriculas(matriculas, index + 1);
    }

    public static void main(String[] args) {
        // Crear una lista de matrículas (debes inicializarla según tus datos)
        Matricula[] matriculas = new Matricula[3];
        matriculas[0] = new Matricula(1, "Alumno1", "Seccion1", "Pagado", new java.sql.Date(System.currentTimeMillis()));
        matriculas[1] = new Matricula(2, "Alumno2", "Seccion2", "No Pagado", new java.sql.Date(System.currentTimeMillis()));
        matriculas[2] = new Matricula(3, "Alumno3", "Seccion3", "Pagado", new java.sql.Date(System.currentTimeMillis()));

        // Llamar al método recursivo para procesar las matrículas
        procesarMatriculas(matriculas, 0);
    }
}
