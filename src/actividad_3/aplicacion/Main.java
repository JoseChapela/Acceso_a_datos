package actividad_3.aplicacion;

import actividad_3.servicio.Utilidades;

public class Main {

    final static String ARCHIVO_CORREDORES="src/actividad_3/recursos/corredores.dat";

    public static void main(String[] args) {

        //ESCRIBIENDO TODOS LOS CORREDORES
        Utilidades.escribirCorredores(Utilidades.ejemploCorredores(), ARCHIVO_CORREDORES);

        //LISTAR CORREDORES
        Utilidades.listarCorredores(ARCHIVO_CORREDORES);
    }
}
