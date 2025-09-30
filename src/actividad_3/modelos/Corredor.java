package actividad_3.modelos;

import java.time.LocalDate;
import java.util.List;

public class Corredor {

    int dorsal;
    String nombre;
    LocalDate fechaNacimiento;
    int equipo;
    List<Puntuacion> puntuaciones;
    final static long SERIAL_NUMBER=1L;
}
