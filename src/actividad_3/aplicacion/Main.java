package actividad_3.aplicacion;

import actividad_3.servicio.Utilidades;

public class Main {

    final static String ARCHIVO_CORREDORES="src/actividad_3/recursos/corredores.dat";
    final static int NUM_DORSAL_EJEMPLO=3;

    public static void main(String[] args) {

        //ESCRIBIENDO TODOS LOS CORREDORES
        Utilidades.escribirCorredores(Utilidades.ejemploCorredores(), ARCHIVO_CORREDORES);

        //LISTAR CORREDORES
        Utilidades.imprimirCorredores(ARCHIVO_CORREDORES);
        System.out.println("**************************");

        //ELIMINAR CORREDOR POR DORSAL
        Utilidades.borrarCorredor(ARCHIVO_CORREDORES, NUM_DORSAL_EJEMPLO);
        Utilidades.imprimirCorredores(ARCHIVO_CORREDORES);
        System.out.println("**************************");

    }
}
