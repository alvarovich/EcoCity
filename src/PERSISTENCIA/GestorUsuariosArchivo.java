package PERSISTENCIA;

import SISUSUARIOS.Jugador;
import SISUSUARIOS.Usuario;

import java.io.IOException;
import java.util.ArrayList;

public class GestorUsuariosArchivo {

    private GestorArchivos gestorArchivos;
    private static final String RUTA = "usuarios.txt";

    public GestorUsuariosArchivo() {
        gestorArchivos = new GestorArchivos();
    }

    public void guardarJugador(Jugador jugador) {
        try {
            String contenido = "";

            // Leemos lo que ya hay para no sobreescribir
            try {
                contenido = gestorArchivos.leerArchivo(RUTA);
            } catch (IOException e) {
                // Si no existe el archivo aun, empezamos vacio
            }

            contenido += jugador.getNombre() + ";" +
                         jugador.getNombreUsuario() + "\n";

            gestorArchivos.escribirArchivo(RUTA, contenido);
            System.out.println("Datos del jugador guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar los datos del jugador.");
        }
    }

    public ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        // Este metodo queda disponible para futuras ampliaciones
        return lista;
    }
}