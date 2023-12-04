package Clases;

import java.io.*;

public class Serializador {
    public static void serializar(Object objeto, String archivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(objeto);
            out.close();
            fileOut.close();
            System.out.println("Objeto serializado correctamente en " + archivo);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Object deserializar(String archivo) {
        Object objeto = null;
        try {
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            objeto = in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Objeto deserializado correctamente desde " + archivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objeto;
    }
    
}