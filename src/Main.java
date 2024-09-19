import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/*
   1.   a) La imágen pesa más que antes
        b) La imágen pesa aún más que antes. La imágen no cambia, solo el peso del archivo.
 */

public class Main {
    public static void main(String[] args) {
        Operaciones op = new Operaciones();
        op.leerArchivo("foto.jpeg");
        op.escribirArchivo("foto2.jpeg");
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

        for (int i = 0; i < listaBytes.size(); i++) {
            System.out.println(listaBytes.get(i));
        }
    }

    public void escribirArchivo (String dirName) {

        try {

            //try (FileOutputStream fos = new FileOutputStream(dirName)) {
            // La línea anterior era antes de los cambios del ejercicio 2

            try (FileOutputStream fos = new FileOutputStream(dirName, true)) {
                for (int i = 0; i < listaBytes.size(); i++) {
                    fos.write(listaBytes.get(i));
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontró el archivo");
        }

    }
}