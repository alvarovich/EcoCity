package EXCEPCIONES;

/** Excepcion lanzada cuando el jugador no tiene dinero suficiente para construir */
public class FondosInsuficientesException extends Exception {

    public FondosInsuficientesException() {
        super("No tienes suficiente dinero para realizar esta accion.");
    }

    public FondosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}