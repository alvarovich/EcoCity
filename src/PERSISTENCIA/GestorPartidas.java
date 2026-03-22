package PERSISTENCIA;

import SISDECIUDAD.Ciudad;
import SISDEEDIFICIO.Edificio;
import java.io.IOException;

/** Guarda el estado actual de la ciudad en un archivo de texto */
public class GestorPartidas {

    private GestorArchivos gestorArchivos;

    public GestorPartidas() {
        gestorArchivos = new GestorArchivos();
    }

    /** Serializa los recursos y edificios de la ciudad y los escribe en el archivo indicado */
    public void guardarPartida(Ciudad ciudad, String ruta) {
        StringBuilder contenido = new StringBuilder();

        contenido.append("ECOCITY SAVE\n");
        contenido.append("Dinero: ").append(ciudad.getDinero()).append("\n");
        contenido.append("Energia: ").append(ciudad.getEnergia()).append("\n");
        contenido.append("Poblacion: ").append(ciudad.getPoblacion()).append("\n");
        contenido.append("EDIFICIOS\n");

        // Recorremos la lista y usamos el toString de cada edificio
        for (Edificio e : ciudad.getEdificios()) {
            contenido.append(e.toString()).append("\n");
        }

        try {
            gestorArchivos.escribirArchivo(ruta, contenido.toString());
            System.out.println("Partida guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la partida.");
        }
    }
}