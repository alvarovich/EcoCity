package SISUSUARIOS;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {

    private String nombreUsuario;
    private String passwordHash;
    private String rol;

    public Usuario(String nombreUsuario, String contrasena, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.passwordHash = generarHash(contrasena);
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getRol() {
        return rol;
    }

    public boolean comprobarContrasena(String contrasena) {
        String hashIntroducido = generarHash(contrasena);
        return passwordHash.equals(hashIntroducido);
    }

    private String generarHash(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(texto.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash de contraseña");
        }
    }

    @Override
    public String toString() {
        return "Usuario [nombreUsuario=" + nombreUsuario + ", rol=" + rol + "]";
    }
}