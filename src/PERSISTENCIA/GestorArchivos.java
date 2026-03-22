package PERSISTENCIA;

import java.io.*;

/** Utilidad de bajo nivel para leer y escribir archivos de texto */
public class GestorArchivos {

    /** Escribe el contenido en el archivo indicado, sobreescribiendo si ya existe */
    public void escribirArchivo(String ruta, String contenido) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
        writer.write(contenido);
        writer.close();
    }

    /** Lee un archivo de texto y devuelve su contenido como String */
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