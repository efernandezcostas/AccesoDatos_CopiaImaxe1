import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/*
   1.   a) La imágen cambia a la copiada y pesan lo mismo (foto2 ahora es como foto1)
        b) La imágen pesa aún más que antes. La imágen no cambia, solo va aumentando el peso del archivo.
 */

public class Main {
    public static void main(String[] args) {
        Operaciones op = new Operaciones();
        op.leerArchivo("/home/dam/Work/Clase/AccesoDatos/ExercicioCopiaImaxe/foto.jpeg");
        op.escribirArchivo("/home/dam/Work/Clase/AccesoDatos/ExercicioCopiaImaxe/foto2.jpeg");
    }
}

class Operaciones {
    ArrayList<Integer> listaBytes = new ArrayList<Integer>();

    public void leerArchivo (String dirName) {

        int lbyte = 0;

        try {
            try (FileInputStream fis = new FileInputStream(dirName)) {
                do {
                    lbyte = fis.read();
                    if (lbyte != -1) {
                        listaBytes.add(lbyte);
                    }
                } while (lbyte != -1);
            }

        } catch (IOException e) {
            System.out.println("No se encontró el archivo");
        }
    }

    public void escribirArchivo (String dirName) {

        try {

            //try (FileOutputStream fos = new FileOutputStream(dirName)) {
            // La línea anterior era antes de los cambios del ejercicio 2

            try (FileOutputStream fos = new FileOutputStream(dirName, true)) {
                for (Integer listaByte : listaBytes) {
                    fos.write(listaByte);
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontró el archivo");
        }

    }
}