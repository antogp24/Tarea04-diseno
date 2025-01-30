package composite;

public class Descuento implements Adicional {
    private double porcentaje;
    private boolean aplicado;

    public Descuento(double porcentaje) {
        this.porcentaje = porcentaje;
        this.aplicado = false;
    }

    @Override
    public void confirmar() {
        this.aplicado = true;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public boolean isAplicado() {
        return aplicado;
    }
}
