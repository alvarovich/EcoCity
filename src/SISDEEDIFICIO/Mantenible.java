package SISDEEDIFICIO;

/** Contrato para edificios que pueden deteriorarse y repararse */
public interface Mantenible {
    void reparar();
    void desgastar(int cantidad);
}