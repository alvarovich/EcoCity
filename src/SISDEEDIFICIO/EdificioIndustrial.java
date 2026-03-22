package SISDEEDIFICIO;

/**
 * Edificio industrial abstracto. Hereda de Edificio e implementa
 * GeneradorRecursos, sirviendo de base para CentralNuclear y ParqueEolico.
 * Representa el segundo nivel de la jerarquia de herencia.
 */
public abstract class EdificioIndustrial extends Edificio implements GeneradorRecursos {

    public EdificioIndustrial(String nombre, int costo, int consumoEnergia, int costeReparacion) {
        super(nombre, costo, consumoEnergia, costeReparacion);
    }
}