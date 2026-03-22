package SISUSUARIOS;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Representa a cualquier usuario del sistema.
 * La contraseña nunca se guarda en texto plano, solo su hash SHA-256.
 */
public class Usuario {

    private String nombre;
    private String nombreUsuario;
    // Se almacena el hash, nunca la contraseña original
    private String passwordHash;
    private String rol;

    public Usuario(String nombre, String nombreUsuario, String contrasena, String rol) {
        this.nombre        = nombre;
        this.nombreUsuario = nombreUsuario;
        this.passwordHash  = generarHash(contrasena);
        this.rol           = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getRol() {
        return rol;
    }

    /** Hashea la contraseña introducida y la compara con la almacenada */
    public boolean comprobarContrasena(String contrasena) {
        return passwordHash.equals(generarHash(contrasena));
    }

    /** Genera el hash SHA-256 de un texto y lo devuelve en hexadecimal */
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
            throw new RuntimeException("Error al generar hash de contrasena");
        }
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", nickname=" + nombreUsuario + ", rol=" + rol + "]";
    }
}