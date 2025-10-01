package actividad_3.modelos;

import java.time.LocalDate;
import java.util.List;

public class Corredor {

    int dorsal = 0;
    String nombre;
    LocalDate fechaNacimiento;
    int equipo;
    List<Puntuacion> puntuaciones;
    final static long SERIAL_NUMBER=1L;

    public Corredor(String nombre, LocalDate fechaNacimiento, int equipo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return nombre+" -> "+dorsal;
    }
}
