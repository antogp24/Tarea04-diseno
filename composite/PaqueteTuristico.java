package composite;

import java.util.ArrayList;
import java.util.List;


public class PaqueteTuristico implements Reservacion {
    private List<Reservacion> paquete;
    private List<Adicional> adicionales;
    private String nombre;
    private double precioTotal;

    public PaqueteTuristico(String nombre) {
        this.nombre = nombre;
        this.paquete = new ArrayList<>();
        this.adicionales = new ArrayList<>();
        this.precioTotal = 0.0;
    }

    public void agregarComponente(Reservacion reservacion) {
        paquete.add(reservacion);
        calcularPrecioTotal();
    }

    public void quitarComponente(Reservacion reservacion) {
        paquete.remove(reservacion);
        calcularPrecioTotal();
    }

    public void agregarAdicional(Adicional adicional) {
        adicionales.add(adicional);
        calcularPrecioTotal();
    }

    @Override
    public void confirmar() {
        for (Reservacion r : paquete) {
            r.confirmar();
        }
        for (Adicional a : adicionales) {
            a.confirmar();
        }
    }

    @Override
    public void cancelar() {
        for (Reservacion r : paquete) {
            r.cancelar();
        }
    }

    private void calcularPrecioTotal() {
        // Implementar cálculo del precio total
    }

    @Override
    public double getPrecio() {
        return precioTotal;
    }
}
