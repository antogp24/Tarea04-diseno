package singleton;

import model.Incidente;

public class OperadorTuristico implements ManejadorIncidentes {
    private String datosOperador;

    @Override
    public void manejar(Incidente incidente) {
        // ...
    }

    public boolean puedeManejar(Incidente incidente) {
        return true;
    }
}
