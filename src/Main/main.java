package Main;

import MTRJUEGO.MotorSimulacion;

/** Punto de entrada de la aplicacion */
public class main {

    public static void main(String[] args) {
        try {
            MotorSimulacion juego = new MotorSimulacion();
            juego.iniciar();
        } catch (Exception e) {
            System.out.println("Error en la ejecucion del juego: " + e.getMessage());
        }
    }
}