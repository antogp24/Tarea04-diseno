package builder;

import composite.*;

import java.util.ArrayList;
import java.util.List;

public class PaqueteAdicionales {
    private List<Adicional> adicionales;

    public PaqueteAdicionales() {
        adicionales = new ArrayList<>();
    }

    public void reset() {
        adicionales.clear();
    }

    public void agregarDescuento(double porcentaje) {
        Descuento descuento = new Descuento(porcentaje);
        adicionales.add(descuento);
    }

    public void agregarServicioAdicional(ServicioAdicional servicio) {
        adicionales.add(servicio);
    }

    public List<Adicional> getAdicionales() {
        return adicionales;
    }
}
