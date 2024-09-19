package LAL;


import MODELO.Docente;
import java.util.List;

public class AlgoritmoBubbleSort {
    
    public static void bubbleSort(List<Docente> listaDocentes) {
        int n = listaDocentes.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (listaDocentes.get(j).getNombre().compareTo(listaDocentes.get(j + 1).getNombre()) > 0) {
                    // Intercambiar elementos si están en el orden incorrecto
                    Docente temp = listaDocentes.get(j);
                    listaDocentes.set(j, listaDocentes.get(j + 1));
                    listaDocentes.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}