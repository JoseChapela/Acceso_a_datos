package actividad_3.servicio;

import actividad_2.LecturaTexto;
import actividad_3.modelos.Corredor;
import actividad_3.modelos.Fondista;
import actividad_3.modelos.Velocista;
import actividad_3.persistencia.EscrituraObjetos;
import actividad_3.persistencia.LecturaObjetos;

import java.time.LocalDate;

public class Utilidades {

    public static Corredor[] ejemploCorredores(){
        Corredor corredor1 = new Velocista("Juan Pérez", LocalDate.of(2000, 5, 12), 1, 10.34f);
        Corredor corredor2 = new Fondista("Ana Gómez", LocalDate.of(1995, 3, 22), 2, 42.195f);
        Corredor corredor3 = new Velocista("Carlos Ruiz", LocalDate.of(2002, 11, 30), 3, 9.75f);
        Corredor corredor4 = new Fondista("María López", LocalDate.of(2000, 7, 15), 1, 21.097f);
        Corredor corredor5 = new Velocista("Pedro García", LocalDate.of(1995, 8, 5), 1, 11.20f);
        Corredor corredor6 = new Fondista("Laura Martínez", LocalDate.of(2002, 9, 10), 4, 35.00f);
        return new Corredor[]{corredor1, corredor2, corredor3, corredor4, corredor5, corredor6};
    }

    public static void escribirCorredor(Corredor corredor, String ruta){
        EscrituraObjetos out = new EscrituraObjetos(ruta);
        out.abrirArchivo();
        out.escribirObjeto(corredor);
        out.cerrarArchivo();
    }

    public static void escribirCorredores(Corredor[] corredores, String ruta){
        for (Corredor corredor : corredores)
            escribirCorredor(corredor, ruta);

    }

    public static void listarCorredores(String ruta){
        LecturaObjetos in = new LecturaObjetos(ruta);
        Corredor corredor;
        in.abrirArchivo();
        try{
            while(true){
                corredor= (Corredor)in.getObjet();
                System.out.println(corredor);
            }
        }catch(Exception e){}
    }
}
