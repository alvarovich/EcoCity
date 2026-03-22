package EXCEPCIONES;

/** Excepcion lanzada cuando no se encuentra una partida guardada */
public class PartidaNoEncontradaException extends Exception {

    public PartidaNoEncontradaException() {
        super("No se encontro la partida especificada.");
    }

    public PartidaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}