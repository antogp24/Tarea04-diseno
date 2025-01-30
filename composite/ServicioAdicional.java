package composite;

public class ServicioAdicional implements Adicional {
    private String nombre;
    private String tipo;
    private double precio;

    public ServicioAdicional(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = tipo.equals("Premium") ? 100.0 : 50.0;
    }

    @Override
    public void confirmar() {
        // Implementation for confirmar method
    }

    // Existing getters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }
}
