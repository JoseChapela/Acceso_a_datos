package actividad_3.persistencia;

import java.io.*;

public class EscrituraObjetos extends Archivo{

    //ATRIBUTOS
    ObjectOutputStream out1=null;
    OutputAux out2=null;
    boolean primeraEscritura=true;

    //CONSTRUCTORES
    public EscrituraObjetos(String ruta) {
        super(ruta);
    }

    //MÉTODOS

    @Override
    public void abrirArchivo() {
        try {
            if(file.exists()) {
                out2 = new OutputAux(new FileOutputStream(file, true));
                primeraEscritura=false;
            }
            else
                out1 = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cerrarArchivo() {
        try {
            if (out1 != null)
                out1.close();
            if (out2 != null)
                out2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public void escribirObjeto(Object objeto){
        try {
            if (primeraEscritura) {
                out1.writeObject(objeto);
                out1.close();
                out1=null;
                primeraEscritura=false;
                abrirArchivo();
            } else {
                out2.writeObject(objeto);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
