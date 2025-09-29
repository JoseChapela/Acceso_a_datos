package actividad_1.servicio;

import actividad_1.excepciones.ArchivoNoExisteException;
import actividad_1.excepciones.DirectorioNoExisteException;
import actividad_1.excepciones.NoEsArchivoException;
import actividad_1.excepciones.NoEsDirectorioException;

import java.io.File;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Utilidades {

    public static void esDirectorio (File file)
            throws DirectorioNoExisteException, NoEsDirectorioException {
        if(!file.exists())
            throw new DirectorioNoExisteException("El directorio no existe");
        else if (!file.isDirectory())
            throw new NoEsDirectorioException("El archivo no es un directorio");
    }

    public static void validarArchivo(File file)
            throws ArchivoNoExisteException, NoEsArchivoException {
        if (!file.exists())
            throw new ArchivoNoExisteException("El archivo no existe");
        if (file.isDirectory())
            throw new NoEsArchivoException("No es un archivo");

    }

    public static String milisecToDate(Long milisec, String formato){
        LocalDateTime date = Instant.ofEpochMilli(milisec).atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return date.format(formatter);
    }

    public static void mostrarInformacionFichero(File file){
        mostrarInformacionFichero(file, "---");
    }

    public static void mostrarInformacionFichero(File file, String formatoSangria){
        final String FORMATO = "dd/MM/yyyy HH:mm:ss";
        String informacionFichero = formatoSangria;
        if(file.isDirectory())
            informacionFichero += file.getName()+" <DIR> ";
        else
            informacionFichero += file.getName()+" <FICHERO> "+ NumberFormat.getInstance().format(file.length() / 1024.0) +" KB ";
        System.out.println(informacionFichero+Utilidades.milisecToDate(file.lastModified(),FORMATO));
    }

    public static String calcularSangria (Path base, Path actual){
        return "---".repeat(base.relativize(actual).getNameCount()-1);
    }
}
