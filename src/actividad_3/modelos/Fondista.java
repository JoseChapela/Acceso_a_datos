package actividad_3.modelos;

import java.time.LocalDate;
import java.util.List;

public class Fondista extends Corredor{

    float distanciaMax;
    final static long SERIAL_NUMBER=1L;

    public Fondista(String nombre, LocalDate fechaNacimiento, int equipo, float  distanciaMax) {
        super(nombre, fechaNacimiento, equipo);
        this.distanciaMax=distanciaMax;
    }
}
