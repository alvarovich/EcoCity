package SISUSUARIOS;

public class Jugador extends Usuario {

    private int partidasJugadas;
    private int puntuacion;

    public Jugador(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena, "Jugador");
        this.partidasJugadas = 0;
        this.puntuacion = 0;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void sumarPartida() {
        partidasJugadas++;
    }

    public void sumarPuntuacion(int puntos) {
        puntuacion += puntos;
    }

    @Override
    public String toString() {
        return "Jugador [usuario=" + getNombreUsuario() +
               ", partidasJugadas=" + partidasJugadas +
               ", puntuacion=" + puntuacion + "]";
    }
}