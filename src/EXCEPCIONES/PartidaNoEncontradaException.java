package EXCEPCIONES;

public class PartidaNoEncontradaException extends Exception {

    public PartidaNoEncontradaException() {
        super("No se encontró la partida especificada.");
    }

    public PartidaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}