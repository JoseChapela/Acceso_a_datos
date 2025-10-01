package actividad_1.servicio;

import actividad_1.excepciones.ArchivoNoExisteException;
import actividad_1.excepciones.NoEsArchivoException;

import java.io.IOException;

public class Main {

    final static String EJERCICIO_1="src/actividad_2/recursos_1";
    final static String EJERCICIO_6_ORIGEN="src/actividad_2/recursos_1/file1.txt";
    final static String EJERCICIO_6_DESTINO="src/actividad_2/recursos_1/directorio1/filenueva.txt";


    public static void main(String[] args)
            throws ArchivoNoExisteException, IOException, NoEsArchivoException {

        //EJERCICIO-1--------------------------------------------------------------
        //OperacionesNIO.visualizarContenido(EJERCICIO_1);

        //EJERCICIO-2--------------------------------------------------------------
        //OperacionesNIO.recorrerRecursivo(EJERCICIO_1);

        //EJERCICIO-3--------------------------------------------------------------
        //OperacionesNIO.filtrarPorExtension(EJERCICIO_1, ".txt");

        //EJERCICIO-4--------------------------------------------------------------
        //OperacionesNIO.filtrarPorExtensionYOrdenar(EJERCICIO_1, ".txt",false);

        //EJERCICIO-5--------------------------------------------------------------
        //OperacionesNIO.filtrarPorSubcadena(EJERCICIO_1,"file3");

        //EJERCICIO-5--------------------------------------------------------------
        OperacionesNIO.copiarArchivo(EJERCICIO_6_ORIGEN, EJERCICIO_6_DESTINO);
    }
}
