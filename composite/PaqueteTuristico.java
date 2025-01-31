package composite;

import java.util.ArrayList;
import java.util.List;


public class PaqueteTuristico implements Component {
    private List<Component> paquete;
    private List<Adicional> adicionales;
    private Info info;

    public static class Info {
        private String nombre;
        private double precioTotal;

        public Info(String nombre, double precioTotal) {
            this.nombre = nombre;
            this.precioTotal = precioTotal;
        }
    }

    public PaqueteTuristico(String nombre) {
        this.paquete = new ArrayList<>();
        this.adicionales = new ArrayList<>();
        this.info = new Info(nombre, 0.0);
    }

    public void agregarComponente(Component reservacion) {
        paquete.add(reservacion);
    }

    public void quitarComponente(Component reservacion) {
        paquete.remove(reservacion);
    }

    public void agregarAdicional(Adicional adicional) {
        adicionales.add(adicional);
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

    public double getPrecio() {
        return info.precioTotal;
    }
}
