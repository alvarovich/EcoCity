package SISUSUARIOS;

/** Tipo de usuario jugador. Extiende Usuario añadiendo estadisticas de partida */
public class Jugador extends Usuario {

    private int partidasJugadas;
    private int puntuacion;

    public Jugador(String nombre, String nombreUsuario, String contrasena) {
        super(nombre, nombreUsuario, contrasena, "Jugador");
        this.partidasJugadas = 0;
        this.puntuacion      = 0;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    /** Incrementa el contador de partidas al iniciar una nueva sesion */
    public void sumarPartida() {
        partidasJugadas++;
    }

    public void sumarPuntuacion(int puntos) {
        puntuacion += puntos;
    }

    @Override
    public String toString() {
        return "Jugador [nombre=" + getNombre() +
               ", nickname=" + getNombreUsuario() +
               ", partidasJugadas=" + partidasJugadas +
               ", puntuacion=" + puntuacion + "]";
    }
}