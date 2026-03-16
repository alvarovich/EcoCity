package SISDEEDIFICIO;

import ARQDELSIS.Edificio;
import ARQDELSIS.Mantenible;

public class EdificioResidencial extends Edificio implements Mantenible{

	private int habitantes;
	
	public EdificioResidencial ( String nombre, int costo, int consumoEnergia, int habitantes) {
		super(nombre, costo, consumoEnergia);
		this.habitantes = habitantes;
	}

	@Override
	public void aplicarEfectoMensual() {
		System.out.println(nombre + "genera impuestos de sus habitantes.");
	}
		
	@Override
	public void reparar() {
		salud = 100;
	}
	
	@Override
	public void desgastar(int cantidad) {
		salud -= cantidad;
		if (salud < 0) salud = 0;
	}
	
}
