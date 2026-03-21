package CODIFICACION;

public class codificacionHash {
	
	public static String codificar(String password) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {

            char letra = password.charAt(i);

            // Generamos un desplazamiento dinámico
            int desplazamiento = (i + letra) % 7 + 1; 
            // valores entre 1 y 7

            // Aplicamos el desplazamiento
            char nuevaLetra = (char) (letra + desplazamiento);

            resultado.append(nuevaLetra);
        }

        return resultado.toString();
    }

}
