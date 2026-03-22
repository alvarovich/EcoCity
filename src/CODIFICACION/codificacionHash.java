package CODIFICACION;

/** Utilidad para encriptar contraseñas con desplazamiento de caracteres */
public class codificacionHash {

	/** Desplaza cada caracter un valor dinamico segun su posicion y valor ASCII */
	public static String codificar(String password) {
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < password.length(); i++) {
			char letra = password.charAt(i);
			// Desplazamiento variable entre 1 y 7 segun posicion y valor del caracter
			int desplazamiento = (i + letra) % 7 + 1;
			char nuevaLetra = (char) (letra + desplazamiento);
			resultado.append(nuevaLetra);
		}
		return resultado.toString();
	}
}