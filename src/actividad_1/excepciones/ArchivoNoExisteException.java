package actividad_1.excepciones;

public class ArchivoNoExisteException extends Exception {
    public ArchivoNoExisteException(String message) {
        super(message);
    }
}
