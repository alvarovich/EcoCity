package PERSISTENCIA;

import java.io.*;

public class GestorArchivos {

    public void escribirArchivo(String ruta, String contenido) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
        writer.write(contenido);
        writer.close();

    }

    public String leerArchivo(String ruta) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(ruta));
        StringBuilder contenido = new StringBuilder();

        String linea;

        while ((linea = reader.readLine()) != null) {
            contenido.append(linea).append("\n");
        }

        reader.close();

        return contenido.toString();
    }
}