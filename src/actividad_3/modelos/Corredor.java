package actividad_3.modelos;

import java.time.LocalDate;
import java.util.List;

public class Corredor {

    int dorsal = 0;
    String nombre;
    LocalDate fechaNacimiento;
    int equipo;

    public Corredor(String nombre, LocalDate fechaNacimiento, int equipo, List<Puntuacion> puntuaciones) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.equipo = equipo;
        this.puntuaciones = puntuaciones;
    }

    List<Puntuacion> puntuaciones;

    final static long SERIAL_NUMBER=1L;
}
