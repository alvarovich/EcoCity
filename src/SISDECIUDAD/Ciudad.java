package SISDECIUDAD;

import java.util.ArrayList;
import SISDEEDIFICIO.Edificio;
import SISDEEDIFICIO.GeneradorRecursos;
import SISDEEDIFICIO.EdificioResidencial;
import SISDEEDIFICIO.EdificioComercial;
import EXCEPCIONES.FondosInsuficientesException;

public class Ciudad {

    private int dinero;
    private int energia;
    private int poblacion;
    private int felicidad;
    private ArrayList<Edificio> edificios;

    public Ciudad() {
        dinero    = 8000;
        energia   = 0;
        poblacion = 0;
        felicidad = 100;
        edificios = new ArrayList<>();
    }

    public void agregarEdificio(Edificio edificio) throws FondosInsuficientesException {
        if (dinero < edificio.getCosto()) {
            throw new FondosInsuficientesException(
                "No tienes suficiente dinero para construir " + edificio.getNombre() +
                ". Necesitas " + edificio.getCosto() + "EUR y tienes " + dinero + "EUR."
            );
        }
        dinero -= edificio.getCosto();
        edificios.add(edificio);
        System.out.println(edificio.getNombre() + " construido. Costo: " + edificio.getCosto() + "EUR");
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getEnergia() {
        return energia;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public void mostrarEstado(int mes) {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("   ECOCITY - MES " + mes);
        System.out.println("══════════════════════════════════════");
        System.out.printf("  Dinero:     %dEUR%n", dinero);
        System.out.printf("  Energia:    %d MW%n", energia);
        System.out.printf("  Poblacion:  %d%n", poblacion);
        System.out.printf("  Felicidad:  %d%%%n", felicidad);
        System.out.println("--------------------------------------");
        if (edificios.isEmpty()) {
            System.out.println("  (Sin edificios construidos)");
        } else {
            System.out.println("  Edificios:");
            for (int i = 0; i < edificios.size(); i++) {
                System.out.println("    " + (i + 1) + ". " + edificios.get(i));
            }
        }
        System.out.println("══════════════════════════════════════");
    }

    public void calcularRecursos() {
        energia = 0;

        for (Edificio e : edificios) {

            if (e instanceof GeneradorRecursos) {
                GeneradorRecursos g = (GeneradorRecursos) e;
                energia += (int) g.producirRecurso();
            }

            energia -= e.getConsumoEnergia();

            if (e instanceof EdificioResidencial) {
                poblacion += 50;
                dinero    += 200;
                System.out.println("  Impuestos recaudados: +200EUR");
            }

            if (e instanceof EdificioComercial) {
                dinero    += 350;
                felicidad += 5;
                if (felicidad > 100) felicidad = 100;
                System.out.println("  Ingresos comerciales: +350EUR");
            }
        }

        if (energia < 0) {
            felicidad -= 10;
            if (felicidad < 0) felicidad = 0;
            System.out.println("Falta de energia (" + energia + " MW): la felicidad disminuye.");
        }
    }
}