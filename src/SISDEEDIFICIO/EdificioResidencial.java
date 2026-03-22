package SISDEEDIFICIO;

public class EdificioResidencial extends Edificio implements Mantenible {

    private int habitantes;

    public EdificioResidencial(String nombre, int costo, int consumoEnergia, int habitantes) {
        super(nombre, costo, consumoEnergia, 300);  // costeReparacion: 300€
        this.habitantes = habitantes;
    }

    @Override
    public void aplicarEfectoMensual() {
        System.out.println(nombre + " genera impuestos de sus " + habitantes + " habitantes.");
    }

    @Override
    public void reparar() { salud = 100; }

    @Override
    public void desgastar(int cantidad) {
        salud -= cantidad;
        if (salud < 0) salud = 0;
    }

    public int getHabitantes() { return habitantes; }

    @Override
    public String toString() {
        return nombre + " [Salud: " + salud + "% | Habitantes: " + habitantes + " | Reparación: " + costeReparacion + "€]";
    }
}