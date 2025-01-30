package singleton;

import model.Incidente;

public interface ManejadorIncidentes {
    boolean puedeManejar(Incidente incidente);
    void manejar(Incidente incidente);
}
