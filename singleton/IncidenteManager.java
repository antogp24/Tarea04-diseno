package singleton;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class IncidenteManager {
    private static IncidenteManager instance = new IncidenteManager();
    private List<ManejadorIncidentes> manejadores;
    private List<Incidente> incidentesPendientes;

    private IncidenteManager() {
        manejadores = new ArrayList<>();
        incidentesPendientes = new ArrayList<>();
        inicializarManejadores();
    }

    private void inicializarManejadores() {
        manejadores.add(new AgenteSoporte());
        manejadores.add(new OperadorHotel());
        manejadores.add(new OperadorTuristico());
    }

    public static IncidenteManager getInstance() {
        return instance;
    }

    public void reportarIncidente(Incidente incidente) {
        incidentesPendientes.add(incidente);
        procesarIncidente(incidente);
    }

    private void procesarIncidente(Incidente incidente) {
        for (ManejadorIncidentes manejador : manejadores) {
            if (manejador.puedeManejar(incidente)) {
                manejador.manejar(incidente);
                break;
            }
        }
    }
}
