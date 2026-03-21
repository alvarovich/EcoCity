package SISDEEDIFICIO;

import ARQDELSIS.Mantenible;

public class ParqueEolico extends EdificioIndustrial implements Mantenible {
	
	public ParqueEolico() {
		super("Parque Eólico", 3000, 0);
	}
	
	@Override
	public double producirRecurso() {
		return 120;
	}
	
	@Override
	public String getTipoRecurso() {
		return "Energia";
	}
	
	@Override
	public void aplicarEfectoMensual() {
		System.out.println(nombre + "genera energía eólica");
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
