package actividad_3.modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class Velocista extends Corredor implements Serializable {

    float velocidadMedia;
    final static long SERIAL_NUMBER=1L;

    public Velocista(String nombre, LocalDate fechaNacimiento, int equipo, float velocidadMedia) {
        super(nombre, fechaNacimiento, equipo);
        this.velocidadMedia=velocidadMedia;
    }
}
