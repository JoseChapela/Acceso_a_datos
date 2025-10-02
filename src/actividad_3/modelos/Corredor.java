package actividad_3.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Corredor implements Serializable {

    final static long SERIAL_NUMBER=1L;
    static int numCorredores=0;

    int dorsal = 0;
    String nombre;
    LocalDate fechaNacimiento;
    int equipo;
    List<Puntuacion> puntuaciones;

    public Corredor(String nombre, LocalDate fechaNacimiento, int equipo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.equipo = equipo;
        numCorredores++;
        dorsal=numCorredores;
    }

    @Override
    public String toString() {
        return nombre+" -> "+dorsal;
    }

    public int getDorsal() {
        return dorsal;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Corredor corredor)) return false;
        return dorsal == corredor.dorsal;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dorsal);
    }
}