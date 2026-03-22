package Main;

import MTRJUEGO.MotorSimulacion;

public class main {

    public static void main(String[] args) {

        try {

            MotorSimulacion juego = new MotorSimulacion();
            juego.iniciar();

        } catch (Exception e) {

            System.out.println("Error en la ejecución del juego: " + e.getMessage());
        }
    }
}