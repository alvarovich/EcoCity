package SISDEEDIFICIO;

public class EdificioComercial extends Edificio implements Mantenible {

    public EdificioComercial() {
        super("Centro Comercial", 4000, 50);
    }

    @Override
    public void aplicarEfectoMensual() {
        System.out.println(nombre + " aumenta la felicidad de la ciudad.");
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

    @Override
    public String toString() {
        return nombre + " [Salud: " + salud + "% | Consume: " + consumoEnergia + " energía]";
    }
}