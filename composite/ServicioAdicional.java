package composite;

public class ServicioAdicional implements Adicional {
    private String nombre;
    private String tipo;
    private double precio;
    private boolean aplicado;

    public ServicioAdicional(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = tipo.equals("Premium") ? 100.0 : 50.0;
    }


    @Override
    public void addBenefit() {
        //Lógica para cambiar beneficios
    }

    @Override
    public void confirmar() {
        this.aplicado = true;
    }

    @Override
    public void cancelar() {
        this.aplicado = false;
    }

    // Existing getters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }

    @Override
    public double getPrecio() { 
        return precio;
    }
}
