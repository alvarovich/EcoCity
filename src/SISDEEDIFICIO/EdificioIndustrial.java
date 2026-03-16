package SISDEEDIFICIO;

import ARQDELSIS.Edificio;
import ARQDELSIS.GeneradorRecursos;

public abstract class EdificioIndustrial extends Edificio implements GeneradorRecursos{

	public EdificioIndustrial (String nombre, int costo, int consumoEnergia) {
		super(nombre, costo, consumoEnergia);
	}
}
