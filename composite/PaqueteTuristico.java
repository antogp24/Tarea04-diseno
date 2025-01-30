package composite;

import java.util.ArrayList;
import java.util.List;


public class PaqueteTuristico implements Component {
    private List<Component> paquete;
    private List<Adicional> adicionales;
    private String nombre;
    private double precioTotal;

    public PaqueteTuristico(String nombre) {
        this.nombre = nombre;
        this.paquete = new ArrayList<>();
        this.adicionales = new ArrayList<>();
        this.precioTotal = 0.0;
    }

    public void agregarComponente(Component reservacion) {
        paquete.add(reservacion);
        calcularPrecioTotal();
    }

    public void quitarComponente(Component reservacion) {
        paquete.remove(reservacion);
        calcularPrecioTotal();
    }

    public void agregarAdicional(Adicional adicional) {
        adicionales.add(adicional);
        calcularPrecioTotal();
    }

    @Override
    public void confirmar() {
        for (Component r : paquete) {
            r.confirmar();
        }
        for (Adicional a : adicionales) {
            a.confirmar();
        }
    }

    @Override
    public void cancelar() {
        for (Component r : paquete) {
            r.cancelar();
        }
    }

    private void calcularPrecioTotal() {
        // Implementar cálculo del precio total
    }

    public double getPrecio() {
        return precioTotal;
    }
}
