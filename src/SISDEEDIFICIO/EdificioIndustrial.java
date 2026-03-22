package SISDEEDIFICIO;

import SISDEEDIFICIO.Edificio;
import SISDEEDIFICIO.GeneradorRecursos;

public abstract class EdificioIndustrial extends Edificio implements GeneradorRecursos {

    public EdificioIndustrial(String nombre, int costo, int consumoEnergia, int costeReparacion) {
        super(nombre, costo, consumoEnergia, costeReparacion);
    }
}