package SISDEEDIFICIO;

public abstract class Edificio {

    protected String nombre;
    protected int costo;
    protected int consumoEnergia;
    protected int salud;
    protected int costeReparacion;

    public Edificio(String nombre, int costo, int consumoEnergia, int costeReparacion) {
        this.nombre           = nombre;
        this.costo            = costo;
        this.consumoEnergia   = consumoEnergia;
        this.costeReparacion  = costeReparacion;
        this.salud            = 100;
    }

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
    public int getSalud() { return salud;
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