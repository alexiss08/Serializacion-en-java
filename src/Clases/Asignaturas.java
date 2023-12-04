package Clases;

import java.io.Serializable;
import java.util.Scanner;

public class Asignaturas implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private double nota;

    public Asignaturas(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota1) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nota para " + nombre + ": ");
        double nuevaNota = scanner.nextDouble();

        if (validarNota(nuevaNota)) {
            this.nota = nuevaNota;
        } else {
            System.out.println("La nota debe estar entre 0 y 10. No se ha asignado la nota.");
        }
    }

    private boolean validarNota(double nota) {
        return nota >= 0 && nota <= 10;
    }

    public static Asignaturas[] inicializarAsignaturas() {
        String[] nombres = {
                "Programacion orientada a objetos",
                "Ingles 1",
                "Administracion de bases de datos",
                "Logica Digital",
                "Introduccion al Software Libre",
                "Psicologia del trabajo"
        };

        Asignaturas[] asignaturas = new Asignaturas[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            asignaturas[i] = new Asignaturas(nombres[i]);
        }

        return asignaturas;
    }

    // Nuevo método para inicializar las notas de las asignaturas deserializadas
    public static void inicializarNotas(Asignaturas[] asignaturas, double[] notas) {
        for (int i = 0; i < asignaturas.length; i++) {
            asignaturas[i].setNota(notas[i]);
        }
    }

    public static double calcularNotaMedia(Asignaturas[] asignaturas) {
        double sumaNotas = 0;
        for (Asignaturas asignatura : asignaturas) {
            sumaNotas += asignatura.getNota();
        }
        return sumaNotas / asignaturas.length;
    }
}
