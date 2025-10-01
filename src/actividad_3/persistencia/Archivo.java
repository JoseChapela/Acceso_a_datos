package actividad_3.persistencia;

import java.io.File;

public abstract class Archivo {
    //ATRIBUTOS
    File file;
    //CONSTRUCTOR
    public Archivo(String ruta){
        file = new File(ruta);
    }
    //MÉTODOS ABSTRACTOS
    public abstract void abrirArchivo();
    public abstract void cerrarArchivo();
    //MÉTODOS
    public boolean existe(){
        return file.exists();
    }
    public boolean borrar(){
        return file.delete();
    }
    public boolean renombrar(String nuevoNombre){
        return file.renameTo(new File(file.getParent(),nuevoNombre));
    }
    public File getFile(){
        return file;
    }
}
