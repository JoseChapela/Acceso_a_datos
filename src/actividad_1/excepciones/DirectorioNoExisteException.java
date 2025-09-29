package actividad_1.excepciones;

public class DirectorioNoExisteException extends Exception{
    public DirectorioNoExisteException(String message){
        super(message);
    }
}
