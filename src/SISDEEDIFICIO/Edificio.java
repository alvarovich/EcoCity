package SISDEEDIFICIO;

/**
 * Clase abstracta base de todos los edificios del juego.
 * Define los atributos comunes y obliga a implementar el efecto mensual.
 */
public abstract class Edificio {

    protected String nombre;
    protected int costo;
    // Energia que consume el edificio cada mes
    protected int consumoEnergia;
    // Salud entre 0 y 100; llegar a 0 tiene consecuencias para la ciudad
    protected int salud;
    protected int costeReparacion;

    public Edificio(String nombre, int costo, int consumoEnergia, int costeReparacion) {
        this.nombre          = nombre;
        this.costo           = costo;
        this.consumoEnergia  = consumoEnergia;
        this.costeReparacion = costeReparacion;
        this.salud           = 100;
    }

    /** Cada subclase define que ocurre cuando pasa un mes */
    public abstract void aplicarEfectoMensual();

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }

    public int getSalud() {
        return salud;
    }

    public int getCosteReparacion() {
        return costeReparacion;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    @Override
    public String toString() {
        return nombre + " [Salud: " + salud + "%]";
    }
}