package PERSISTENCIA;

import SISDECIUDAD.Ciudad;
import SISDEEDIFICIO.Edificio;

import java.io.IOException;

public class GestorPartidas {

    private GestorArchivos gestorArchivos;

    public GestorPartidas() {
        gestorArchivos = new GestorArchivos();
    }

    public void guardarPartida(Ciudad ciudad, String ruta) {

        StringBuilder contenido = new StringBuilder();

        contenido.append("ECOCITY SAVE\n");
        contenido.append("Dinero: ").append(ciudad.getDinero()).append("\n");
        contenido.append("Energia: ").append(ciudad.getEnergia()).append("\n");
        contenido.append("Poblacion: ").append(ciudad.getPoblacion()).append("\n");

        contenido.append("EDIFICIOS\n");

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