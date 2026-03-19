package MTRJUEGO;

import java.util.Scanner;

public class MotorSimulacion {
	
	private Ciudad ciudad;
	private int mes;
	private Scanner sc;
	
	public MotorSimulacion() {
		ciudad = new Ciudad();
		mes = 1;
		sc = new Scanner (System.in);
	}
	
	public void Iniciar () {
		boolean ejecutando = true;
		
		while (ejecutando) {
			
			ciudad.mostrarEstado(mes);
			mostrarMenu();
			
			int opcion = sc.nextInt();
			
			switch (opcion) {
				case 1:
					construir();
					break;
					
				case 2:
					reparar();
					break;
				
				case 3:
					cicloMensual();
					break;
					
				case 4:
					ejecutando = false;
					System.out.println("Saliendo del juego...");
					break;
				
				default:
					System.out.println("Elige una opción del menú");
					break;
				
			}
			
		}
	}
	
	private void mostrarMenu() {

	    System.out.println("\n¿Qué desea hacer?");
	    System.out.println("1. Construir");
	    System.out.println("2. Reparar");
	    System.out.println("3. Pasar Mes");
	    System.out.println("4. Guardar y Salir");

	}
	
	private void cicloMensual() {
		ciudad.calcularRecursos();
		
		for (Edificio e : ciudad.getEdificio()) {
			e.aplicarEfectoMensual();
		}
		
		SistemaClima.generarEvento(ciudad);
		
		mes++;
	}
}
