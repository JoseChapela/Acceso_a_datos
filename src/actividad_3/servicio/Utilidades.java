package actividad_3.servicio;

import actividad_2.LecturaTexto;
import actividad_3.modelos.Corredor;
import actividad_3.modelos.Fondista;
import actividad_3.modelos.Velocista;
import actividad_3.persistencia.EscrituraObjetos;
import actividad_3.persistencia.LecturaObjetos;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        EscrituraObjetos out = new EscrituraObjetos(ruta);
        out.abrirArchivo();
        for(Corredor corredor : corredores)
            out.escribirObjeto(corredor);
        out.cerrarArchivo();
    }

    public static List<Corredor> listarCorredores (String ruta){

        Corredor corredor;
        List<Corredor> corredores;
        LecturaObjetos in;

        corredores= new ArrayList<>();
        in = new LecturaObjetos(ruta);

        in.abrirArchivo();
        try{
            while(true){
                corredor= (Corredor)in.getObjet();
                corredores.add(corredor);
            }
        }catch(Exception _){
            return corredores;
        }
    }

    public static void imprimirCorredores(String ruta){
        for (Corredor corredor : listarCorredores(ruta))
            System.out.println(corredor);
    }

    public static boolean borrarCorredor(String ruta, int numDorsal) {
        List<Corredor> corredores = listarCorredores(ruta);
            for(Corredor corredor : corredores)
                if(corredor.getDorsal() == numDorsal){
                    corredores.remove(corredor);
                    actualizaCorredores(corredores.toArray(new Corredor[0]), ruta);
                    return true;
                }
        return false;
    }

    public static void actualizaCorredores(Corredor[] corredores,  String ruta){
        borrarRegistros(ruta);
        escribirCorredores(corredores, ruta);
    }

    public static void borrarRegistros (String ruta){
        new File(ruta).delete();
    }
}
