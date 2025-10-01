package actividad_3.persistencia;

import java.io.*;

public class EscrituraObjetos extends Archivo{

    //ATRIBUTOS
    ObjectOutputStream out1;
    OutputAux out2;
    boolean primeraEscritura=true;

    //CONSTRUCTORES
    public EscrituraObjetos(String ruta) {
        super(ruta);
    }

    //MÉTODOS
    @Override
    public void abrirArchivo() {
        try {
            out2 = new OutputAux(new FileOutputStream(file, true));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No existe el archivo");
        } catch (IOException e) {
            throw new RuntimeException("No se ha podido abrir el archivo");
        }
        primeraEscritura=false;
    }

    public void crearArchivo() {
        try {
            out1 = new ObjectOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No existe el archivo");
        } catch (IOException e) {
            throw new RuntimeException("No se ha podido abrir el archivo");
        }
    }

    @Override
    public void cerrarArchivo() {
        if (out1 != null) {
            try {
                out1.close();
            } catch (IOException e) {
                throw new RuntimeException("No se ha podido cerrar el archivo");
            }
        }
    }

    public void escribirObjetos(Object objeto){

        try {
            if(primeraEscritura){
                out1.writeObject(objeto);
                primeraEscritura=false;
            }else {
                out2.writeObject(objeto);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el objeto");
        }
    }
}
