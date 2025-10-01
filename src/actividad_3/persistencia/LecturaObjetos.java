package actividad_3.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LecturaObjetos extends Archivo{

    //ATRIBUTOS
    ObjectInputStream in;

    //CONSTRUCTORES
    public LecturaObjetos(String ruta) {
        super(ruta);
    }

    //MÉTODOS
    @Override
    public void abrirArchivo() {
        try {
            in = new ObjectInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No existe el archivo");
        } catch (IOException e) {
            throw new RuntimeException("No se ha podido abrir el archivo");
        }
    }

    @Override
    public void cerrarArchivo() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException("No se ha podido cerrar el archivo");
            }
        }
    }

    public Object getObjet(){

        try {
            return in.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el objeto");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al leer la clase");
        }
    }
}
