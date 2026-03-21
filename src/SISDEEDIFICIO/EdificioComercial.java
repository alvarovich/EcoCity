package SISDEEDIFICIO;

import ARQDELSIS.Edificio;
import ARQDELSIS.Mantenible;

public class EdificioComercial extends Edificio implements Mantenible {

	public EdificioComercial() {
		super("Centro Comercial " , 4000, 50);
	}
	
	@Override
	public void aplicarEfectoMensual() {
		System.out.println("El comercio aumenta la felicidad de la ciudad.");
	}
	
	@Override
	public void reparar() {
		salud = 100;
	}
	
	@Override
	public void desgastar(int cantidad) {
		salud -= cantidad;
	}
}
