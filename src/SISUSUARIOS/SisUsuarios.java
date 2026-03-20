package SISUSUARIOS;

import java.util.ArrayList;

public class SisUsuarios {

    private ArrayList<Usuario> usuarios;

    public SisUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void regUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario login(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)
                    && usuario.comprobarContrasena(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    public void mostrarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}