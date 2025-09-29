package actividad_2;

public class Main {
    //EJERCICIO 1--------------------------------------------------------------------
    final static String [] ORIGEN_1={"exercicio5-1","file.txt","file3.txt","file2.txt"};
    final static String DESTINO_1="Salida.txt";
    //EJERCICIO 2--------------------------------------------------------------------
    final static String ORIGEN_2="Cursos-Alumno.txt";
    final static String DESTINO_2="ficherolog.txt";
    //EJERCICIO 3--------------------------------------------------------------------
    final static String ORIGEN_3="ejercicio3_entrada.txt";
    final static String PALABRA_3="escoba";
    final static String DESTINO_3="ejercicio3_salida.txt";

    public static void main(String[] args) {
        //EJERCICIO 1
        //Operaciones.escribirNumLineas(args, DESTINO_1);

         //EJERCICIO2
         //Operaciones.crearDirectoriosConFormato(ORIGEN_2,DESTINO_2);

        //EJERCICIO3
        //Pattern p = Pattern.compile ("\\b" + Pattern.quote(palabra)+"\\b, ..."), Matcher m = p.matcher, while (m.find())
        //Operaciones.palabraPorLinea(ORIGEN_3,PALABRA_3,DESTINO_3);

        Operaciones.VecesPorPalabra(ORIGEN_3);
    }
}
