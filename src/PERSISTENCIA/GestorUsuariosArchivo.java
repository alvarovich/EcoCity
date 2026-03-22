package PERSISTENCIA;

import SISUSUARIOS.Jugador;
import SISUSUARIOS.Usuario;
import java.io.IOException;
import java.util.ArrayList;

/** Guarda los datos del jugador en un archivo para dejar constancia del registro */
public class GestorUsuariosArchivo {

    private GestorArchivos gestorArchivos;
    private static final String RUTA = "usuarios.txt";

    public GestorUsuariosArchivo() {
        gestorArchivos = new GestorArchivos();
    }

    /** Añade el nombre y nickname del jugador al archivo, sin sobreescribir registros anteriores */
    public void guardarJugador(Jugador jugador) {
        try {
            String contenido = "";

            // Si el archivo ya existe, conservamos su contenido
            try {
                contenido = gestorArchivos.leerArchivo(RUTA);
            } catch (IOException e) {
                // El archivo no existe aun, se creara al escribir
            }

            contenido += jugador.getNombre() + ";" + jugador.getNombreUsuario() + "\n";
            gestorArchivos.escribirArchivo(RUTA, contenido);
            System.out.println("Datos del jugador guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar los datos del jugador.");
        }
    }

    /** Reservado para futuras ampliaciones de carga de usuarios */
    public ArrayList<Usuario> cargarUsuarios() {
        return new ArrayList<>();
    }
}