package Clases;

public class Principal {
    public static void main(String[] args) {
        // Inicializa las asignaturas
        Asignaturas[] asignaturas = Asignaturas.inicializarAsignaturas();

        // Ingreso de notas por parte del usuario
        for (Asignaturas asignatura : asignaturas) {
            asignatura.setNota(0);  // Puedes poner cualquier valor, ya que se sobrescribirá
        }

        // Serialización
        String rutaDirectorio = "src/carpetaNotas";
        String archivoSerializado = rutaDirectorio + "/notasSerializadas.txt";
        Serializador.serializar(asignaturas, archivoSerializado);
        System.out.println("Notas serializadas correctamente.");

        // Deserialización
        Asignaturas[] asignaturasDeserializadas = (Asignaturas[]) Serializador.deserializar(archivoSerializado);

        // Muestra de las asignaturas deserializadas
        System.out.println("Notas deserializadas:");
        for (Asignaturas asignatura : asignaturasDeserializadas) {
            System.out.println("Asignatura: " + asignatura.getNombre() + ", Nota: " + asignatura.getNota());
        }

        // Calcula y muestra la nota media de las asignaturas deserializadas
        double notaMedia = Asignaturas.calcularNotaMedia(asignaturasDeserializadas);
        System.out.println("Nota media de todas las asignaturas: " + notaMedia);
    }
}
