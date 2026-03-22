package SISDECIUDAD;
import java.util.ArrayList;

public class Ciudad {

	private int dinero;
	private int energia;
	private int poblacion;
	private ArrayList<Edificio>edificios;
	
	public Ciudad() {
		dinero = 5000;
		energia = 0;
		poblacion = 1000;
		edificios = new ArrayList<>();
	}
	
	public void agregarEdificio(Edificio edificio) {
		edificios.add(edificio);
	}
	
	public ArrayList<Edificio>getEdificios(){
		return edificios;
	}
	
	public int getDinero() {
	    return dinero;
	}

	public int getEnergia() {
	    return energia;
	}

	public int getPoblacion() {
	    return poblacion;
	}	
	
	public void mostrarEstado (int mes) {
		System.out.println("\n--- ESTADO DE ECOCITY - MES " + mes + " ---");
		System.out.println("Recursos: $" + dinero + " | Energía: +" + energia + "MW | Población: " + poblacion);
		
		System.out.println("Edificios construidos: ");
		
		for(int i = 0; i < edificios.size(); i++) {
			System.out.println((i + 1) + "." + edificios.get(i));
		}
	}
	
	public void pasarMes() {
		
		energia = 0;
		for (Edificio edificio : edificios) {
			
			edificio.aplicarEfectoMensual();
			
			if(edificio instanceof GeneradorRecursos) {
				GeneradorRecursos generador = (GeneradorRecursos) edificio;
				energia += generador.producirRecurso();
			}
		}
	}
	
}
