package SISDECIUDAD;

import java.util.ArrayList;
import SISDEEDIFICIO.Edificio;
import SISDEEDIFICIO.GeneradorRecursos;
import SISDEEDIFICIO.EdificioResidencial;
import SISDEEDIFICIO.EdificioComercial;

public class Ciudad {

    private int dinero;
    private int energia;
    private int poblacion;
    private int felicidad;
    private ArrayList<Edificio> edificios;

    public Ciudad() {
        dinero = 5000;
        energia = 0;
        poblacion = 1000;
        felicidad = 100;
        edificios = new ArrayList<>();
    }

    public void agregarEdificio(Edificio edificio) {
        edificios.add(edificio);
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    public int getDinero() { return dinero; }
    public void setDinero(int dinero) { this.dinero = dinero; }

    public int getEnergia() { return energia; }
    public int getPoblacion() { return poblacion; }
    public int getFelicidad() { return felicidad; }

    public void mostrarEstado(int mes) {

        System.out.println("\n--- ESTADO DE ECOCITY - MES " + mes + " ---");
        System.out.println("Recursos: $" + dinero +
                " | Energía: " + energia +
                " | Población: " + poblacion +
                " | Felicidad: " + felicidad);

        System.out.println("Edificios:");

        for (int i = 0; i < edificios.size(); i++) {
            System.out.println((i + 1) + ". " + edificios.get(i));
        }
    }

    public void calcularRecursos() {

        energia = 0;

        for (Edificio e : edificios) {

            // PRODUCCIÓN
            if (e instanceof GeneradorRecursos) {
                GeneradorRecursos g = (GeneradorRecursos) e;
                energia += g.producirRecurso();
            }

            // CONSUMO
            energia -= e.getConsumoEnergia();

            // RESIDENCIAL
            if (e instanceof EdificioResidencial) {
                poblacion += 50;
                dinero += 100;
            }

            // COMERCIAL
            if (e instanceof EdificioComercial) {
                dinero += 200;
                felicidad += 5;
            }
        }

        if (energia < 0) {
            felicidad -= 10;
            System.out.println("Falta de energía: la felicidad disminuye");
        }
    }
}