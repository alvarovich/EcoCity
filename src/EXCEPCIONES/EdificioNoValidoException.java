package EXCEPCIONES;

/** Excepcion lanzada cuando se intenta usar un edificio que no es valido */
public class EdificioNoValidoException extends Exception {

    public EdificioNoValidoException() {
        super("El edificio seleccionado no es valido.");
    }

    public EdificioNoValidoException(String mensaje) {
        super(mensaje);
    }
}