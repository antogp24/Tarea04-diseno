package singleton;

import model.*;

public class AgenteSoporte implements ManejadorIncidentes {
    private String datosAgente;

    @Override
    public void manejar(Incidente incidente) {
        // ...
    }

    public boolean puedeManejar(Incidente incidente) {
        return true;
    }
}
