package actividad_2;

import java.io.*;

public class LecturaTexto extends Archivo{
    BufferedReader  buffer;
    public LecturaTexto(String ruta){
        super(ruta);
    }

    @Override
    public void abrirArchivo() {
        try {
            buffer = new BufferedReader(new FileReader(getFile()));
        } catch (FileNotFoundException e) {
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

    public String leerLinea(){
        try {
            return buffer.readLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
