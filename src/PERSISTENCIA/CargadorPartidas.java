package PERSISTENCIA;

import EXCEPCIONES.PartidaNoEncontradaException;

import java.io.IOException;

public class CargadorPartidas {

    private GestorArchivos gestorArchivos;

    public CargadorPartidas() {
        gestorArchivos = new GestorArchivos();
    }

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