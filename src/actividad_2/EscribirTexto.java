package actividad_2;

import java.io.*;

public class EscribirTexto extends Archivo{
    BufferedWriter buffer;
    public EscribirTexto(String ruta){
        super(ruta);
    }

    @Override
    public void abrirArchivo() {
        try {
            buffer = new BufferedWriter(new FileWriter(getFile()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cerrarArchivo() {
        try {
            if (buffer != null)
                buffer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escribirLinea(String linea) {
        try {
            buffer.write(linea);
            buffer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
