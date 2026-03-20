package SISUSUARIOS;

public class Administrador extends Usuario {

    public Administrador(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena, "Administrador");
    }

    public void mostrarPermisos() {
        System.out.println("El administrador puede gestionar usuarios y partidas.");
    }

    @Override
    public String toString() {
        return "Administrador [usuario=" + getNombreUsuario() + "]";
    }
}