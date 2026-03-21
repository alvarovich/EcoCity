package EXCEPCIONES;

public class FondosInsuficientesException extends Exception {

    public FondosInsuficientesException() {
        super("No tienes suficiente dinero para realizar esta acción.");
    }

    public FondosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}