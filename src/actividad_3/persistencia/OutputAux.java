package actividad_3.persistencia;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputAux extends ObjectOutputStream {


    protected OutputAux(FileOutputStream fileOutputStream) throws IOException {
        super(fileOutputStream);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
    }
}
