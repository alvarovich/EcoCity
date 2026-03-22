package SISDEEDIFICIO;

public class CentralNuclear extends EdificioIndustrial implements Mantenible {

    public CentralNuclear() {
        super("Central Nuclear", 10000, 0);
    }

    @Override
    public double producirRecurso() {
        return 500;
    }

    @Override
    public String getTipoRecurso() {
        return "Energia";
    }

    @Override
    public void aplicarEfectoMensual() {

        if (salud < 20) {
            throw new RuntimeException("💥 Explosión en la central nuclear!");
        }
    }

    @Override
    public void reparar() {
        salud = 100;
    }

    @Override
    public void desgastar(int cantidad) {
        salud -= cantidad;
        if (salud < 0) salud = 0;
    }
}