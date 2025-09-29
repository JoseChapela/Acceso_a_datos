package actividad_2;

import java.io.File;
import java.util.HashMap;

public class Operaciones {

    //EXTRA EN CLASE
    public static void VecesPorPalabra(String ruta){
       LecturaTexto in;
       String linea;
       String[] palabras;
       HashMap<String,Integer> mapaPalabras;

       in = new LecturaTexto(ruta);
       in.abrirArchivo();
       linea=in.leerLinea();
       mapaPalabras = new HashMap<>();

       while(linea!=null){
           //linea = linea.replaceAll("\\p{Punct}"," ");
           //palabras = linea.split(" ");
           palabras = linea.split("(\\s?\\p{Punct}\\s?)|\\s+");
           for (String palabra : palabras) {
               mapaPalabras.put(palabra.toLowerCase(), mapaPalabras.getOrDefault(palabra, 0) + 1);
           }
           linea=in.leerLinea();
       }
        for(String key : mapaPalabras.keySet()){
            System.out.println(key+" --> "+mapaPalabras.get(key));
        };
    }

    //EJERCICIO-3--------------------------------------------------------------------------
    public static void palabraPorLinea(String rutaOrigen, String palabra, String rutaDestino) {
        LecturaTexto in;
        EscribirTexto out;
        String linea;
        int totalR;
        int totalA=0;
        int contador=1;

        in = new LecturaTexto(rutaOrigen);
        out = new EscribirTexto(rutaDestino);
        in.abrirArchivo();
        out.abrirArchivo();

        out.escribirLinea("La palabra "+palabra+" en el fichero "+rutaOrigen);
        out.escribirLinea("--------------------------------------------------");

        linea=in.leerLinea();
        while(linea!=null){
            totalA+=totalR=contarApariciones(linea, palabra);
            out.escribirLinea("linea "+contador+": aparece "+totalR+" veces");
            contador++;
            linea=in.leerLinea();
        }
        out.escribirLinea("--------------------------------------------------");
        out.escribirLinea("Aparece un total de "+totalA);
        in.cerrarArchivo();
        out.cerrarArchivo();
    }

    public static int contarApariciones(String linea, String palabra){
        int total=0;
        int indice=0;
        indice=linea.indexOf(palabra);
        while(indice!=-1){
            total++;
            indice=linea.indexOf(palabra,indice+palabra.length()-1);
        }
        return total;
    }

    //EJERCICIO-2--------------------------------------------------------------------------

    public static void crearDirectoriosConFormato(String rutaOrigen, String rutaDestino){
        LecturaTexto in;
        String linea;
        File directorio;
        EscribirTexto out;
        String formato=".*/\\d/.*";
        String mesajeOk = " --> Se creó correctamente el directorio";
        String mesajeError = " --> No tiene el formato CURSO/NUMERO/ALUMNO. No se creó el directorio";

        in=new LecturaTexto(rutaOrigen);
        out=new EscribirTexto(rutaDestino);
        in.abrirArchivo();
        out.abrirArchivo();

        linea=in.leerLinea();
        while(linea!=null){
            if(!linea.matches(formato)){
                out.escribirLinea(linea+mesajeError);
            }
            else {
                String[] partes = linea.split("/");
                String newRuta=partes[0]+"/"+partes[1]+"-"+partes[2];
                directorio = new File(newRuta);
                directorio.mkdirs();
                out.escribirLinea(partes[2]+mesajeOk);
            }
            linea=in.leerLinea();
        }
        out.cerrarArchivo();
        in.cerrarArchivo();
    }

    public static boolean validarRuta(String ruta,String formato){
        return ruta.matches(formato);
    }

    //EJERCICIO-1--------------------------------------------------------------------------

    public static int contarLineasTxT(String ruta){
        LecturaTexto in;
        int numLineas = 0;

        in = new LecturaTexto(ruta);

        try{
            in.abrirArchivo();
        }catch(Exception e){
            return -1;
        }
        while(in.leerLinea()!=null)
            numLineas++;
        return numLineas;
    }

    public static void escribirNumLineas(String[] rutasOrigen, String rutaDestino){
        EscribirTexto out;
        String details;

        out = new EscribirTexto(rutaDestino);
        out.abrirArchivo();

        for(String ruta : rutasOrigen){
            details=contarLineasTxT(ruta)+"";
            if(details.equals("-1"))
                details = "Error";
            out.escribirLinea(ruta+" - ["+details+"]");
        }
        out.cerrarArchivo();
    }
}
