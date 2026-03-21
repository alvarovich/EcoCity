package EXCEPCIONES;

public class EdificioNoValidoException extends Exception {

    public EdificioNoValidoException() {
        super("El edificio seleccionado no es válido.");
    }

    public EdificioNoValidoException(String mensaje) {
        super(mensaje);
    }
}