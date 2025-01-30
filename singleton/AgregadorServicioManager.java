package singleton;

import java.util.List;

public class AgregadorServicioManager {
    private static AgregadorServicioManager instance = new AgregadorServicioManager();
    private List<Servicio> serviciosDisponibles;

    private AgregadorServicioManager() {
    }

    public static AgregadorServicioManager getInstance() {
        return instance;
    }

    public void agregarNuevoServicio(Servicio servicio) {
        this.serviciosDisponibles.add(servicio);
    }

    public void quitarServicio(Servicio servicio) {
        this.serviciosDisponibles.remove(servicio);
    }
}
