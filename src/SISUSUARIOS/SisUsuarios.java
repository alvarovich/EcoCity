package SISUSUARIOS;

import java.util.ArrayList;

/** Gestiona el registro y autenticacion de usuarios en memoria */
public class SisUsuarios {

    private ArrayList<Usuario> usuarios;

    public SisUsuarios() {
        usuarios = new ArrayList<>();
    }

    /** Añade un usuario nuevo al sistema */
    public void regUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Busca un usuario por nickname y comprueba su contraseña.
     * Devuelve el usuario si las credenciales son correctas, null si no.
     */
    public Usuario login(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)
                    && usuario.comprobarContrasena(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    /** Muestra por consola todos los usuarios registrados */
    public void mostrarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}