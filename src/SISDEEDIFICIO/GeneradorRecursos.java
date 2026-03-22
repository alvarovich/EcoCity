package SISDEEDIFICIO;

/** Contrato para edificios que producen algun tipo de recurso */
public interface GeneradorRecursos {
    double producirRecurso();
    String getTipoRecurso();
}