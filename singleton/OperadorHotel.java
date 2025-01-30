package singleton;

import model.Incidente;

public class OperadorHotel implements ManejadorIncidentes {
    @Override
    public boolean puedeManejar(Incidente incidente) {
        return incidente.getTipo().equals("hotel");
    }

    @Override
    public void manejar(Incidente incidente) {
        // Implementation for handling hotel incidents
    }
}
