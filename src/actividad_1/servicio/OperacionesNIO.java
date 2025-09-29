package actividad_1.servicio;

import actividad_1.excepciones.ArchivoNoExisteException;
import actividad_1.excepciones.DirectorioNoExisteException;
import actividad_1.excepciones.NoEsArchivoException;
import actividad_1.excepciones.NoEsDirectorioException;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.stream.Stream;

public class OperacionesNIO {
    public static void main(String[] args)
            throws DirectorioNoExisteException, NoEsDirectorioException, IOException {
        recorrerRecursivo2("D:\\pruebaAC");
    }

    public static void borrar(String ruta)
            throws ArchivoNoExisteException, IOException {
        Path path = Paths.get(ruta);
        if(!Files.exists(path))
            throw new ArchivoNoExisteException("No existe el archivo o directorio");
        if(!Files.isDirectory(path)){
            try {
                Files.delete(path);
                System.out.println("Se ha borrado el archivo "+path);
            } catch (IOException e) {
                System.out.println("Error al borrar el archivo "+path);
            }
            return;
        }

        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                  try {
                      Files.delete(file);
                      System.out.println("Se ha borrado el archivo "+file);
                  } catch (IOException e) {
                      System.out.println("Error al borrar el archivo "+file);
                  }
                  return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                try {
                    Files.delete(dir);
                    System.out.println("Se ha borrado el directorio "+dir);
                }  catch (IOException e) {
                    System.out.println("Error al borrar el directorio "+dir);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void copiarDirectorio(String origen, String destino) throws IOException {
        Path origenPath = Paths.get(origen);
        Path destinoPath = Paths.get(destino);
        if (!Files.exists(destinoPath))
            Files.createDirectories(destinoPath);
        Files.walkFileTree(origenPath, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, destinoPath.resolve(origenPath.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void moverArchivo(String origen, String destino)
            throws IOException, ArchivoNoExisteException, NoEsArchivoException {
        File file = new File(origen);
        Utilidades.validarArchivo(file);
        Files.move(Paths.get(origen), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copiarArchivo(String origen, String destino)
            throws IOException, ArchivoNoExisteException, NoEsArchivoException {
        File file = new File(origen);
        Utilidades.validarArchivo(file);
        Files.copy(Paths.get(origen), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void filtrarPorExtensionYOrdenar(String ruta, String extension, boolean descendente)
            throws DirectorioNoExisteException, NoEsDirectorioException, IOException {
        Path dir =  Paths.get(ruta);
        Utilidades.esDirectorio(dir.toFile());
        Comparator<Path> comparator = Comparator.comparing(p -> p.getFileName().toString().toLowerCase());
        if (!descendente)
            comparator = comparator.reversed();
        try(Stream<Path> stream = Files.walk(dir)){
            stream.filter((path) -> Files.isRegularFile(path)&&Files.isReadable(path)&&path.toString().toLowerCase().endsWith(extension))
                    .sorted(comparator)
                    .forEach(path -> Utilidades.mostrarInformacionFichero(path.toFile(), "---"));
        }catch(AccessDeniedException e){
            System.out.println("No se pudo acceder al directorio");
        }
    }

    //NO RECURSIVO (También se podía hacer con Files.list())
    public static void filtrarPorExtension2(String ruta, String extension)
            throws DirectorioNoExisteException, NoEsDirectorioException, IOException {
        Path dir =  Paths.get(ruta);
        Utilidades.esDirectorio(dir.toFile());
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*."+extension)){
            boolean encontrado = false;
            for(Path path: stream){
                Utilidades.mostrarInformacionFichero(path.toFile());
                encontrado = true;
            }
            if(!encontrado){
                System.out.println("No se encontraron archivos");
            }
        }catch(AccessDeniedException e){
            System.out.println("No se pudo acceder al directorio");
        }
    }

    //RECURSIVO
    public static void filtrarPorExtension(String ruta, String extension)
            throws DirectorioNoExisteException, NoEsDirectorioException, IOException {
        Path dir =  Paths.get(ruta);
        Utilidades.esDirectorio(dir.toFile());
        try(Stream<Path> stream = Files.walk(dir)){
            stream.filter((path) -> Files.isRegularFile(path)&&Files.isReadable(path)&&path.toString().toLowerCase().endsWith(extension))
                    .forEach((path) -> Utilidades.mostrarInformacionFichero(path.toFile(), "---"));
        }catch(AccessDeniedException e){
            System.out.println("No se pudo acceder al directorio");
        }
    }

    public static void recorrerRecursivo2(String ruta)
            throws IOException {
        Path dir = Paths.get(ruta);
        Files.walkFileTree(dir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                Utilidades.mostrarInformacionFichero(file.toFile(), Utilidades.calcularSangria(dir, file));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                Utilidades.mostrarInformacionFichero(dir.toFile(), Utilidades.calcularSangria(Paths.get(ruta), dir));
                return FileVisitResult.CONTINUE;
            }

            //COGE DIRECTORIOS Y ARCHIVOS -- LOS ANTERIORES SOLO UNO
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.err.println("Error al visitar el directorio: " + file.toAbsolutePath() + " --> " + exc.getMessage());
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void recorrerRecursivo(String ruta)
            throws DirectorioNoExisteException, NoEsDirectorioException, IOException {
        Path dir = Paths.get(ruta);
        Utilidades.esDirectorio(dir.toFile());
        try(Stream<Path> s = Files.walk(dir)) {
            s.filter(Files::isReadable)
                    .forEach(path -> {
                String sangria = Utilidades.calcularSangria(dir, path);
                Utilidades.mostrarInformacionFichero(path.toFile(), sangria);
            });
        }
        /*
        try(Stream<Path> s = Files.walk(dir)) {
            s.forEach(path -> {
                try {
                String sangria = Utilidades.calcularSangria(dir, path);
                Utilidades.mostrarInformacionFichero(path.toFile(), sangria);
                }
            });
        }
        */
    }

    public static void visualizarContenido(String ruta)
            throws DirectorioNoExisteException, NoEsDirectorioException, IOException {
        Path dir = Paths.get(ruta);
        Utilidades.esDirectorio(dir.toFile());
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                Utilidades.mostrarInformacionFichero(path.toFile());
            }
        }
        /*
        ---PROGRAMACIÓN FUNCIONAL---
        try(Stream<Path> stream = Files.list(dir)){
            stream.forEach(System.out::println);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
       PROGRAMACIÓN CLÁSICA
        try(Stream<Path> stream = Files.list(dir)){
            Iterator<Path> iterator = stream.iterator();
            while(iterator.hasNext()){
                Path path = iterator.next();
                System.out.println(path);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        */
    }
}
