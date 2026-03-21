package PERSISTENCIA;

import SISUSUARIOS.Usuario;

import java.io.IOException;
import java.util.ArrayList;

public class GestorUsuariosArchivo {

    private GestorArchivos gestorArchivos;

    public GestorUsuariosArchivo() {
        gestorArchivos = new GestorArchivos();
    }

    public void guardarUsuarios(ArrayList<Usuario> usuarios, String ruta) {

        StringBuilder contenido = new StringBuilder();

        for (Usuario u : usuarios) {
            contenido.append(u.toString()).append("\n");
        }

        try {
            gestorArchivos.escribirArchivo(ruta, contenido.toString());
            System.out.println("Usuarios guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar usuarios.");
        }
    }
}