package PERSISTENCIA;

import EXCEPCIONES.PartidaNoEncontradaException;
import java.io.IOException;

/** Carga una partida guardada previamente desde un archivo de texto */
public class CargadorPartidas {

    private GestorArchivos gestorArchivos;

    public CargadorPartidas() {
        gestorArchivos = new GestorArchivos();
    }

    /** Lee el archivo de la ruta indicada y muestra su contenido. Lanza excepcion si no existe */
    public void cargarPartida(String ruta) throws PartidaNoEncontradaException {
        try {
            String contenido = gestorArchivos.leerArchivo(ruta);
            System.out.println("=== PARTIDA CARGADA ===");
            System.out.println(contenido);
        } catch (IOException e) {
            throw new PartidaNoEncontradaException();
        }
    }
}