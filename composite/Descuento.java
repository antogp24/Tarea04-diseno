package composite;

public class Descuento implements Adicional {
    private double porcentaje;
    private boolean aplicado;

    public Descuento(double porcentaje) {
        this.porcentaje = porcentaje;
        this.aplicado = false;
    }

    @Override
    public void addBenefit() {
        //Lógica para agregar beneficios
    }
    @Override
    public void confirmar() {
        this.aplicado = true;
    }

    @Override
    public void cancelar() {
        this.aplicado = false;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public boolean isAplicado() {
        return aplicado;
    }

    @Override
    public double getPrecio(){
        return 0;
    }
}
